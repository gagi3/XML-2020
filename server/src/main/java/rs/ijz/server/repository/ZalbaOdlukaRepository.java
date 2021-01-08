package rs.ijz.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.ijz.server.model.ZalbaOdluka;
import rs.ijz.server.service.JAXBService;
import rs.ijz.server.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ZalbaOdlukaRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public ZalbaOdluka save(ZalbaOdluka zalbaOdluka) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz/zalba-odluka");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(zalbaOdluka, stream, ZalbaOdluka.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return zalbaOdluka;
    }

    public void generateZalbaOdlukaXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/zo:ZalbaOdluka[zo:zalbaOdluka_id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("zo", "http://www.pijz.rs/zalba-odluka");
        ResourceSet result = commonRepository.runXpath("/db/pijz/zalba-odluka", namespace, xpath);
        ZalbaOdluka zalbaOdluka = (ZalbaOdluka) commonRepository.resourceSetToClass(result, ZalbaOdluka.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(ZalbaOdluka.class, zalbaOdluka, xmlFile);
    }
}
