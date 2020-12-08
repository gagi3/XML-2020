package rs.ijz.server.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import rs.ijz.server.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.GregorianCalendar;

@Service
public class DocumentService {

    private static String convertDocumentToString(Document document) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = factory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.getBuffer().toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void createXML(Class<T> genericClass, Object objectClass, String pathToFile) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File(pathToFile);
        file.createNewFile();
        OutputStream os = new FileOutputStream(file);
        marshaller.marshal(objectClass, os);
    }

    public void dummyObavestenjeData() throws DatatypeConfigurationException, JAXBException, IOException {

        // new obavestenje
        Obavestenje o = new Obavestenje();

        o.setBrojPredmeta("125");

        // date
        GregorianCalendar now = new GregorianCalendar();
        o.setDatum(DatatypeFactory.newInstance().newXMLGregorianCalendar(now));

        o.setId("1");
        o.setNaslov("Obavestenje za zaposlene");

        // organ
        Obavestenje.Organ organ = new Obavestenje.Organ();
        organ.setNaziv("Organ prvi");

        //adresa
        Adresa a = new Adresa();
        a.setGrad("Kragujevac");
        a.setBrojUlice("23");
        a.setUlica("Svetogorska");
        organ.setSediste(a);

        o.setOrgan(organ);

        o.setPodnaslov("Podnaslov");

        // podnosilac
        Obavestenje.Podnosilac pod = new Obavestenje.Podnosilac();
        FizickoLice fl = new FizickoLice();
        Adresa adr = new Adresa();
        adr.setUlica("Njegoseva");
        adr.setBrojUlice("15");
        adr.setGrad("Novi sad");
        fl.setAdresa(adr);
        fl.setIme("Marko");
        fl.setPrezime("Suhanov");
        pod.setFizickoLice(fl);
        PravnoLice pl = new PravnoLice();
        pl.setAdresa(adr);
        pl.setNaziv("Pravno lice");
        pod.setPravnoLice(pl);
        String xmlInstance = "data/xsd/instance/" + "article" + o.getId() + ".xml";
        this.createXML(Obavestenje.class, o, xmlInstance);
    }


}
