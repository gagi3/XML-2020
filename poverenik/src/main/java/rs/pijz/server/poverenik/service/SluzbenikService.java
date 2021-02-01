package rs.pijz.server.poverenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.poverenik.model.sluzbenik.Sluzbenik;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.SluzbenikRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SluzbenikService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private SluzbenikRepository sluzbenikRepository;
    @Autowired
    private DocumentService documentService;

    public List<Sluzbenik> findAll() throws XMLDBException {
        String xPath = "/s:Sluzbenik";
        ResourceSet result = commonRepository.querySluzbenik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Sluzbenik> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Sluzbenik) commonRepository.resourceToClass(iterator.nextResource(), Sluzbenik.class));
        }
        return results;
    }

    public Sluzbenik getOne(String id) throws XMLDBException {
        String xPath = "/s:Sluzbenik[s:korisnik[@id='" + id + "']]";
        ResourceSet result = commonRepository.querySluzbenik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Sluzbenik) commonRepository.resourceSetToClass(result, Sluzbenik.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/s:Sluzbenik[s:korisnik[@id='" + id + "']]";
        return commonRepository.querySluzbenik(xPath).getSize() != 0;
    }

    public Sluzbenik getByUsername(String username) throws XMLDBException {
        String xPath = "/s:Sluzbenik[s:korisnik[@username='" + username + "']]";
        ResourceSet result = commonRepository.querySluzbenik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Sluzbenik) commonRepository.resourceSetToClass(result, Sluzbenik.class);
    }

    public Boolean existsByUsername(String username) throws XMLDBException {
        String xPath = "/s:Sluzbenik[s:korisnik[@username='" + username + "']]";
        return commonRepository.querySluzbenik(xPath).getSize() != 0;
    }

    public Sluzbenik create(Sluzbenik sluzbenik) throws Exception {
        if (existsById(sluzbenik.getKorisnik().getId())) {
            throw new Exception("Sluzbenik sa istim ID vec postoji!");
        }
        if (existsByUsername(sluzbenik.getKorisnik().getUsername())) {
            throw new Exception("Sluzbenik sa istom email adresom vec postoji!");
        }
        return sluzbenikRepository.save(sluzbenik);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/s:Sluzbenik[s:korisnik[@id='" + id + "']]";
        ResourceSet result = commonRepository.querySluzbenik(xPath);
        Sluzbenik sluzbenik = (Sluzbenik) commonRepository.resourceSetToClass(result, Sluzbenik.class);
        String xmlInstance = "../data/xsd/instance/" + "sluzbenik" + id + ".xml";
        String xml = "../data/xml/" + "sluzbenik" + id + ".xml";
        documentService.createXML(Sluzbenik.class, sluzbenik, xmlInstance);
        System.out.println("Docs generated!");
    }
}
