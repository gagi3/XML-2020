package rs.pijz.server.poverenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.poverenik.model.poverenik.Poverenik;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.PoverenikRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PoverenikService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private PoverenikRepository poverenikRepository;
    @Autowired
    private DocumentService documentService;

    public List<Poverenik> findAll() throws XMLDBException {
        String xPath = "/p:Poverenik";
        ResourceSet result = commonRepository.queryPoverenik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Poverenik> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Poverenik) commonRepository.resourceToClass(iterator.nextResource(), Poverenik.class));
        }
        return results;
    }

    public Poverenik getOne(String id) throws XMLDBException {
        String xPath = "/p:Poverenik[@id='" + id + "']";
        ResourceSet result = commonRepository.queryPoverenik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Poverenik) commonRepository.resourceSetToClass(result, Poverenik.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/p:Poverenik[@id='" + id + "']";
        return commonRepository.queryPoverenik(xPath).getSize() != 0;
    }

    public Poverenik create(Poverenik poverenik) throws Exception {
        if (existsById(poverenik.getKorisnik().getId())) {
            throw new Exception("Poverenik sa istim ID vec postoji!");
        }
        return poverenikRepository.save(poverenik);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/p:Poverenik[@id='" + id + "']";
        ResourceSet result = commonRepository.queryPoverenik(xPath);
        Poverenik poverenik = (Poverenik) commonRepository.resourceSetToClass(result, Poverenik.class);
        String xmlInstance = "../data/xsd/instance/" + "poverenik" + id + ".xml";
        String xml = "../data/xml/" + "poverenik" + id + ".xml";
        documentService.createXML(Poverenik.class, poverenik, xmlInstance);
        System.out.println("Docs generated!");
    }
}