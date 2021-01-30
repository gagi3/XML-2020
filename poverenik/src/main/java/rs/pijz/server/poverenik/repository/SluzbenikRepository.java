package rs.pijz.server.poverenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.poverenik.model.sluzbenik.Sluzbenik;
import rs.pijz.server.poverenik.service.JAXBService;
import rs.pijz.server.poverenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class SluzbenikRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Sluzbenik save(Sluzbenik Sluzbenik) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_poverenik/sluzbenik");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Sluzbenik, stream, Sluzbenik.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Sluzbenik;
    }

    public void generateSluzbenikXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/s:Sluzbenik[k:Korisnik[@id='" + ID + "']]";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("s", "http://www.pijz.rs/sluzbenik");
        namespace.put("k", "http://www.pijz.rs/korisnik");
        ResourceSet result = commonRepository.runXpath("/db/pijz_poverenik/sluzbenik", namespace, xpath);
        Sluzbenik Sluzbenik = (Sluzbenik) commonRepository.resourceSetToClass(result, Sluzbenik.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Sluzbenik.class, Sluzbenik, xmlFile);
    }
}
