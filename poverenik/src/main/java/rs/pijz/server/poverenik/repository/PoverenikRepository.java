package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.poverenik.Poverenik;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class PoverenikRepository {
    private final String collectionURI = "/db/pijz_poverenik/poverenik";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "poverenik-" + id + ".xml";
    }

    public Poverenik save(Poverenik poverenik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(poverenik.getKorisnik().getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(poverenik, stream, Poverenik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return poverenik;
    }

    public Poverenik edit(Poverenik poverenik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(poverenik.getKorisnik().getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(poverenik, stream, Poverenik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return poverenik;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generatePoverenikXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/p:Poverenik[p:korisnik[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryPoverenik(xpath);
        Poverenik poverenik = (Poverenik) commonRepository.resourceSetToClass(result, Poverenik.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Poverenik.class, poverenik, xmlFile);
    }
}
