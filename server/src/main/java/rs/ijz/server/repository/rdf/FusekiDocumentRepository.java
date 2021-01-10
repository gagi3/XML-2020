package rs.ijz.server.repository.rdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import rs.ijz.server.service.MetadataExtractorService;
import rs.ijz.server.util.rdf.FusekiConnectionProperties;
import rs.ijz.server.util.rdf.MetadataStatus;

@Repository
public class FusekiDocumentRepository {

	@Autowired
	FusekiConnectionProperties conn;

	private static int connected = 0;
	
	private static final String SPARQL_NAMED_GRAPH_URI = "/resenje/sparql/metadata";
	
	// @TODO: Switch to global values
	private static final String METADATA_RDF_FILES_PATH = "./src/main/resources/output/metadata/rdf";
	private static final String METADATA_JSON_FILES_PATH = "./src/main/resources/output/metadata/json";
	
	public void saveToRDFFile(String name, InputStream inputStream) throws SAXException, IOException {
		MetadataExtractorService metadataExtractor = new MetadataExtractorService();
		File directory = new File(METADATA_RDF_FILES_PATH);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		System.out.println("[INFO] Writing to RDF file...");
		try {
			metadataExtractor.extractMetadata(
					inputStream, 
					new FileOutputStream(new File(METADATA_RDF_FILES_PATH + "/" + name)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveToJSONFile(String name, ArrayNode arrayNode) throws IOException {
		File directory = new File(METADATA_JSON_FILES_PATH);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(METADATA_JSON_FILES_PATH + "/" + name), arrayNode);
	}

	public MetadataStatus validateMetadata(String xmlContent) throws Exception {
		System.out.println("[INFO] Validating XML metadata");
		MetadataExtractorService metadataExtractor = new MetadataExtractorService();

		InputStream inputStream = new ByteArrayInputStream(xmlContent.getBytes());

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		System.out.println("[INFO] Extracting metadata from RDFa attributes...");
		metadataExtractor.extractMetadata(inputStream, outputStream);

		String os = new String(outputStream.toByteArray());

		if (os.contains("<!--Could not produce the triple for:")) {
			return MetadataStatus.INVALID;
		}

		if (!os.contains("rdf:Description")) {
			return MetadataStatus.EMPTY;
		}

		return MetadataStatus.VALID;
	}

	public void extractMetadata(String xmlContent, String fileName)
			throws Exception {

		if (connected == 0) {
			AuthenticationUtilities.createDataset(conn);
			connected = 1;
		}

		System.out.println("[INFO] " + FusekiDocumentRepository.class.getSimpleName());

		MetadataStatus status = this.validateMetadata(xmlContent);
		
		if (status == MetadataStatus.INVALID) {
			System.out.println("[ERROR] Extracting metadata from RDFa attributes...");
			return;
		} else if (status == MetadataStatus.EMPTY) {
			System.out.println("[INFO] No metadata");
			return;
		}

		// Automatic extraction of RDF triples from XML file
		MetadataExtractorService metadataExtractor = new MetadataExtractorService();

		InputStream inputStream = new ByteArrayInputStream(xmlContent.getBytes());

		this.saveToRDFFile(fileName + ".rdf", new ByteArrayInputStream(xmlContent.getBytes()));

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		System.out.println("[INFO] Extracting metadata from RDFa attributes...");
		metadataExtractor.extractMetadata(inputStream, outputStream);

		String os = new String(outputStream.toByteArray());
		System.out.println("OS : " + os);

		// Loading a default model with extracted metadata
		Model model = ModelFactory.createDefaultModel();
		model.read(new ByteArrayInputStream(outputStream.toByteArray()), null);

		// write to System.out
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayOutputStream outXml = new ByteArrayOutputStream();
		model.write(out, SparqlUtil.NTRIPLES);
		model.write(outXml, SparqlUtil.RDF_XML);

		XmlMapper xmlMapper = new XmlMapper();
		ArrayNode json = xmlMapper.readValue(outXml.toByteArray(), ArrayNode.class);
		System.out.println(json.toString());
		this.saveToJSONFile(fileName + ".json", json);

		System.out.println("[INFO] Extracted metadata as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		// Writing the named graph
		System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "\" with extracted metadata.");
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI,
				new String(out.toByteArray()));
		System.out.println(sparqlUpdate);

		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		processor.execute();

		// Read the triples from the named graph
		System.out.println();
		System.out.println("[INFO] Retrieving triples from RDF store.");
		System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

		System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
		String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

		// Query the collection, dump output response as XML
		ResultSet results = query.execSelect();

		ResultSetFormatter.out(System.out, results);

		query.close();

		System.out.println("[INFO] End.");
	}

}
