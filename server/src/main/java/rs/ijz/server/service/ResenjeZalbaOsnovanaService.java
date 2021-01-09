package rs.ijz.server.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.ijz.server.model.ResenjeZalbaOsnovana;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.ResenjeZalbaOsnovanaRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Service
public class ResenjeZalbaOsnovanaService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ResenjeZalbaOsnovanaRepository resenjeZalbaOsnovanaRepository;
    @Autowired
    private DocumentService documentService;

    public List<ResenjeZalbaOsnovana> findAll() {
        return null;
    }

    public ResenjeZalbaOsnovana getOne(String id) throws XMLDBException {
        String xPath = "/rzo:ResenjeZalbaOsnovana[rzo:resenjeZalbaOsnovana_ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZalbaOsnovana(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ResenjeZalbaOsnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaOsnovana.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/rzo:ResenjeZalbaOsnovana[rzo:resenjeZalbaOsnovana_ID='" + id + "']";
        return commonRepository.queryResenjeZalbaOsnovana(xPath).getSize() != 0;
    }

    public ResenjeZalbaOsnovana save(ResenjeZalbaOsnovana resenjeZalbaOsnovana) throws Exception {
        if (existsById("TODO")) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return resenjeZalbaOsnovanaRepository.save(resenjeZalbaOsnovana);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/rzo:ResenjeZalbaOsnovana[rzo:resenjeZalbaOsnovana_ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZalbaOsnovana(xPath);
        ResenjeZalbaOsnovana resenjeZalbaOsnovana = (ResenjeZalbaOsnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaOsnovana.class);
        String xmlInstance = "data/xsd/instance/" + "resenje-zalba-osnovana-" + id + ".xml";
        String xml = "data/xml/" + "resenje-zalba-osnovana_" + id + ".xml";
        documentService.createXML(ResenjeZalbaOsnovana.class, resenjeZalbaOsnovana, xmlInstance);
        System.out.println("Docs generated!");
    }
}