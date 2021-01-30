package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.korisnik.Korisnik;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class KorisnikRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Korisnik save(Korisnik Korisnik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_poverenik/korisnik");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Korisnik, stream, Korisnik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Korisnik;
    }

    public void generateKorisnikXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/k:Korisnik[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("k", "http://www.pijz.rs/korisnik");
        ResourceSet result = commonRepository.runXpath("/db/pijz_poverenik/korisnik", namespace, xpath);
        Korisnik Korisnik = (Korisnik) commonRepository.resourceSetToClass(result, Korisnik.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Korisnik.class, Korisnik, xmlFile);
    }
}
