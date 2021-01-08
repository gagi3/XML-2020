package rs.ijz.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.ijz.server.model.ResenjeZalbaOsnovana;
import rs.ijz.server.service.JAXBService;
import rs.ijz.server.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ResenjeZalbaOsnovanaRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public ResenjeZalbaOsnovana save(ResenjeZalbaOsnovana resenjeZalbaOsnovana) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz/resenje-zalba-osnovana");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(resenjeZalbaOsnovana, stream, ResenjeZalbaOsnovana.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return resenjeZalbaOsnovana;
    }

    public void generateResenjeZalbaOsnovanaXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/rzo:ResenjeZalbaOsnovana[rzo:resenjeZalbaOsnovana_id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("rzo", "http://www.pijz.rs/resenje-zalba-osnovana");
        ResourceSet result = commonRepository.runXpath("/db/pijz/resenje-zalba-osnovana", namespace, xpath);
        ResenjeZalbaOsnovana resenjeZalbaOsnovana = (ResenjeZalbaOsnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaOsnovana.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(ResenjeZalbaOsnovana.class, resenjeZalbaOsnovana, xmlFile);
    }
}
