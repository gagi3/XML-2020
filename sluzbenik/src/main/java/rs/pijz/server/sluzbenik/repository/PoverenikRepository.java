package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.poverenik.Poverenik;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class PoverenikRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Poverenik save(Poverenik Poverenik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_sluzbenik/poverenik");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Poverenik, stream, Poverenik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Poverenik;
    }

    public void generatePoverenikXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/p:Poverenik[k:Korisnik[@id='" + ID + "']]";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("p", "http://www.pijz.rs/poverenik");
        namespace.put("k", "http://www.pijz.rs/korisnik");
        ResourceSet result = commonRepository.runXpath("/db/pijz_sluzbenik/poverenik", namespace, xpath);
        Poverenik Poverenik = (Poverenik) commonRepository.resourceSetToClass(result, Poverenik.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Poverenik.class, Poverenik, xmlFile);
    }
}
