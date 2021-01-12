package rs.ijz.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import rs.ijz.server.model.resenje_zahtev_odbijen.ResenjeZahtevOdbijen;
import rs.ijz.server.service.JAXBService;
import rs.ijz.server.util.DatabaseConnection;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class ResenjeZahtevOdbijenRepository {
    @Autowired
    private DatabaseConnection databaseConnection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public ResenjeZahtevOdbijen save(ResenjeZahtevOdbijen resenjeZahtevOdbijen) throws XMLDBException, JAXBException {
        Collection collection = databaseConnection.getOrCreateCollection("/db/pijz/resenje-zahtev-odbijen");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(resenjeZahtevOdbijen, stream, ResenjeZahtevOdbijen.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return resenjeZahtevOdbijen;
    }

    public void generateResenjeZahtevOdbijenXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/rzho:ResenjeZahtevOdbijen[@id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("rzho", "http://www.pijz.rs/resenje-zahtev-odbijen");
        ResourceSet result = commonRepository.runXpath("/db/pijz/resenje-zahtev-odbijen", namespace, xpath);
        ResenjeZahtevOdbijen resenjeZahtevOdbijen = (ResenjeZahtevOdbijen) commonRepository.resourceSetToClass(result, ResenjeZahtevOdbijen.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(ResenjeZahtevOdbijen.class, resenjeZahtevOdbijen, xmlFile);
    }
}
