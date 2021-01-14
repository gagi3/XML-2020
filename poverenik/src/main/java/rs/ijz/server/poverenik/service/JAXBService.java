package rs.ijz.server.poverenik.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;

@Service
public class JAXBService {
    public void marshal(Object object, OutputStream out, Class cl) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(cl);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, out);
    }

    public <T> T unmarshal(String content, Class<T> genericClass) {
        return JAXB.unmarshal(new StringReader(content), genericClass);
    }

    public void marshalToString(Object object, Writer writer, Class cl) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(cl);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, writer);
    }
}
