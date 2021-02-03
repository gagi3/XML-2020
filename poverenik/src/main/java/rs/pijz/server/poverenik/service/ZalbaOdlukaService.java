package rs.pijz.server.poverenik.service;

import java.io.ByteArrayOutputStream;
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

import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.ZalbaOdlukaRepository;
import rs.pijz.server.poverenik.soap.client.ZalbaOdlukaClient;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.ExchangeZalbaOdlukaResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.GetZalbaOdlukaResponse;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

@Service
public class ZalbaOdlukaService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ZalbaOdlukaRepository zalbaOdlukaRepository;
    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private ZalbaOdlukaClient zalbaOdlukaClient;

    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/zalba-odluka.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/zalba-odluka.xsl";

    private final String htmlOutput = "../data/html/zalba-odluka.html";
    private final String pdfOutput = "../data/pdf/zalba-odluka.pdf";

    public List<ZalbaOdluka> findAll() throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka";
        ResourceSet result = commonRepository.queryZalbaOdluka(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaOdluka> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaOdluka) commonRepository.resourceToClass(iterator.nextResource(), ZalbaOdluka.class));
        }
        return results;
    }

    public ZalbaOdluka getOne(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaOdluka(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (ZalbaOdluka) commonRepository.resourceSetToClass(result, ZalbaOdluka.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@id='" + id + "']";
        return commonRepository.queryZalbaOdluka(xPath).getSize() != 0;
    }

    public ZalbaOdluka create(ZalbaOdluka zalbaOdluka) throws Exception {
        if (existsById(zalbaOdluka.getId())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return zalbaOdlukaRepository.save(zalbaOdluka);
    }

    public ZalbaOdluka edit(ZalbaOdluka zalbaOdluka) throws Exception {
        return zalbaOdlukaRepository.edit(zalbaOdluka);
    }

    public Boolean delete(String id) throws Exception {
        zalbaOdlukaRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/zo:ZalbaOdluka[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaOdluka(xPath);
        ZalbaOdluka zalbaOdluka = (ZalbaOdluka) commonRepository.resourceSetToClass(result, ZalbaOdluka.class);
        String xmlInstance = "../data/xsd/instance/" + "zalba-odluka-" + id + ".xml";
        String xml = "../data/xml/" + "zalba-odluka_" + id + ".xml";
        documentService.createXML(ZalbaOdluka.class, zalbaOdluka, xmlInstance);
        System.out.println("Docs generated!");
    }

    public String convertToHTML(String xml) throws Exception {
        return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }

    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
        return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
    }
    
    // SOAP communications
    
    public ZalbaOdluka getOneSOAP(String id) {
    	GetZalbaOdlukaResponse response = zalbaOdlukaClient.getZalbaOdluka(id);
    	return response.getZalbaOdluka();
    }
    
    public Boolean exchangeSOAP(ZalbaOdluka zalbaOdluka) {
    	ExchangeZalbaOdlukaResponse response = zalbaOdlukaClient.exchangeZalbaOdluka(zalbaOdluka);
    	return response.isStatus();
    }
}
