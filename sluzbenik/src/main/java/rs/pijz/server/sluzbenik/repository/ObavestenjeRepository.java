package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.obavestenje.Obavestenje;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class ObavestenjeRepository {
    private final String collectionURI = "/db/pijz_sluzbenik/obavestenje";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "obavestenje-" + id + ".xml";
    }

    public Obavestenje save(Obavestenje obavestenje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(obavestenje.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(obavestenje, stream, Obavestenje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return obavestenje;
    }

    public Obavestenje edit(Obavestenje obavestenje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(obavestenje.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(obavestenje, stream, Obavestenje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return obavestenje;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateObavestenjeXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/o:Obavestenje[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryObavestenje(xpath);
        Obavestenje obavestenje = (Obavestenje) commonRepository.resourceSetToClass(result, Obavestenje.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Obavestenje.class, obavestenje, xmlFile);
    }
}
