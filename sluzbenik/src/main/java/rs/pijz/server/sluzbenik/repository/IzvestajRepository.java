package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class IzvestajRepository {
    private final String collectionURI = "/db/pijz_sluzbenik/izvestaj";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "izvestaj-" + id + ".xml";
    }

    public Izvestaj save(Izvestaj izvestaj) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(izvestaj.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(izvestaj, stream, Izvestaj.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return izvestaj;
    }

    public Izvestaj edit(Izvestaj izvestaj) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(izvestaj.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(izvestaj, stream, Izvestaj.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return izvestaj;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateIzvestajXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/iz:Izvestaj[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryIzvestaj(xpath);
        Izvestaj izvestaj = (Izvestaj) commonRepository.resourceSetToClass(result, Izvestaj.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Izvestaj.class, izvestaj, xmlFile);
    }
}
