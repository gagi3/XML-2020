package rs.ijz.server.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import rs.ijz.server.service.MetadataExtractorService;
import rs.ijz.server.util.FileReader;

@Service
public class MetadataExtractorServiceImpl implements MetadataExtractorService {
	
	@Value("${grddl.path.transformation}")
    private String grddlXslTransformationFilePath;

    @Value("${grddl.path.output-folder}")
    private String grddlOutputFolder;

	@Override
	public String extractMetadataToRdf(InputStream in, String id) throws Exception {
		StreamSource transformSource = new StreamSource(new File(grddlXslTransformationFilePath));
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer grddlTransformer = null;

        try {
            grddlTransformer = factory.newTransformer(transformSource);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            throw new Exception("Failed to initialize GRDDL transformer");
        }

        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        String outputFilePath = this.grddlOutputFolder + id + ".xml";

        StreamSource source = new StreamSource(in);
        StreamResult result = null;

        try {
            result = new StreamResult(new FileOutputStream(outputFilePath));
        } catch (FileNotFoundException e) {
            throw new Exception("Error while creating output file.");
        }

        try {
            grddlTransformer.transform(source, result);
        } catch (TransformerException e) {
            throw new Exception("Error while extracting metadata to RDF.");
        }

        String rdfXmlResult = FileReader.readFromFile(outputFilePath);
        File outputFile = new File(outputFilePath);
        outputFile.delete();

        return rdfXmlResult;
	}
	
	@Override
	public String extractMetadataToRdf(String xmlData) throws Exception {
		StreamSource transformSource = new StreamSource(new File(grddlXslTransformationFilePath));
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer grddlTransformer = null;

        try {
            grddlTransformer = factory.newTransformer(transformSource);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            throw new Exception("Failed to initialize GRDDL transformer");
        }

        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        String outputFilePath = this.grddlOutputFolder + UUID.randomUUID().toString() + ".xml";

        StreamSource source = new StreamSource(new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8)));
        StreamResult result = null;

        try {
            result = new StreamResult(new FileOutputStream(outputFilePath));
        } catch (FileNotFoundException e) {
            throw new Exception("Error while creating output file.");
        }

        try {
            grddlTransformer.transform(source, result);
        } catch (TransformerException e) {
            throw new Exception("Error while extracting metadata to RDF.");
        }

        String rdfXmlResult = FileReader.readFromFile(outputFilePath);
        File outputFile = new File(outputFilePath);
        outputFile.delete();

        return rdfXmlResult;
	}

	@Override
	public String extractMetadataToJson(String xmlData) throws Exception {
		String rdfXml = this.extractMetadataToRdf(xmlData);

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(rdfXml);
            return xmlJSONObj.toString(4);
        } catch (JSONException e) {
            throw new Exception("Error while extracting metadata to JSON");
        }
	}

}
