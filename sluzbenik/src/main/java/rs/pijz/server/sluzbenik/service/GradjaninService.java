package rs.pijz.server.sluzbenik.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.sluzbenik.model.gradjanin.Gradjanin;
import rs.pijz.server.sluzbenik.repository.CommonRepository;
import rs.pijz.server.sluzbenik.repository.GradjaninRepository;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradjaninService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private GradjaninRepository gradjaninRepository;
    @Autowired
    private DocumentService documentService;

    public List<Gradjanin> findAll() throws XMLDBException {
        String xPath = "/g:Gradjanin";
        ResourceSet result = commonRepository.queryGradjanin(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        List<Gradjanin> results = new ArrayList<>();
        ResourceIterator iterator = result.getIterator();
        while (iterator.hasMoreResources()) {
            results.add((Gradjanin) commonRepository.resourceToClass(iterator.nextResource(), Gradjanin.class));
        }
        return results;
    }

    public Gradjanin getOne(String id) throws XMLDBException {
        String xPath = "/g:Gradjanin[g:korisnik[@id='" + id + "']]";
        ResourceSet result = commonRepository.queryGradjanin(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Gradjanin) commonRepository.resourceSetToClass(result, Gradjanin.class);
    }

    public Boolean existsById(String id) throws XMLDBException {
        String xPath = "/g:Gradjanin[g:korisnik[@id='" + id + "']]";
        return commonRepository.queryGradjanin(xPath).getSize() != 0;
    }

    public Gradjanin getByUsername(String username) throws XMLDBException {
        String xPath = "/g:Gradjanin[g:korisnik[@username='" + username + "']]";
        ResourceSet result = commonRepository.queryGradjanin(xPath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Gradjanin) commonRepository.resourceSetToClass(result, Gradjanin.class);
    }

    public Boolean existsByUsername(String username) throws XMLDBException {
        String xPath = "/g:Gradjanin[g:korisnik[@username='" + username + "']]";
        return commonRepository.queryGradjanin(xPath).getSize() != 0;
    }

    public Gradjanin create(Gradjanin gradjanin) throws Exception {
        if (existsById(gradjanin.getKorisnik().getId())) {
            throw new Exception("Gradjanin sa istim ID vec postoji!");
        }
        if (existsByUsername(gradjanin.getKorisnik().getUsername())) {
            throw new Exception("Gradjanin sa istom email adresom vec postoji!");
        }
        return gradjaninRepository.save(gradjanin);
    }

    public Gradjanin edit(Gradjanin gradjanin) throws Exception {
        return gradjaninRepository.edit(gradjanin);
    }

    public Boolean delete(String id) throws Exception {
        gradjaninRepository.delete(id);
        return !existsById(id);
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xPath = "/g:Gradjanin[g:korisnik[@id='" + id + "']]";
        ResourceSet result = commonRepository.queryGradjanin(xPath);
        Gradjanin gradjanin = (Gradjanin) commonRepository.resourceSetToClass(result, Gradjanin.class);
        String xmlInstance = "../data/xsd/instance/" + "gradjanin" + id + ".xml";
        String xml = "../data/xml/" + "gradjanin" + id + ".xml";
        documentService.createXML(Gradjanin.class, gradjanin, xmlInstance);
        System.out.println("Docs generated!");
    }
}
