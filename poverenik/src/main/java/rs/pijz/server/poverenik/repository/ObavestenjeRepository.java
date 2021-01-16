package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.obavestenje.Obavestenje;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ObavestenjeRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Obavestenje save(Obavestenje Obavestenje) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_poverenik/obavestenje");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Obavestenje, stream, Obavestenje.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Obavestenje;
    }

    public void generateObavestenjeXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/o:Obavestenje[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("o", "http://www.pijz.rs/obavestenje");
        ResourceSet result = commonRepository.runXpath("/db/pijz_poverenik/obavestenje", namespace, xpath);
        Obavestenje Obavestenje = (Obavestenje) commonRepository.resourceSetToClass(result, Obavestenje.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Obavestenje.class, Obavestenje, xmlFile);
    }
}
