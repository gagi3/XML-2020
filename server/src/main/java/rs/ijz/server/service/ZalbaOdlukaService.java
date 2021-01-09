package rs.ijz.server.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.ijz.server.model.ZalbaOdluka;
import rs.ijz.server.repository.CommonRepository;
import rs.ijz.server.repository.ZalbaOdlukaRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Service
public class ZalbaOdlukaService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ZalbaOdlukaRepository zalbaOdlukaRepository;
    @Autowired
    private DocumentService documentService;

    public List<ZalbaOdluka> findAll() {
        return null;
    }

    public ZalbaOdluka getOne(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[zo:zalbaOdluka_ID='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaOdluka(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ZalbaOdluka) commonRepository.resourceSetToClass(result, ZalbaOdluka.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[zo:zalbaOdluka_ID='" + id + "']";
        return commonRepository.queryZalbaOdluka(xPath).getSize() != 0;
    }

    public ZalbaOdluka create(ZalbaOdluka zalbaOdluka) throws Exception {
        if (existsById("TODO")) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return zalbaOdlukaRepository.save(zalbaOdluka);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/zo:ZalbaOdluka[zo:zalbaOdluka_ID='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaOdluka(xPath);
        ZalbaOdluka zalbaOdluka = (ZalbaOdluka) commonRepository.resourceSetToClass(result, ZalbaOdluka.class);
        String xmlInstance = "data/xsd/instance/" + "zalba-odluka-" + id + ".xml";
        String xml = "data/xml/" + "zalba-odluka_" + id + ".xml";
        documentService.createXML(ZalbaOdluka.class, zalbaOdluka, xmlInstance);
        System.out.println("Docs generated!");
    }
}
