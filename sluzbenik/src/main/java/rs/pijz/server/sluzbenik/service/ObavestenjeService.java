package rs.pijz.server.sluzbenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
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

import rs.pijz.server.sluzbenik.model.obavestenje.Obavestenje;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.ObavestenjeRepository;
import rs.pijz.server.sluzbenik.soap.client.ObavestenjeClient;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.SendObavestenjePoverenikResponse;
import rs.pijz.server.sluzbenik.util.xslfo.XSLFOTransformer;

@Service
public class ObavestenjeService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ObavestenjeRepository obavestenjeRepository;
    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private ObavestenjeClient obavestenjeClient;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/obavestenje.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/obavestenje.xsl";

    private final String htmlOutput = "../data/html/obavestenje.html";
    private final String pdfOutput = "../data/pdf/obavestenje.pdf";

    public List<Obavestenje> findAll() throws XMLDBException {
        String xPath = "/o:Obavestenje";
        ResourceSet result = commonRepository.queryObavestenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Obavestenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Obavestenje) commonRepository.resourceToClass(iterator.nextResource(), Obavestenje.class));
        }
        return results;
    }

    public List<Obavestenje> findAllByGradjanin(String id) throws XMLDBException {
        String xPath = "/o:Obavestenje[@gradjaninID='" + id + "']";
        ResourceSet result = commonRepository.queryObavestenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Obavestenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Obavestenje) commonRepository.resourceToClass(iterator.nextResource(), Obavestenje.class));
        }
        return results;
    }

    public List<Obavestenje> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/o:Obavestenje[@sluzbenikID='" + id + "']";
        ResourceSet result = commonRepository.queryObavestenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Obavestenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Obavestenje) commonRepository.resourceToClass(iterator.nextResource(), Obavestenje.class));
        }
        return results;
    }

    public Obavestenje getOne(String id) throws XMLDBException {
        String xPath = "/o:Obavestenje[@id='" + id + "']";
        ResourceSet result = commonRepository.queryObavestenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Obavestenje) commonRepository.resourceSetToClass(result, Obavestenje.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/o:Obavestenje[@id='" + id + "']";
        return commonRepository.queryObavestenje(xPath).getSize() != 0;
    }

    public Obavestenje create(Obavestenje obavestenje) throws Exception {
        if (existsById(obavestenje.getId())) {
            throw new Exception("Obavestenje sa istim ID vec postoji!");
        }
        return obavestenjeRepository.save(obavestenje);
    }

    public Obavestenje edit(Obavestenje obavestenje) throws Exception {
        return obavestenjeRepository.edit(obavestenje);
    }

    public Boolean delete(String id) throws Exception {
        obavestenjeRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/o:Obavestenje[@id='" + id + "']";
        ResourceSet result = commonRepository.queryObavestenje(xPath);
        Obavestenje obavestenje = (Obavestenje) commonRepository.resourceSetToClass(result, Obavestenje.class);
        String xmlInstance = "../data/xsd/instance/" + "obavestenje-" + id + ".xml";
        String xml = "../data/xml/" + "obavestenje-" + id + ".xml";
        documentService.createXML(Obavestenje.class, obavestenje, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
        return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }

    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
        return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
    }
    
    // SOAP communications
    
    public Boolean sendObavestenjePoverenikSOAP(String username, XMLGregorianCalendar date, String sluzbenik, String xhtmlURL, String pdfURL) {
    	SendObavestenjePoverenikResponse response = obavestenjeClient.sendObavestenjePoverenik(username, date, sluzbenik, xhtmlURL, pdfURL);
    	return response.isStatus();
    }
}
