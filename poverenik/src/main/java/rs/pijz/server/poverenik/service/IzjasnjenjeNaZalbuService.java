package rs.pijz.server.poverenik.service;

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

import rs.pijz.server.poverenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.IzjasnjenjeNaZalbuRepository;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

@Service
public class IzjasnjenjeNaZalbuService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private IzjasnjenjeNaZalbuRepository izjasnjenjeNaZalbuRepository;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;
    
    private String xslTemplatePath = "../data/xsl/izjasnjenje-na-zalbu.xsl";

    public List<IzjasnjenjeNaZalbu> findAll() throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public IzjasnjenjeNaZalbu getOne(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@id='" + id + "']";
        return commonRepository.queryIzjasnjenjeNaZalbu(xPath).getSize() != 0;
    }

    public IzjasnjenjeNaZalbu create(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws Exception {
        if (existsById(izjasnjenjeNaZalbu.getId())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return izjasnjenjeNaZalbuRepository.save(izjasnjenjeNaZalbu);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        IzjasnjenjeNaZalbu izjasnjenjeNaZalbu = (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
        String xmlInstance = "../data/xsd/instance/" + "izjasnjenje-na-zalbu-" + id + ".xml";
        String xml = "../data/xml/" + "izjasnjenje-na-zalbu_" + id + ".xml";
        documentService.createXML(IzjasnjenjeNaZalbu.class, izjasnjenjeNaZalbu, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
    	return xslfoTransformer.generateHTML(xml, xslTemplatePath);
    }
}
