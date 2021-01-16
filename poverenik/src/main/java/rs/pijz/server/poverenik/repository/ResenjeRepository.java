package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.resenje.Resenje;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ResenjeRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Resenje save(Resenje Resenje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_poverenik/resenje");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Resenje, stream, Resenje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Resenje;
    }

    public void generateResenjeXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/r:Resenje[@ID='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("r", "http://www.pijz.rs/resenje");
        ResourceSet result = commonRepository.runXpath("/db/pijz_poverenik/resenje", namespace, xpath);
        Resenje Resenje = (Resenje) commonRepository.resourceSetToClass(result, Resenje.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Resenje.class, Resenje, xmlFile);
    }
}
