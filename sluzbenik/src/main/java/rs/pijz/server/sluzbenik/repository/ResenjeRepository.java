package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.resenje.Resenje;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class ResenjeRepository {
    private final String collectionURI = "/db/pijz_sluzbenik/resenje";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "resenje-" + id + ".xml";
    }

    public Resenje save(Resenje resenje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(resenje.getID()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(resenje, stream, Resenje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return resenje;
    }

    public Resenje edit(Resenje resenje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(resenje.getID()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(resenje, stream, Resenje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return resenje;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateResenjeXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/r:Resenje[@ID='" + ID + "']]";
        ResourceSet result = commonRepository.queryResenje(xpath);
        Resenje resenje = (Resenje) commonRepository.resourceSetToClass(result, Resenje.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Resenje.class, resenje, xmlFile);
    }
}
