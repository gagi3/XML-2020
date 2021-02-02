package rs.pijz.server.sluzbenik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.pijz.server.sluzbenik.model.gradjanin.Gradjanin;
import rs.pijz.server.sluzbenik.service.JAXBService;
import rs.pijz.server.sluzbenik.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class GradjaninRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Gradjanin save(Gradjanin Gradjanin) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_sluzbenik/gradjanin");
        XMLResource resource = (XMLResource) collection.createResource("gradjanin-" + Gradjanin.getKorisnik().getId() + ".xml", XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(Gradjanin, stream, Gradjanin.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Gradjanin;
    }

    public Gradjanin edit(Gradjanin Gradjanin) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_sluzbenik/gradjanin");
        XMLResource resource = (XMLResource) collection.getResource("gradjanin-" + Gradjanin.getKorisnik().getId() + ".xml");
        OutputStream stream = new ByteArrayOutputStream();
        System.out.println(Gradjanin.getKorisnik().getId());
        System.out.println(Gradjanin.toString());
        System.out.println(resource.getContent().toString());
        jaxbService.marshal(Gradjanin, stream, Gradjanin.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return Gradjanin;
    }

    public void delete(String id) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz_sluzbenik/gradjanin");
        XMLResource resource = (XMLResource) collection.getResource("gradjanin-" + id + ".xml");
        collection.removeResource(resource);
    }

    public void generateGradjaninXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/g:Gradjanin/k:Korisnik[@id='" + ID + "']]";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("g", "http://www.pijz.rs/gradjanin");
        namespace.put("k", "http://www.pijz.rs/korisnik");
        ResourceSet result = commonRepository.runXpath("/db/pijz_sluzbenik/gradjanin", namespace, xpath);
        Gradjanin Gradjanin = (Gradjanin) commonRepository.resourceSetToClass(result, Gradjanin.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Gradjanin.class, Gradjanin, xmlFile);
    }
}
