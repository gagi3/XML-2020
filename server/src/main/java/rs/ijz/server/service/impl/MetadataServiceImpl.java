package rs.ijz.server.service.impl;

import java.io.ByteArrayOutputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import rs.ijz.server.service.MetadataService;

@Service
public class MetadataServiceImpl implements MetadataService {
	
	@Value("${jenna.endpoint}")
    private String endpoint;

    @Value("${jenna.dataset}")
    private String dataSet;

    @Value("${jenna.data}")
    private String data;

    @Value("${jenna.update}")
    private String update;
	
	private static String RDF_XML = "RDF/XML";
    private static String NTRIPLES = "N-TRIPLES";
    
    private static String GRAPH_URI = "/resenje/metadata";
    private static String UPDATE_TEMPLATE_NAMED_GRAPH = "INSERT DATA { GRAPH <%1$s> { %2$s } }";

	@Override
	public void metadataWrite(String filePath) {
		String dataEndpoint = String.join("/", endpoint, dataSet, data);
        String updateEndpoint = String.join("/", endpoint, dataSet, update);

        // Creates a default model
        Model model = ModelFactory.createDefaultModel();
        model.read(filePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, NTRIPLES);

        model.write(System.out, RDF_XML);

        UpdateRequest request = UpdateFactory.create() ;

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, updateEndpoint);
        processor.execute();

        // Creating the first named graph and updating it with RDF data
        String sparqlUpdate = insertData(dataEndpoint + GRAPH_URI, new String(out.toByteArray()));

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        processor = UpdateExecutionFactory.createRemote(update, updateEndpoint);
        processor.execute();

	}
	
	public static String insertData(String graphURI, String ntriples) {
        return String.format(UPDATE_TEMPLATE_NAMED_GRAPH, graphURI, ntriples);
    }

}
