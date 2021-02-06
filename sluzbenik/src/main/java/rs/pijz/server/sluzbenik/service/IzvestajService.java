package rs.pijz.server.sluzbenik.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;
import rs.pijz.server.sluzbenik.model.izvestaj.ObjectFactory;
import rs.pijz.server.sluzbenik.model.izvestaj.ZalbaSadrzaj;
import rs.pijz.server.sluzbenik.model.sluzbenik.Sluzbenik;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.IzvestajRepository;
import rs.pijz.server.sluzbenik.service.auth.intf.AuthenticationService;
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
    private AuthenticationService authenticationService;
    @Autowired
    private ZalbaOdlukaService zalbaOdlukaService;
    @Autowired
    private ObavestenjeService obavestenjeService;
    @Autowired
    private ZahtevService zahtevService;
    @Autowired
    private SluzbenikService sluzbenikService;
    @Autowired
    private XSLFOTransformer xslfoTransformer;
    @Autowired
    private DomParserService domParserService;
    @Autowired
    private FileService fileService;

    private final String xslTemplatePath = "../data/xsl/izvestaj.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/izvestaj.xsl";

    private final String htmlOutput = "../data/html/izvestaj.html";
    private final String pdfOutput = "../data/pdf/izvestaj.pdf";

    private final String output = "src/main/resources/output/";

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
        if (izvestaj.getId() == null || izvestaj.getId().equals("")) {
            izvestaj.setId(UUID.randomUUID().toString());
        }
        while (existsById(izvestaj.getId())) {
            izvestaj.setId(UUID.randomUUID().toString());
        }
        
        this.exchangeSOAP(izvestaj);
        
        return izvestajRepository.save(izvestaj);
    }

    public Izvestaj generate(String sluzbenikID) throws Exception {
        Sluzbenik sluzbenik = sluzbenikService.getOne(sluzbenikID);
        if (sluzbenik == null) {
            return null;
        }
        Izvestaj izvestaj = new Izvestaj();
        izvestaj.setId(UUID.randomUUID().toString());
        izvestaj.setSluzbenikID(sluzbenikID);
        int boz = 0;
        if (obavestenjeService.findAllBySluzbenikAndRejected(sluzbenikID) != null) {
            boz = obavestenjeService.findAllBySluzbenikAndRejected(sluzbenikID).size();
        }
        izvestaj.setBrojOdbijenihZahteva(boz);
        int bpz = 0;
        if (obavestenjeService.findAllBySluzbenik(sluzbenikID) != null) {
            bpz = obavestenjeService.findAllBySluzbenik(sluzbenikID).size();
        }
        izvestaj.setBrojPodnetihZahteva(bpz);
        int bzo = 0;
        if (zalbaOdlukaService.findAllBySluzbenik(sluzbenikID) != null) {
            bzo = zalbaOdlukaService.findAllBySluzbenik(sluzbenikID).size();
        }
        izvestaj.setBrojZalbiOdluka(bzo);
        izvestaj.setSluzbenikID(sluzbenikID);
        ObjectFactory objectFactory = new ObjectFactory();
        if (zalbaOdlukaService.findAllBySluzbenik(sluzbenikID) != null) {
            zalbaOdlukaService.findAllBySluzbenik(sluzbenikID).forEach(
                    zalba -> {
                        ZalbaSadrzaj zalbaSadrzaj = objectFactory.createZalbaSadrzaj();
                        zalbaSadrzaj.setZalbaID(zalba.getId());
                        zalbaSadrzaj.setSadrzaj(zalba.getRazlogPobijanja());
                        izvestaj.getZalbe().add(zalbaSadrzaj);
                    }
            );
        }
        Izvestaj i = izvestajRepository.save(izvestaj);
        generateDocuments(i.getId());
        String xml = domParserService.readXMLFile(fileService.getFile("izvestaj-" + i.getId() + ".xml"));
        convertToHTMLMail(xml, i.getId());
        convertToPDFMail(xml, i.getId());
        exchangeSOAP(i);
        return i;
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
        String xmlInstance = output + "izvestaj-" + id + ".xml";
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

    public String convertToHTMLMail(String xml, String id) throws Exception {
        String name = String.format("izvestaj-%s.html", id);
        xslfoTransformer.generateHTML(xml, String.format("%s/%s", output, name), xslTemplatePath);

        return name;
    }

    public String convertToPDFMail(String xml, String id) throws Exception {
        String name = String.format("izvestaj-%s.pdf", id);
        xslfoTransformer.generatePDF(xml, String.format("%s/%s", output, name), xslfoTemplatePath);

        return name;
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
