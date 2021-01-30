package rs.pijz.server.poverenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.poverenik.model.korisnik.Korisnik;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.KorisnikRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private DocumentService documentService;

    public List<Korisnik> findAll() throws XMLDBException {
        String xPath = "/k:Korisnik";
        ResourceSet result = commonRepository.queryKorisnik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Korisnik> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Korisnik) commonRepository.resourceToClass(iterator.nextResource(), Korisnik.class));
        }
        return results;
    }

    public Korisnik getOne(String id) throws XMLDBException {
        String xPath = "/k:Korisnik[@id='" + id + "']";
        ResourceSet result = commonRepository.queryKorisnik(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Korisnik) commonRepository.resourceSetToClass(result, Korisnik.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/k:Korisnik[@id='" + id + "']";
        return commonRepository.queryKorisnik(xPath).getSize() != 0;
    }

    public Korisnik create(Korisnik korisnik) throws Exception {
        if (existsById(korisnik.getId())) {
            throw new Exception("Korisnik sa istim ID vec postoji!");
        }
        return korisnikRepository.save(korisnik);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/k:Korisnik[@id='" + id + "']";
        ResourceSet result = commonRepository.queryKorisnik(xPath);
        Korisnik korisnik = (Korisnik) commonRepository.resourceSetToClass(result, Korisnik.class);
        String xmlInstance = "../data/xsd/instance/" + "korisnik" + id + ".xml";
        String xml = "../data/xml/" + "korisnik" + id + ".xml";
        documentService.createXML(Korisnik.class, korisnik, xmlInstance);
        System.out.println("Docs generated!");
    }
}
