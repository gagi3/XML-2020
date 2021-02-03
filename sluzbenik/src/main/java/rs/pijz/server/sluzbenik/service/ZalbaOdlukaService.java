package rs.pijz.server.sluzbenik.service;

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

import rs.pijz.server.sluzbenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.ZalbaOdlukaRepository;
import rs.pijz.server.sluzbenik.util.xslfo.XSLFOTransformer;

@Service
public class ZalbaOdlukaService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ZalbaOdlukaRepository zalbaOdlukaRepository;
    @Autowired
    private DocumentService documentService;
    
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
}
