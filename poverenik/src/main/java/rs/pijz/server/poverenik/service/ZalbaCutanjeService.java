package rs.pijz.server.poverenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import rs.pijz.server.poverenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.ZalbaCutanjeRepository;
import rs.pijz.server.poverenik.soap.client.ZalbaCutanjeClient;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.ExchangeZalbaCutanjeResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeResponse;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

@Service
public class ZalbaCutanjeService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ZalbaCutanjeRepository zalbaCutanjeRepository;
    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private ZalbaCutanjeClient zalbaCutanjeClient;

    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/zalba-cutanje.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/zalba-cutanje.xsl";

    private final String htmlOutput = "../data/html/zalba-cutanje.html";
    private final String pdfOutput = "../data/pdf/zalba-cutanje.pdf";

    public List<ZalbaCutanje> findAll() throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllByGradjanin(String id) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@gradjaninID='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@sluzbenikID='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllByPoverenik(String id) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@poverenikID='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllByBroj(String broj) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@broj='" + broj + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllByZahtevId(String id) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@zahtevID='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllByDatum(Date datum) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@datum='" + datum + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
    }

    public List<ZalbaCutanje> findAllByDatumZahteva(Date datum) throws XMLDBException {
        String xPath = "/zc:ZalbaCutanje[@datum_zahteva='" + datum + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<ZalbaCutanje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((ZalbaCutanje) commonRepository.resourceToClass(iterator.nextResource(), ZalbaCutanje.class));
        }
        return results;
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
        if (existsById(zalbaCutanje.getId())) {
            throw new Exception("Zalba sa istim ID vec postoji!");
        }
        return zalbaCutanjeRepository.save(zalbaCutanje);
    }

    public ZalbaCutanje edit(ZalbaCutanje zalbaCutanje) throws Exception {
        return zalbaCutanjeRepository.edit(zalbaCutanje);
    }

    public Boolean delete(String id) throws Exception {
        zalbaCutanjeRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/zc:ZalbaCutanje[@id='" + id + "']";
        ResourceSet result = commonRepository.queryZalbaCutanje(xPath);
        ZalbaCutanje zalbaCutanje = (ZalbaCutanje) commonRepository.resourceSetToClass(result, ZalbaCutanje.class);
        String xmlInstance = "../data/xsd/instance/" + "zalba-cutanje-" + id + ".xml";
        String xml = "../data/xml/" + "zalba-cutanje-" + id + ".xml";
        documentService.createXML(ZalbaCutanje.class, zalbaCutanje, xmlInstance);
        System.out.println("Docs generated!");
    }

    public String convertToHTML(String xml) throws Exception {
        return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }

    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
        return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
    }
    
    // SOAP communications
    
    public ZalbaCutanje getOneSOAP(String id) {
    	GetZalbaCutanjeResponse response = zalbaCutanjeClient.getZalbaCutanje(id);
    	return response.getZalbaCutanje();
    }
    
    public Boolean exchangeSOAP(ZalbaCutanje zalbaCutanje) {
    	ExchangeZalbaCutanjeResponse response = zalbaCutanjeClient.exchangeZalbaCutanje(zalbaCutanje);
    	return response.isStatus();
    }
}
