package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.sluzbenik.Sluzbenik;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class SluzbenikRepository {
    private final String collectionURI = "/db/pijz_sluzbenik/sluzbenik";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "sluzbenik-" + id + ".xml";
    }

    public Sluzbenik save(Sluzbenik sluzbenik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(sluzbenik.getKorisnik().getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(sluzbenik, stream, Sluzbenik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return sluzbenik;
    }

    public Sluzbenik edit(Sluzbenik sluzbenik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(sluzbenik.getKorisnik().getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(sluzbenik, stream, Sluzbenik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return sluzbenik;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateSluzbenikXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/s:Sluzbenik[s:korisnik[@id='" + ID + "']]";
        ResourceSet result = commonRepository.querySluzbenik(xpath);
        Sluzbenik sluzbenik = (Sluzbenik) commonRepository.resourceSetToClass(result, Sluzbenik.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Sluzbenik.class, sluzbenik, xmlFile);
    }
}
