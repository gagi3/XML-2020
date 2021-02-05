package rs.pijz.server.sluzbenik.service;

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

import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.IzvestajRepository;
import rs.pijz.server.sluzbenik.soap.client.IzvestajClient;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.ExchangeIzvestajResponse;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.GetIzvestajResponse;
import rs.pijz.server.sluzbenik.util.xslfo.XSLFOTransformer;

@Service
public class IzvestajService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private IzvestajRepository izvestajRepository;
    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private IzvestajClient izvestajClient;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/izvestaj.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/izvestaj.xsl";

    private final String htmlOutput = "../data/html/izvestaj.html";
    private final String pdfOutput = "../data/pdf/izvestaj.pdf";

    public List<Izvestaj> findAll() throws XMLDBException {
        String xPath = "/iz:Izvestaj";
        ResourceSet result = commonRepository.queryIzvestaj(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Izvestaj> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Izvestaj) commonRepository.resourceToClass(iterator.nextResource(), Izvestaj.class));
        }
        return results;
    }

    public List<Izvestaj> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/iz:Izvestaj[@sluzbenikID='" + id + "']";
        ResourceSet result = commonRepository.queryIzvestaj(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Izvestaj> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Izvestaj) commonRepository.resourceToClass(iterator.nextResource(), Izvestaj.class));
        }
        return results;
    }

    public Izvestaj getOne(String id) throws XMLDBException {
        String xPath = "/iz:Izvestaj[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzvestaj(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Izvestaj) commonRepository.resourceSetToClass(result, Izvestaj.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/iz:Izvestaj[@id='" + id + "']";
        return commonRepository.queryIzvestaj(xPath).getSize() != 0;
    }

    public Izvestaj create(Izvestaj izvestaj) throws Exception {
        if (existsById(izvestaj.getId())) {
            throw new Exception("Izvestaj sa istim ID vec postoji!");
        }
        
        this.exchangeSOAP(izvestaj);
        
        return izvestajRepository.save(izvestaj);
    }

    public Izvestaj edit(Izvestaj izvestaj) throws Exception {
        return izvestajRepository.edit(izvestaj);
    }

    public Boolean delete(String id) throws Exception {
        izvestajRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/iz:Izvestaj[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzvestaj(xPath);
        Izvestaj izvestaj = (Izvestaj) commonRepository.resourceSetToClass(result, Izvestaj.class);
        String xmlInstance = "../data/xsd/instance/" + "izvestaj-" + id + ".xml";
        String xml = "../data/xml/" + "izvestaj-" + id + ".xml";
        documentService.createXML(Izvestaj.class, izvestaj, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
        return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }

    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
        return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
    }
    
	// SOAP communications
    
    public Izvestaj getOneSOAP(String id) {
    	GetIzvestajResponse response = izvestajClient.getIzvestaj(id);
    	return response.getIzvestaj();
    }
    
    public Boolean exchangeSOAP(Izvestaj izvestaj) {
    	ExchangeIzvestajResponse response = izvestajClient.exchangeIzvestaj(izvestaj);
    	return response.isStatus();
    }
}
