package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.gradjanin.Gradjanin;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class GradjaninRepository {
    private final String collectionURI = "/db/pijz_poverenik/gradjanin";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "gradjanin-" + id + ".xml";
    }

    public Gradjanin save(Gradjanin gradjanin) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(gradjanin.getKorisnik().getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(gradjanin, stream, Gradjanin.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return gradjanin;
    }

    public Gradjanin edit(Gradjanin gradjanin) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(gradjanin.getKorisnik().getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(gradjanin, stream, Gradjanin.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return gradjanin;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateGradjaninXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/g:Gradjanin[g:korisnik[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryGradjanin(xpath);
        Gradjanin gradjanin = (Gradjanin) commonRepository.resourceSetToClass(result, Gradjanin.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(Gradjanin.class, gradjanin, xmlFile);
    }
}
