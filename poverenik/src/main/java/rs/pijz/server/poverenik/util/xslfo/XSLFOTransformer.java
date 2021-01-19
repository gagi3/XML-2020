package rs.pijz.server.poverenik.util.xslfo;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

@Component
public class XSLFOTransformer {

	private TransformerFactory transformerFactory;

	public XSLFOTransformer() throws SAXException, IOException {
		transformerFactory = TransformerFactory.newInstance();
	}

	public String generateHTML(String xml, String xslPath) throws Exception {

		File tf = new File(xslPath);
		StringWriter out = new StringWriter();
		StringReader src = new StringReader(xml);

		Transformer t = transformerFactory.newTransformer(new StreamSource(tf));

		Source s = new StreamSource(src);
		Result r = new StreamResult(out);
		t.transform(s, r);

		return out.toString();
	}

}
