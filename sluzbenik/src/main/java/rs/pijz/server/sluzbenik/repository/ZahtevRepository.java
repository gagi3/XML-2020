package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.zahtev.Zahtev;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ZahtevRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Zahtev save(Zahtev Zahtev) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_sluzbenik/zahtev");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Zahtev, stream, Zahtev.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Zahtev;
    }

    public void generateZahtevXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/z:Zahtev[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("z", "http://www.pijz.rs/zahtev");
        ResourceSet result = commonRepository.runXpath("/db/pijz_sluzbenik/zahtev", namespace, xpath);
        Zahtev Zahtev = (Zahtev) commonRepository.resourceSetToClass(result, Zahtev.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Zahtev.class, Zahtev, xmlFile);
    }
}
