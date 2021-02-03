package rs.pijz.server.sluzbenik.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Service;

@Service
public class DocumentService {

//    private static String convertDocumentToString(Document document) {
//        TransformerFactory factory = TransformerFactory.newInstance();
//        Transformer transformer;
//        try {
//            transformer = factory.newTransformer();
//            StringWriter writer = new StringWriter();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
//            transformer.transform(new DOMSource(document), new StreamResult(writer));
//            return writer.getBuffer().toString();
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public <T> void createXML(Class<T> genericClass, Object objectClass, String pathToFile) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File(pathToFile);
        file.createNewFile();
        OutputStream os = new FileOutputStream(file);
        marshaller.marshal(objectClass, os);
    }
}
