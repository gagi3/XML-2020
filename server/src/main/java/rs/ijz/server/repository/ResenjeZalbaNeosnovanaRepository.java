package rs.ijz.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.ijz.server.model.resenje_zalba_neosnovana.ResenjeZalbaNeosnovana;
import rs.ijz.server.service.JAXBService;
import rs.ijz.server.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ResenjeZalbaNeosnovanaRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public ResenjeZalbaNeosnovana save(ResenjeZalbaNeosnovana resenjeZalbaNeosnovana) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz/resenje-zalba-neosnovana");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(resenjeZalbaNeosnovana, stream, ResenjeZalbaNeosnovana.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return resenjeZalbaNeosnovana;
    }

    public void generateResenjeZalbaNeosnovanaXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/rzn:ResenjeZalbaNeosnovana[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("rzn", "http://www.pijz.rs/resenje-zalba-neosnovana");
        ResourceSet result = commonRepository.runXpath("/db/pijz/resenje-zalba-neosnovana", namespace, xpath);
        ResenjeZalbaNeosnovana resenjeZalbaNeosnovana = (ResenjeZalbaNeosnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaNeosnovana.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(ResenjeZalbaNeosnovana.class, resenjeZalbaNeosnovana, xmlFile);
    }
}
