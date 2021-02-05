package rs.pijz.server.poverenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import com.itextpdf.text.DocumentException;

import rs.pijz.server.poverenik.model.sluzbenik.Sluzbenik;
import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.ZalbaOdlukaRepository;
import rs.pijz.server.poverenik.service.auth.intf.AuthenticationService;
import rs.pijz.server.poverenik.soap.client.ZalbaClient;
import rs.pijz.server.poverenik.soap.client.ZalbaOdlukaClient;
import rs.pijz.server.poverenik.soap.communication.zalba.SendZalbaSluzbenikResponse;
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
    private ZalbaClient zalbaClient;
    
    @Autowired
    private ZalbaOdlukaClient zalbaOdlukaClient;

    @Autowired
    private XSLFOTransformer xslfoTransformer;

    @Autowired
    private SluzbenikService sluzbenikService;

    @Autowired
    private GradjaninService gradjaninService;

    @Autowired
    private FileService fileService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private AuthenticationService authenticationService;

    private final String mailOutput = "src/main/resources/output/";

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

    public List<ZalbaOdluka> findAllByGradjanin(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@gradjaninID='" + id + "']";
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

    public List<ZalbaOdluka> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@sluzbenikID='" + id + "']";
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

    public List<ZalbaOdluka> findAllByPoverenik(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@poverenikID='" + id + "']";
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

    public List<ZalbaOdluka> findAllByBroj(String broj) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@broj='" + broj + "']";
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

    public List<ZalbaOdluka> findAllByZahtevId(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@zahtevID='" + id + "']";
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

    public List<ZalbaOdluka> findAllByObavestenjeId(String id) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@obavestenjeID='" + id + "']";
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

    public List<ZalbaOdluka> findAllByDatum(Date datum) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@datum='" + datum + "']";
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

    public List<ZalbaOdluka> findAllByDatumZahteva(Date datum) throws XMLDBException {
        String xPath = "/zo:ZalbaOdluka[@datum_zahteva='" + datum + "']";
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
        if (zalbaOdluka.getId() == null || zalbaOdluka.getId().equals("")) {
            zalbaOdluka.setId(UUID.randomUUID().toString());
        }
        while (existsById(zalbaOdluka.getId())) {
            zalbaOdluka.setId(UUID.randomUUID().toString());
        }
        Sluzbenik sluzbenik = sluzbenikService.getOne(zalbaOdluka.getSluzbenikID());
        String poverenik = authenticationService.getUsername();
        ZalbaOdluka zc = zalbaOdlukaRepository.save(zalbaOdluka);
        generateDocuments(zalbaOdluka.getId());
        String xml = domParserService.readXMLFile(fileService.getFile("zalba-odluka-" + zc.getId() + ".xml"));

        String xhtmlURL = String.format("http://localhost:8081/file/download/%s", this.convertToHTMLMail(xml, zc.getId()));
        String pdfURL = String.format("http://localhost:8081/file/download/%s", this.convertToPDFMail(xml, zc.getId()));
        this.exchangeSOAP(zc);

        GregorianCalendar now = new GregorianCalendar();
        this.sendZalbaSluzbenikSOAP("djvlada03@gmail.com", zc.getZahtevID(), DatatypeFactory.newInstance().newXMLGregorianCalendar(now), poverenik, xhtmlURL, pdfURL);

        return zc;
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

    public String convertToHTMLMail(String xml, String id) throws Exception {
        String name = String.format("zalba-odluka-%s.html", id);
        xslfoTransformer.generateHTML(xml, String.format("%s/%s", mailOutput, name), xslTemplatePath);

        return name;
    }

    public String convertToPDFMail(String xml, String id) throws Exception {
        String name = String.format("zalba-odluka-%s.pdf", id);
        xslfoTransformer.generatePDF(xml, String.format("%s/%s", mailOutput, name), xslfoTemplatePath);

        return name;
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
    
    public Boolean sendZalbaSluzbenikSOAP(String username, String zalbaID, XMLGregorianCalendar date, String poverenik, String xhtmlURL, String pdfURL) {
    	SendZalbaSluzbenikResponse response = zalbaClient.sendZalbaSluzbenik(username, zalbaID, date, poverenik, xhtmlURL, pdfURL);
    	return response.isStatus();
    }
}
