package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Repository
public class IzjasnjenjeNaZalbuRepository {
    private final String collectionURI = "/db/pijz_sluzbenik/izjasnjenje-na-zalbu";
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    private String getDocumentName(String id) {
        return "izjasnjenje-na-zalbu-" + id + ".xml";
    }

    public IzjasnjenjeNaZalbu save(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.createResource(getDocumentName(izjasnjenjeNaZalbu.getId()), XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(izjasnjenjeNaZalbu, stream, IzjasnjenjeNaZalbu.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return izjasnjenjeNaZalbu;
    }

    public IzjasnjenjeNaZalbu edit(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(izjasnjenjeNaZalbu.getId()));
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(izjasnjenjeNaZalbu, stream, IzjasnjenjeNaZalbu.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return izjasnjenjeNaZalbu;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection(collectionURI);
        XMLResource resource = (XMLResource) collection.getResource(getDocumentName(id));
        collection.removeResource(resource);
    }

    public void generateIzjasnjenjeNaZalbuXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/i:IzjasnjenjeNaZalbu[@id='" + ID + "']]";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xpath);
        IzjasnjenjeNaZalbu izjasnjenjeNaZalbu = (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
        String xmlFile = "data/xsd/instance/" + file + ".xml";
        commonRepository.generateXML(IzjasnjenjeNaZalbu.class, izjasnjenjeNaZalbu, xmlFile);
    }
}
