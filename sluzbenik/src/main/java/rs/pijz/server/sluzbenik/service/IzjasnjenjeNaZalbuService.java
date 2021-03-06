package rs.pijz.server.sluzbenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

import rs.pijz.server.sluzbenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.IzjasnjenjeNaZalbuRepository;
import rs.pijz.server.sluzbenik.util.xslfo.XSLFOTransformer;

@Service
public class IzjasnjenjeNaZalbuService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private IzjasnjenjeNaZalbuRepository izjasnjenjeNaZalbuRepository;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/izjasnjenje-na-zalbu.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/izjasnjenje-na-zalbu.xsl";

    private final String htmlOutput = "../data/html/izjasnjenje-na-zalbu.html";
    private final String pdfOutput = "../data/pdf/izjasnjenje-na-zalbu.pdf";

    public List<IzjasnjenjeNaZalbu> findAll() throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public List<IzjasnjenjeNaZalbu> findAllByGradjanin(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@gradjaninID='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public List<IzjasnjenjeNaZalbu> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@sluzbenikID='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public List<IzjasnjenjeNaZalbu> findAllByPoverenik(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@poverenikID='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public List<IzjasnjenjeNaZalbu> findAllByBroj(String broj) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@broj='" + broj + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public List<IzjasnjenjeNaZalbu> findAllByBrojZalbe(String broj) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@broj_zalbe='" + broj + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public List<IzjasnjenjeNaZalbu> findAllByDatum(Date datum) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@datum_izjave='" + datum + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<IzjasnjenjeNaZalbu> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((IzjasnjenjeNaZalbu) commonRepository.resourceToClass(iterator.nextResource(), IzjasnjenjeNaZalbu.class));
        }
        return results;
    }

    public IzjasnjenjeNaZalbu getOne(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@id='" + id + "']";
        return commonRepository.queryIzjasnjenjeNaZalbu(xPath).getSize() != 0;
    }

    public IzjasnjenjeNaZalbu create(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws Exception {
        if (izjasnjenjeNaZalbu.getId() == null || izjasnjenjeNaZalbu.getId().equals("")) {
            izjasnjenjeNaZalbu.setId(UUID.randomUUID().toString());
        }
        while (existsById(izjasnjenjeNaZalbu.getId())) {
            izjasnjenjeNaZalbu.setId(UUID.randomUUID().toString());
        }
        return izjasnjenjeNaZalbuRepository.save(izjasnjenjeNaZalbu);
    }

    public IzjasnjenjeNaZalbu edit(IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) throws Exception {
        return izjasnjenjeNaZalbuRepository.edit(izjasnjenjeNaZalbu);
    }

    public Boolean delete(String id) throws Exception {
        izjasnjenjeNaZalbuRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/i:IzjasnjenjeNaZalbu[@id='" + id + "']";
        ResourceSet result = commonRepository.queryIzjasnjenjeNaZalbu(xPath);
        IzjasnjenjeNaZalbu izjasnjenjeNaZalbu = (IzjasnjenjeNaZalbu) commonRepository.resourceSetToClass(result, IzjasnjenjeNaZalbu.class);
        String xmlInstance = "../data/xsd/instance/" + "izjasnjenje-na-zalbu-" + id + ".xml";
        String xml = "../data/xml/" + "izjasnjenje-na-zalbu_" + id + ".xml";
        documentService.createXML(IzjasnjenjeNaZalbu.class, izjasnjenjeNaZalbu, xmlInstance);
        System.out.println("Docs generated!");
    }
    
    public String convertToHTML(String xml) throws Exception {
        return xslfoTransformer.generateHTML(xml, htmlOutput, xslTemplatePath);
    }

    public ByteArrayOutputStream convertToPDF(String xml) throws Exception {
        return xslfoTransformer.generatePDF(xml, pdfOutput, xslfoTemplatePath);
    }
}
