package rs.pijz.server.poverenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.poverenik.model.zahtev.Zahtev;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.ZahtevRepository;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZahtevService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ZahtevRepository zahtevRepository;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;
    
    private String xslTemplatePath = "../data/xsl/zahtev.xsl";
    private String xslfoTemplatePath = "../data/xsl-fo/zahtev.xsl";
    
    private String htmlOutput = "../data/html/zahtev.html";
    private String pdfOutput = "../data/pdf/zahtev.pdf";

    public List<Zahtev> findAll() throws XMLDBException {
        String xPath = "/z:Zahtev";
        ResourceSet result = commonRepository.queryZahtev(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Zahtev> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Zahtev) commonRepository.resourceToClass(iterator.nextResource(), Zahtev.class));
        }
        return results;
    }

    public Zahtev getOne(String id) throws XMLDBException {
        String xPath = "/z:Zahtev[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZahtev(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        System.out.println(result.toString());
        return (Zahtev) commonRepository.resourceSetToClass(result, Zahtev.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/z:Zahtev[@id='" + id + "']";
        return commonRepository.queryZahtev(xPath).getSize() != 0;
    }

    public Zahtev create(Zahtev zahtev) throws Exception {
        if (existsById(zahtev.getId())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return zahtevRepository.save(zahtev);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/z:Zahtev[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZahtev(xPath);
        Zahtev zahtev = (Zahtev) commonRepository.resourceSetToClass(result, Zahtev.class);
        String xmlInstance = "../../../data/xsd/instance/" + "zahtev-" + id + ".xml";
        String xml = "../../data/xml/" + "zahtev_" + id + ".xml";
        documentService.createXML(Zahtev.class, zahtev, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
    	return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }
    
    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
		return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
	}
}
