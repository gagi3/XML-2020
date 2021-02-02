package rs.pijz.server.sluzbenik.util.xslfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

@Component
public class XSLFOTransformer {
	
	private FopFactory fopFactory;

	private TransformerFactory transformerFactory;
	
	public static final String FOP_XCONF = "src/main/java/rs/pijz/server/sluzbenik/util/xslfo/fop.xconf";

	public XSLFOTransformer() throws SAXException, IOException {
		fopFactory = FopFactory.newInstance(new File(FOP_XCONF));
		transformerFactory = TransformerFactory.newInstance();
	}

	public String generateHTML(String xml, String output, String xslPath) throws Exception {

		File tf = new File(xslPath);
		StringWriter out = new StringWriter();
		StringReader src = new StringReader(xml);

		Transformer t = transformerFactory.newTransformer(new StreamSource(tf));

		Source s = new StreamSource(src);
		Result r = new StreamResult(out);
		t.transform(s, r);
		
		String outString = out.toString();
		
		try (FileWriter fileWriter = new FileWriter(output)) {
			fileWriter.write(outString);
		}

		return outString;
	}
	
	public ByteArrayOutputStream generatePDF(String xml, String output, String xslfoPath) throws Exception {
		
		// Point to the XSL-FO file
		File xslFile = new File(xslfoPath);

		// Create transformation source
		StreamSource transformSource = new StreamSource(xslFile);
		
		// Initialize the transformation subject
		StreamSource source = new StreamSource(new StringReader(xml));
		// StreamSource source = new StreamSource(ssourceStr);

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();
		
		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
		
		// Construct FOP instance with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

		// Resulting SAX events 
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		xslFoTransformer.transform(source, res);
	
		
		try (OutputStream outputStream = new FileOutputStream(output)) {
		    outStream.writeTo(outputStream);
		}

		return outStream;
	}

}
