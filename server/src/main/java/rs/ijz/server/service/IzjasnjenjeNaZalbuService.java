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

import rs.ijz.server.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.IzjasnjenjeNaZalbuRepository;

@Service
public class IzjasnjenjeNaZalbuService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private IzjasnjenjeNaZalbuRepository izjasnjenjeNaZalbuRepository;

    @Autowired
    private DocumentService documentService;

    public List<IzjasnjenjeNaZalbu> findAll() throws XMLDBException {
        String xPath = "/rzho:IzjasnjenjeNaZalbu";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (List<IzjasnjenjeNaZalbu>) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
    }

    public IzjasnjenjeNaZalbu getOne(String id) throws XMLDBException {
        String xPath = "/rzho:IzjasnjenjeNaZalbu[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/rzho:IzjasnjenjeNaZalbu[@id='" + id + "']";
        return commonRepository.queryIzjasnjenjeNaZalbu(xPath).getSize() != 0;
    }

    public IzjasnjenjeNaZalbu create(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws Exception {
        if (existsById(izjasnjenjeNaZalbu.getId())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return izjasnjenjeNaZalbuRepository.save(izjasnjenjeNaZalbu);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/rzho:IzjasnjenjeNaZalbu[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        IzjasnjenjeNaZalbu izjasnjenjeNaZalbu = (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
        String xmlInstance = "data/xsd/instance/" + "izjasnjenje-na-zalbu-" + id + ".xml";
        String xml = "data/xml/" + "izjasnjenje-na-zalbu_" + id + ".xml";
        documentService.createXML(IzjasnjenjeNaZalbu.class, izjasnjenjeNaZalbu, xmlInstance);
        System.out.println("Docs generated!");
    }
}
