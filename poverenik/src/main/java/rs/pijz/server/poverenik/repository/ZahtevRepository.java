package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.zahtev.Zahtev;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class ZahtevRepository {
    private final String collectionURI = "/db/pijz_poverenik/zahtev";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "zahtev-" + id + ".xml";
    }

    public Zahtev save(Zahtev zahtev) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(zahtev.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zahtev, stream, Zahtev.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zahtev;
    }

    public Zahtev edit(Zahtev zahtev) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(zahtev.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zahtev, stream, Zahtev.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zahtev;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateZahtevXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/z:Zahtev[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryZahtev(xpath);
        Zahtev zahtev = (Zahtev) commonRepository.resourceSetToClass(result, Zahtev.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Zahtev.class, zahtev, xmlFile);
    }
}
