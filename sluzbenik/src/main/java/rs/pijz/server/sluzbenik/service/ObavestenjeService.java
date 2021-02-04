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

import rs.pijz.server.sluzbenik.model.gradjanin.Gradjanin;
import rs.pijz.server.sluzbenik.model.obavestenje.Obavestenje;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.ObavestenjeRepository;
import rs.pijz.server.sluzbenik.service.auth.intf.AuthenticationService;
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
    private AuthenticationService authenticationService;
    
    @Autowired
    private DocumentService documentService;
    
    @Autowired 
    private GradjaninService gradjaninService;
    
    @Autowired
    private ObavestenjeClient obavestenjeClient;
    
    @Autowired
    private XSLFOTransformer xslfoTransformer;

    private final String xslTemplatePath = "../data/xsl/obavestenje.xsl";
    private final String xslfoTemplatePath = "../data/xsl-fo/obavestenje.xsl";

    private final String htmlOutput = "../data/html/obavestenje.html";
    private final String pdfOutput = "../data/pdf/obavestenje.pdf";
    
    private final String mailOutput = "src/main/resources/output";

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
        
        Gradjanin gradjanin = gradjaninService.getOne(obavestenje.getGradjaninID());
        String sluzbenik = authenticationService.getUsername();
        
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        		+ "<?xml-stylesheet type=\"text/xsl\" href=\"../xsl-fo/obavestenje.xsl\"?>\n"
        		+ "<o:Obavestenje xmlns:vc=\"http://www.w3.org/2007/XMLSchema-versioning\"\n"
        		+ " xmlns:cmn=\"http://www.pijz.rs/common\"\n"
        		+ " xmlns:o=\"http://www.pijz.rs/obavestenje\"\n"
        		+ " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
        		+ " xsi:schemaLocation=\"http://www.pijz.rs/obavestenje file:/D:/College/XML%202020/Project/XML-2020/data/xsd/obavestenje.xsd\" id=\"ID000\" broj=\"33-2102/2311\" datum=\"2006-05-04\" datum_zahtevanja=\"2006-05-04\" datum_uvida=\"2006-05-04\" vreme_uvida_od=\"01:01:01.001\"\n"
        		+ "     vreme_uvida_do=\"01:01:01.001\">\n"
        		+ "    <o:metadata>\n"
        		+ "        <cmn:meta property=\"property0\" content=\"content0\">meta0</cmn:meta>\n"
        		+ "        <cmn:meta property=\"property1\" content=\"content1\">meta1</cmn:meta>\n"
        		+ "        <cmn:meta property=\"property2\" content=\"content2\">meta2</cmn:meta>\n"
        		+ "    </o:metadata>\n"
        		+ "    <o:organ>\n"
        		+ "        <o:naziv>Основни кривични суд</o:naziv>\n"
        		+ "        <o:sediste>\n"
        		+ "            <cmn:grad>Нови Сад</cmn:grad>\n"
        		+ "            <cmn:ulica>Његошева</cmn:ulica>\n"
        		+ "            <cmn:broj>3</cmn:broj>\n"
        		+ "        </o:sediste>\n"
        		+ "    </o:organ>\n"
        		+ "    <o:podnosilac>\n"
        		+ "        <o:fizickoLice>\n"
        		+ "            <cmn:ime>Николина</cmn:ime>\n"
        		+ "            <cmn:prezime>Марковић</cmn:prezime>\n"
        		+ "            <cmn:adresa>\n"
        		+ "                <cmn:grad>Нови Сад</cmn:grad>\n"
        		+ "                <cmn:ulica>Булевар Ослобођења</cmn:ulica>\n"
        		+ "                <cmn:broj>99а</cmn:broj>\n"
        		+ "            </cmn:adresa>\n"
        		+ "        </o:fizickoLice>\n"
        		+ "    </o:podnosilac>\n"
        		+ "    <o:naslov>О Б А В Е Ш Т Е Њ Е</o:naslov>\n"
        		+ "    <o:podnaslov>о стављању на увид документа који садржи тражену информацију и о изради копије</o:podnaslov>\n"
        		+ "    <o:telo>\n"
        		+ "        <o:paragraf>paragraf0</o:paragraf>\n"
        		+ "        <o:paragraf>paragraf1</o:paragraf>\n"
        		+ "        <o:paragraf>paragraf2</o:paragraf>\n"
        		+ "    </o:telo>\n"
        		+ "    <o:podnozje>\n"
        		+ "        <o:pecat>П Е Ч А Т</o:pecat>\n"
        		+ "        <o:potpis>П О Т П И С</o:potpis>\n"
        		+ "    </o:podnozje>\n"
        		+ "    <o:cena>850</o:cena>\n"
        		+ "    <o:informacija>информација о јавној доступности документа о статусу националних мањина</o:informacija>\n"
        		+ "</o:Obavestenje>\n"
        		+ "";
        
        String xhtmlURL = String.format("http://localhost:8082/file/download/%s", this.convertToHTMLMail(xml, obavestenje.getId()));
        String pdfURL = String.format("http://localhost:8082/file/download/%s", this.convertToPDFMail(xml, obavestenje.getId()));
        
        this.sendObavestenjePoverenikSOAP("djordjesevic@gmail.com", obavestenje.getDatumZahtevanja(), sluzbenik, xhtmlURL, pdfURL);
        
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
    
    public String convertToHTMLMail(String xml, String id) throws Exception {
    	String name = String.format("obavestenje-%s.html", id);
        xslfoTransformer.generateHTML(xml, String.format("%s/%s", mailOutput, name), xslTemplatePath);
        
        return name;
    }
    
    public String convertToPDFMail(String xml, String id) throws Exception {
    	String name = String.format("obavestenje-%s.pdf", id);
        xslfoTransformer.generatePDF(xml, String.format("%s/%s", mailOutput, name), xslfoTemplatePath);
        
        return name;
    }
    
    // SOAP communications
    
    public Boolean sendObavestenjePoverenikSOAP(String username, XMLGregorianCalendar date, String sluzbenik, String xhtmlURL, String pdfURL) {
    	SendObavestenjePoverenikResponse response = obavestenjeClient.sendObavestenjePoverenik(username, date, sluzbenik, xhtmlURL, pdfURL);
    	return response.isStatus();
    }
}
