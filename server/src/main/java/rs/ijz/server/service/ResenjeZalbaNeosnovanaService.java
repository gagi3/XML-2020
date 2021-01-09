package rs.ijz.server.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.ijz.server.model.ResenjeZalbaNeosnovana;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.ResenjeZalbaNeosnovanaRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Service
public class ResenjeZalbaNeosnovanaService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ResenjeZalbaNeosnovanaRepository resenjeZalbaNeosnovanaRepository;
    @Autowired
    private DocumentService documentService;

    public List<ResenjeZalbaNeosnovana> findAll() {
        return null;
    }

    public ResenjeZalbaNeosnovana getOne(String id) throws XMLDBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana[rzn:resenjeZalbaNeosnovana_ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZalbaNeosnovana(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ResenjeZalbaNeosnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaNeosnovana.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana[rzn:resenjeZalbaNeosnovana_ID='" + id + "']";
        return commonRepository.queryResenjeZalbaNeosnovana(xPath).getSize() != 0;
    }

    public ResenjeZalbaNeosnovana save(ResenjeZalbaNeosnovana resenjeZalbaNeosnovana) throws Exception {
        if (existsById("TODO")) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return resenjeZalbaNeosnovanaRepository.save(resenjeZalbaNeosnovana);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana[rzn:resenjeZalbaNeosnovana_ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZalbaNeosnovana(xPath);
        ResenjeZalbaNeosnovana resenjeZalbaNeosnovana = (ResenjeZalbaNeosnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaNeosnovana.class);
        String xmlInstance = "data/xsd/instance/" + "resenje-zalba-neosnovana-" + id + ".xml";
        String xml = "data/xml/" + "resenje-zalba-neosnovana_" + id + ".xml";
        documentService.createXML(ResenjeZalbaNeosnovana.class, resenjeZalbaNeosnovana, xmlInstance);
        System.out.println("Docs generated!");
    }
}
