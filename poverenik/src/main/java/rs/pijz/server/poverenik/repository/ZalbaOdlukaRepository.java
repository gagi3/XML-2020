package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class ZalbaOdlukaRepository {
    private final String collectionURI = "/db/pijz_poverenik/zalba-odluka";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "zalba-odluka-" + id + ".xml";
    }

    public ZalbaOdluka save(ZalbaOdluka zalbaOdluka) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(zalbaOdluka.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zalbaOdluka, stream, ZalbaOdluka.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zalbaOdluka;
    }

    public ZalbaOdluka edit(ZalbaOdluka zalbaOdluka) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(zalbaOdluka.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zalbaOdluka, stream, ZalbaOdluka.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zalbaOdluka;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateZalbaOdlukaXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/zo:ZalbaOdluka[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryZalbaOdluka(xpath);
        ZalbaOdluka zalbaOdluka = (ZalbaOdluka) commonRepository.resourceSetToClass(result, ZalbaOdluka.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(ZalbaOdluka.class, zalbaOdluka, xmlFile);
    }
}
