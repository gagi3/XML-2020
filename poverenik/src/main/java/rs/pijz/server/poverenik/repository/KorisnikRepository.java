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

@Repository
public class KorisnikRepository {
    private final String collectionURI = "/db/pijz_poverenik/korisnik";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "korisnik-" + id + ".xml";
    }

    public Korisnik save(Korisnik korisnik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(korisnik.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(korisnik, stream, Korisnik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return korisnik;
    }

    public Korisnik edit(Korisnik korisnik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(korisnik.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(korisnik, stream, Korisnik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return korisnik;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateKorisnikXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/k:Korisnik[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryKorisnik(xpath);
        Korisnik korisnik = (Korisnik) commonRepository.resourceSetToClass(result, Korisnik.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Korisnik.class, korisnik, xmlFile);
    }
}
