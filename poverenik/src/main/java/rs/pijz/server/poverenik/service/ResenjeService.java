package rs.pijz.server.poverenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.poverenik.model.resenje.Resenje;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.ResenjeRepository;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResenjeService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ResenjeRepository resenjeRepository;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;
    
    private String xslTemplatePath = "../data/xsl/resenje.xsl";

    public List<Resenje> findAll() throws XMLDBException {
        String xPath = "/r:Resenje";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public Resenje getOne(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        System.out.println(result.toString());
        return (Resenje) commonRepository.resourceSetToClass(result, Resenje.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@ID='" + id + "']";
        return commonRepository.queryResenje(xPath).getSize() != 0;
    }

    public Resenje create(Resenje resenje) throws Exception {
        if (existsById(resenje.getID())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return resenjeRepository.save(resenje);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/r:Resenje[@ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        Resenje resenje = (Resenje) commonRepository.resourceSetToClass(result, Resenje.class);
        String xmlInstance = "../data/xsd/instance/" + "resenje-" + id + ".xml";
        String xml = "../data/xml/" + "resenje_" + id + ".xml";
        documentService.createXML(Resenje.class, resenje, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
    	return xslfoTransformer.generateHTML(xml, xslTemplatePath);
    }
}
