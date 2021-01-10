package rs.ijz.server.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.ijz.server.model.ZalbaCutanje;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.ZalbaCutanjeRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Service
public class ZalbaCutanjeService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ZalbaCutanjeRepository zalbaCutanjeRepository;
    @Autowired
    private DocumentService documentService;

    public List<ZalbaCutanje> findAll() throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (List<ZalbaCutanje>) commonRepository.resourceSetToClass(result, ZalbaCutanje.class);
    }

    public ZalbaCutanje getOne(String id) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ZalbaCutanje) commonRepository.resourceSetToClass(result, ZalbaCutanje.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@id='" + id + "']";
        return commonRepository.queryZalbaCutanje(xPath).getSize() != 0;
    }

    public ZalbaCutanje create(ZalbaCutanje zalbaCutanje) throws Exception {
        if (existsById("TODO")) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return zalbaCutanjeRepository.save(zalbaCutanje);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/zc:ZalbaCutanje[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        ZalbaCutanje zalbaCutanje = (ZalbaCutanje) commonRepository.resourceSetToClass(result, ZalbaCutanje.class);
        String xmlInstance = "data/xsd/instance/" + "zalba-cutanje-" + id + ".xml";
        String xml = "data/xml/" + "zalba-cutanje-" + id + ".xml";
        documentService.createXML(ZalbaCutanje.class, zalbaCutanje, xmlInstance);
        System.out.println("Docs generated!");
    }
}
