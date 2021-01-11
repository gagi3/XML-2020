package rs.ijz.server.service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import com.itextpdf.text.DocumentException;

import rs.ijz.server.model.resenje_zahtev_odbijen.ResenjeZahtevOdbijen;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.ResenjeZahtevOdbijenRepository;

@Service
public class ResenjeZahtevOdbijenService {
	
    @Autowired
    private CommonRepository commonRepository;
    
    @Autowired
    private ResenjeZahtevOdbijenRepository resenjeZahtevOdbijenRepository;
    
    @Autowired
    private DocumentService documentService;

    public List<ResenjeZahtevOdbijen> findAll() throws XMLDBException {
        String xPath = "/rzho:ResenjeZahtevOdbijen";
        ResourceSet result = commonRepository.queryResenjeZahtevOdbijen(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (List<ResenjeZahtevOdbijen>) commonRepository.resourceSetToClass(result, ResenjeZahtevOdbijen.class);
    }

    public ResenjeZahtevOdbijen getOne(String id) throws XMLDBException {
        String xPath = "/rzho:ResenjeZahtevOdbijen[@id='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZahtevOdbijen(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ResenjeZahtevOdbijen) commonRepository.resourceSetToClass(result, ResenjeZahtevOdbijen.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/rzho:ResenjeZahtevOdbijen[@id='" + id + "']";
        return commonRepository.queryResenjeZahtevOdbijen(xPath).getSize() != 0;
    }

    public ResenjeZahtevOdbijen create(ResenjeZahtevOdbijen resenjeZahtevOdbijen) throws Exception {
        if (existsById(resenjeZahtevOdbijen.getID())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return resenjeZahtevOdbijenRepository.save(resenjeZahtevOdbijen);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/rzho:ResenjeZahtevOdbijen[@id='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZahtevOdbijen(xPath);
        ResenjeZahtevOdbijen resenjeZahtevOdbijen = (ResenjeZahtevOdbijen) commonRepository.resourceSetToClass(result, ResenjeZahtevOdbijen.class);
        String xmlInstance = "data/xsd/instance/" + "resenje-zahtev-odbijen-" + id + ".xml";
        String xml = "data/xml/" + "resenje-zahtev-odbijen_" + id + ".xml";
        documentService.createXML(ResenjeZahtevOdbijen.class, resenjeZahtevOdbijen, xmlInstance);
        System.out.println("Docs generated!");
    }
}
