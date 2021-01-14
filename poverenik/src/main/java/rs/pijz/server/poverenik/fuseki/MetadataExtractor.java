package rs.pijz.server.poverenik.fuseki;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Primer demonstrira ekstrakciju RDFa metapodataka iz
 * XML dokumenta primenom GRDDL (Gleaning Resource Descriptions
 * from Dialects of Languages) transformacije.
 */
@Component
public class MetadataExtractor {

    private static final String XSLT_FILE = "src/main/resources/xsl/grddl.xsl";
    private static final String RDF_FILE = "src/main/resources/rdf/output.rdf";
    private final TransformerFactory transformerFactory;

    public MetadataExtractor() throws SAXException, IOException {

        // Setup the XSLT transformer factory
        transformerFactory = TransformerFactory.newInstance();
    }

    /**
     * Generates RDF/XML based on RDFa metadata from an XML containing
     * input stream by applying GRDDL XSL transformation.
     *
     * @param in  XML containing input stream
     * @param out RDF/XML output stream
     */

    public void extract(String in) throws FileNotFoundException, TransformerException {

        OutputStream out = new FileOutputStream(new File(RDF_FILE));

        // Create transformation source
        StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

        // Initialize GRDDL transformer object
        Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

        // Set the indentation properties
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Initialize transformation subject
        StreamSource source = new StreamSource(new StringReader(in));

        // Initialize result stream
        StreamResult result = new StreamResult(out);

        // Trigger the transformation
        grddlTransformer.transform(source, result);
        try {
            FusekiWriter.saveRDF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
