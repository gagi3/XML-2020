package rs.pijz.server.poverenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import rs.pijz.server.poverenik.dto.sparql.IzjasnjenjeNaZalbuSPARQL;
import rs.pijz.server.poverenik.dto.sparql.ResenjeSPARQL;
import rs.pijz.server.poverenik.fuseki.FusekiReader;
import rs.pijz.server.poverenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.IzjasnjenjeNaZalbuRepository;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    
    private static final String QUERY_FILEPATH = "src/main/resources/rq/izjasnjenje-na-zalbu.rq";

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
    
    public ArrayList<String> searchMetadata(IzjasnjenjeNaZalbuSPARQL izjasnjenjeNaZalbuSPARQL, String dataset) throws IOException {
		Map<String, String> params = new HashMap<>();
		params.put("tekstIzjave", izjasnjenjeNaZalbuSPARQL.getTekstIzjave());

		ArrayList<String> result = FusekiReader.executeQuery(params, QUERY_FILEPATH, dataset);
		return result;
	}
}
