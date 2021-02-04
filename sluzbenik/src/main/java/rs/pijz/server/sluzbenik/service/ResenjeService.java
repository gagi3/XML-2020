package rs.pijz.server.sluzbenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import rs.pijz.server.sluzbenik.model.resenje.Resenje;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.ResenjeRepository;
import rs.pijz.server.sluzbenik.soap.client.ResenjeClient;
import rs.pijz.server.sluzbenik.soap.communication.resenje.SendResenjeGradjaninResponse;
import rs.pijz.server.sluzbenik.soap.communication.resenje.SendResenjeSluzbenikResponse;
import rs.pijz.server.sluzbenik.util.xslfo.XSLFOTransformer;

@Service
public class ResenjeService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ResenjeRepository resenjeRepository;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private ResenjeClient resenjeClient;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/resenje.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/resenje.xsl";

    private final String htmlOutput = "../data/html/resenje.html";
    private final String pdfOutput = "../data/pdf/resenje.pdf";

    public List<Resenje> findAll() throws XMLDBException {
        String xPath = "/r:Resenje";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByGradjanin(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@gradjaninID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@sluzbenikID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByPoverenik(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@poverenikID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByBroj(String broj) throws XMLDBException {
        String xPath = "/r:Resenje[@broj='" + broj + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByZalbaId(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@zalbaID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByDatum(Date datum) throws XMLDBException {
        String xPath = "/r:Resenje[@datum_izjave='" + datum + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByDatumZalbe(Date datum) throws XMLDBException {
        String xPath = "/r:Resenje[@datum_zalbe='" + datum + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByDatumZahteva(Date datum) throws XMLDBException {
        String xPath = "/r:Resenje[@datum_zahteva='" + datum + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public List<Resenje> findAllByDatumPostupka(Date datum) throws XMLDBException {
        String xPath = "/r:Resenje[@datum_postupka='" + datum + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Resenje> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Resenje) commonRepository.resourceToClass(iterator.nextResource(), Resenje.class));
        }
        return results;
    }

    public Resenje getOne(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        System.out.println(result.toString());
        return (Resenje) commonRepository.resourceSetToClass(result, Resenje.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/r:Resenje[@ID='" + id + "']";
        return commonRepository.queryResenje(xPath).getSize() != 0;
    }

    public Resenje create(Resenje resenje) throws Exception {
        if (existsById(resenje.getID())) {
            throw new Exception("Resenje sa istim ID vec postoji!");
        }
        return resenjeRepository.save(resenje);
    }

    public Resenje edit(Resenje resenje) throws Exception {
        return resenjeRepository.edit(resenje);
    }

    public Boolean delete(String id) throws Exception {
        resenjeRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/r:Resenje[@ID='" + id + "']";
        ResourceSet result = commonRepository.queryResenje(xPath);
        Resenje resenje = (Resenje) commonRepository.resourceSetToClass(result, Resenje.class);
        String xmlInstance = "../data/xsd/instance/" + "resenje-" + id + ".xml";
        String xml = "../data/xml/" + "resenje_" + id + ".xml";
        documentService.createXML(Resenje.class, resenje, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
        return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }

    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
        return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
    }
    
    // SOAP communications
    
    public Boolean sendResenjeGradjaninSOAP(String username, String zalbaID, XMLGregorianCalendar date, String poverenik, String xhtmlURL, String pdfURL) {
    	SendResenjeGradjaninResponse response = resenjeClient.sendResenjeGradjaninResponse(username, zalbaID, date, poverenik, xhtmlURL, pdfURL);
    	return response.isStatus();
    }
    
    public Boolean sendResenjeSluzbenikSOAP(String username, String zalbaID, XMLGregorianCalendar date, String poverenik, String xhtmlURL, String pdfURL) {
    	SendResenjeSluzbenikResponse response = resenjeClient.sendResenjeSluzbenikResponse(username, zalbaID, date, poverenik, xhtmlURL, pdfURL);
    	return response.isStatus();
    }
}
