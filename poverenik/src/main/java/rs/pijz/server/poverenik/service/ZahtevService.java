package rs.pijz.server.poverenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import rs.pijz.server.poverenik.dto.sparql.ZahtevSPARQL;
import rs.pijz.server.poverenik.fuseki.FusekiReader;
import rs.pijz.server.poverenik.model.zahtev.Zahtev;
import rs.pijz.server.poverenik.repository.CommonRepository;
import rs.pijz.server.poverenik.repository.ZahtevRepository;
import rs.pijz.server.poverenik.soap.client.ZahtevClient;
import rs.pijz.server.poverenik.soap.communication.zahtev.ExchangeZahtevResponse;
import rs.pijz.server.poverenik.soap.communication.zahtev.GetZahtevResponse;
import rs.pijz.server.poverenik.util.xslfo.XSLFOTransformer;

@Service
public class ZahtevService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ZahtevRepository zahtevRepository;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private ZahtevClient zahtevClient;

    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/zahtev.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/zahtev.xsl";

    private final String htmlOutput = "../data/html/zahtev.html";
    private final String pdfOutput = "../data/pdf/zahtev.pdf";
    
    private static final String QUERY_FILEPATH = "src/main/resources/rq/zahtev.rq";

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

    public List<Zahtev> findAllByGradjanin(String id) throws XMLDBException {
        String xPath = "/z:Zahtev[@gradjaninID='" + id + "']";
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

    public List<Zahtev> findAllBySluzbenik(String id) throws XMLDBException {
        String xPath = "/z:Zahtev[@sluzbenikID='" + id + "']";
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

    public List<Zahtev> findAllByDatum(Date datum) throws XMLDBException {
        String xPath = "/z:Zahtev[@datum='" + datum + "']";
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
        if (zahtev.getId() == null || zahtev.getId().equals("")) {
            zahtev.setId(UUID.randomUUID().toString());
        }
        while (existsById(zahtev.getId())) {
            zahtev.setId(UUID.randomUUID().toString());
        }
        
        this.exchangeSOAP(zahtev);
        
        return zahtevRepository.save(zahtev);
    }

    public Zahtev edit(Zahtev zahtev) throws Exception {
        return zahtevRepository.edit(zahtev);
    }

    public Boolean delete(String id) throws Exception {
        zahtevRepository.delete(id);
        return !existsById(id);
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
    
    public ArrayList<String> searchMetadata(ZahtevSPARQL zahtevSPARQL, String dataset) throws IOException {
		Map<String, String> params = new HashMap<>();
		params.put("ime", zahtevSPARQL.getIme());
		params.put("prezime", zahtevSPARQL.getPrezime());

		ArrayList<String> result = FusekiReader.executeQuery(params, QUERY_FILEPATH, dataset);
		return result;
	}
    
    // SOAP communications
    
    public Zahtev getOneSOAP(String id) {
    	GetZahtevResponse response = zahtevClient.getZahtev(id);
    	return response.getZahtev();
    }
    
    public Boolean exchangeSOAP(Zahtev zahtev) {
    	ExchangeZahtevResponse response = zahtevClient.exchangeZahtev(zahtev);
    	return response.isStatus();
    }
}
