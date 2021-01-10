package rs.ijz.server.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class MetadataExtractorService {
	
	private String grddlTransformation = "src/main/resources/data/grddl/grddl.xsl";

	
	public void extractMetadata(InputStream in, OutputStream out) throws Exception {
		StreamSource transformSource = new StreamSource(new File(grddlTransformation));
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

        StreamSource source = new StreamSource(in);
        StreamResult result = new StreamResult(out);

        try {
            grddlTransformer.transform(source, result);
        } catch (TransformerException e) {
            throw new Exception("Error while extracting metadata to RDF.");
        }
	}
    
}
