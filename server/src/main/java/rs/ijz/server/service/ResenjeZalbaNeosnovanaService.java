package rs.ijz.server.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import com.itextpdf.text.DocumentException;

import rs.ijz.server.model.resenje_zalba_neosnovana.ResenjeZalbaNeosnovana;
import rs.ijz.server.model.resenje_zalba_osnovana.ResenjeZalbaOsnovana;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.ResenjeZalbaNeosnovanaRepository;

@Service
public class ResenjeZalbaNeosnovanaService {
	
    @Autowired
    private CommonRepository commonRepository;
    
    @Autowired
    private ResenjeZalbaNeosnovanaRepository resenjeZalbaNeosnovanaRepository;
    
    @Autowired
    private DocumentService documentService;

    public List<ResenjeZalbaNeosnovana> findAll() throws XMLDBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana";
        ResourceSet result = commonRepository.queryResenjeZalbaNeosnovana(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ResenjeZalbaNeosnovana> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ResenjeZalbaNeosnovana) commonRepository.resourceToClass(iterator.nextResource(), ResenjeZalbaNeosnovana.class));
        }
        return results;
    }

    public ResenjeZalbaNeosnovana getOne(String id) throws XMLDBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana[@id='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZalbaNeosnovana(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ResenjeZalbaNeosnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaNeosnovana.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana[@id='" + id + "']";
        return commonRepository.queryResenjeZalbaNeosnovana(xPath).getSize() != 0;
    }

    public ResenjeZalbaNeosnovana create(ResenjeZalbaNeosnovana resenjeZalbaNeosnovana) throws Exception {
        if (existsById(resenjeZalbaNeosnovana.getId())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return resenjeZalbaNeosnovanaRepository.save(resenjeZalbaNeosnovana);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/rzn:ResenjeZalbaNeosnovana[@id='" + id + "']";
        ResourceSet result = commonRepository.queryResenjeZalbaNeosnovana(xPath);
        ResenjeZalbaNeosnovana resenjeZalbaNeosnovana = (ResenjeZalbaNeosnovana) commonRepository.resourceSetToClass(result, ResenjeZalbaNeosnovana.class);
        String xmlInstance = "data/xsd/instance/" + "resenje-zalba-neosnovana-" + id + ".xml";
        String xml = "data/xml/" + "resenje-zalba-neosnovana_" + id + ".xml";
        documentService.createXML(ResenjeZalbaNeosnovana.class, resenjeZalbaNeosnovana, xmlInstance);
        System.out.println("Docs generated!");
    }
}
