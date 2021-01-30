package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CommonRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;

    public ResourceSet runXpath(String col, HashMap<String, String> namespaces, String xpathExp) throws XMLDBException {
        Collection collection = databaseConnection.getOrCreateCollection(col);
        XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
        xpathService.setProperty("indent", "yes");
        for (Map.Entry<String, String> entry : namespaces.entrySet()) {
            xpathService.setNamespace(entry.getKey(), entry.getValue());
        }
        System.out.println("[INFO] XPath query: " + xpathExp);
        ResourceSet result = xpathService.query(xpathExp);
        System.out.println("[INFO] Size found: " + result.getSize());
        collection.close();
        return result;
    }

    public <T> Object resourceSetToClass(ResourceSet resourceSet, Class<T> genericClass) throws XMLDBException {
        ResourceIterator i = resourceSet.getIterator();
        Resource resource = i.nextResource();
        return jaxbService.unmarshal(resource.getContent().toString(), genericClass);
    }

    public <T> Object resourceToClass(Resource resource, Class<T> genericClass) throws XMLDBException {
        return jaxbService.unmarshal(resource.getContent().toString(), genericClass);
    }

    public <T> void generateXML(Class<T> genericClass, Object object, String path) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream stream = new FileOutputStream(path);
        marshaller.marshal(object, stream);
    }

    public ResourceSet queryObavestenje(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("o", "http://www.pijz.rs/obavestenje");
        }};
        return runXpath("/db/pijz_sluzbenik/obavestenje", namespace, query);
    }

    public ResourceSet queryZalbaCutanje(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("zc", "http://www.pijz.rs/zalba-cutanje");
        }};
        return runXpath("/db/pijz_sluzbenik/zalba-cutanje", namespace, query);
    }

    public ResourceSet queryZalbaOdluka(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("zo", "http://www.pijz.rs/zalba-odluka");
        }};
        return runXpath("/db/pijz_sluzbenik/zalba-odluka", namespace, query);
    }

    public ResourceSet queryResenje(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("r", "http://www.pijz.rs/resenje");
        }};
        return runXpath("/db/pijz_sluzbenik/resenje", namespace, query);
    }

    public ResourceSet queryResenjePonisteno(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("rp", "http://www.pijz.rs/resenje-ponisteno");
        }};
        return runXpath("/db/pijz_sluzbenik/resenje-ponisteno", namespace, query);
    }

    public ResourceSet queryIzjasnjenjeNaZalbu(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("i", "http://www.pijz.rs/izjasnjenje-na-zalbu");
        }};
        return runXpath("/db/pijz_sluzbenik/izjasnjenje-na-zalbu", namespace, query);
    }

    public ResourceSet queryZahtev(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("z", "http://www.pijz.rs/zahtev");
        }};
        return runXpath("/db/pijz_sluzbenik/zahtev", namespace, query);
    }

    public ResourceSet queryGradjanin(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("g", "http://www.pijz.rs/gradjanin");
            put("k", "http://www.pijz.rs/korisnik");
        }};
        return runXpath("/db/pijz_sluzbenik/gradjanin", namespace, query);
    }

    public ResourceSet querySluzbenik(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("s", "http://www.pijz.rs/sluzbenik");
            put("k", "http://www.pijz.rs/korisnik");
        }};
        return runXpath("/db/pijz_sluzbenik/sluzbenik", namespace, query);
    }

    public ResourceSet queryPoverenik(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
        put("p", "http://www.pijz.rs/poverenik");
        put("k", "http://www.pijz.rs/korisnik");
        }};
        return runXpath("/db/pijz_sluzbenik/poverenik", namespace, query);
    }

    public ResourceSet queryIzvestaj(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("iz", "http://www.pijz.rs/izvestaj");
        }};
        return runXpath("/db/pijz_sluzbenik/izvestaj", namespace, query);
    }

    public ResourceSet queryKorisnik(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>() {{
            put("k", "http://www.pijz.rs/korisnik");
        }};
        return runXpath("/db/pijz_sluzbenik/korisnik", namespace, query);
    }
}
