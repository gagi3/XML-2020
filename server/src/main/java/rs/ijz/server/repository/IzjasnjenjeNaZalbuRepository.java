package rs.ijz.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.ijz.server.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.ijz.server.service.JAXBService;
import rs.ijz.server.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class IzjasnjenjeNaZalbuRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public IzjasnjenjeNaZalbu save(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz/izjasnjenje-na-zalbu");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(izjasnjenjeNaZalbu, stream, IzjasnjenjeNaZalbu.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return izjasnjenjeNaZalbu;
    }

    public void generateIzjasnjenjeNaZalbuXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/i:IzjasnjenjeNaZalbu[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("i", "http://www.pijz.rs/izjasnjenje-na-zalbu");
        ResourceSet result = commonRepository.runXpath("/db/pijz/izjasnjenje-na-zalbu", namespace, xpath);
        IzjasnjenjeNaZalbu izjasnjenjeNa = (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(IzjasnjenjeNaZalbu.class, izjasnjenjeNa, xmlFile);
    }
}
