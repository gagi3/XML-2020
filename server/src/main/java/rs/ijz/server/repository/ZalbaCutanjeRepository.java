package rs.ijz.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.ijz.server.model.zalba_cutanje.ZalbaCutanje;
import rs.ijz.server.service.JAXBService;
import rs.ijz.server.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ZalbaCutanjeRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public ZalbaCutanje save(ZalbaCutanje zalbaCutanje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz/zalba-cutanje");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zalbaCutanje, stream, ZalbaCutanje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zalbaCutanje;
    }

    public void generateZalbaCutanjeXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/zc:ZalbaCutanje[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("zc", "http://www.pijz.rs/zalba-cutanje");
        ResourceSet result = commonRepository.runXpath("/db/pijz/zalba-cutanje", namespace, xpath);
        ZalbaCutanje zalbaCutanje = (ZalbaCutanje) commonRepository.resourceSetToClass(result, ZalbaCutanje.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(ZalbaCutanje.class, zalbaCutanje, xmlFile);
    }
}
