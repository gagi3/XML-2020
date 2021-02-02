package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class ZalbaCutanjeRepository {
    private final String collectionURI = "/db/pijz_poverenik/zalba-cutanje";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "zalba-cutanje-" + id + ".xml";
    }

    public ZalbaCutanje save(ZalbaCutanje zalbaCutanje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(zalbaCutanje.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zalbaCutanje, stream, ZalbaCutanje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zalbaCutanje;
    }

    public ZalbaCutanje edit(ZalbaCutanje zalbaCutanje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(zalbaCutanje.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zalbaCutanje, stream, ZalbaCutanje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zalbaCutanje;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateZalbaCutanjeXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/zc:ZalbaCutanje[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryZalbaCutanje(xpath);
        ZalbaCutanje zalbaCutanje = (ZalbaCutanje) commonRepository.resourceSetToClass(result, ZalbaCutanje.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(ZalbaCutanje.class, zalbaCutanje, xmlFile);
    }
}
