package rs.pijz.server.poverenik.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rs.pijz.server.poverenik.dto.ResponseMessage;
import rs.pijz.server.poverenik.dto.sparql.IzjasnjenjeNaZalbuSPARQL;
import rs.pijz.server.poverenik.fuseki.MetadataExtractor;
import rs.pijz.server.poverenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.pijz.server.poverenik.service.DomParserService;
import rs.pijz.server.poverenik.service.IzjasnjenjeNaZalbuService;

@CrossOrigin
@RestController
@RequestMapping("/izjasnjenje-na-zalbu")
public class IzjasnjenjeNaZalbuController {

    @Autowired
    private IzjasnjenjeNaZalbuService izjasnjenjeNaZalbuService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;
    
    private final String dataset = "conn.izjasnjenje-na-zalbu-dataset";

//    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    private ResponseEntity<List<IzjasnjenjeNaZalbu>> findAll() {
//        try {
//            List<IzjasnjenjeNaZalbu> izjasnjenja = izjasnjenjeNaZalbuService.findAll();
//            return ResponseEntity.ok().body(izjasnjenja);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<IzjasnjenjeNaZalbu> getOne(@RequestParam String id) {
        try {
            IzjasnjenjeNaZalbu izjasnjenje = izjasnjenjeNaZalbuService.getOne(id);
            return ResponseEntity.ok().body(izjasnjenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<IzjasnjenjeNaZalbu>> findAllByParams(@RequestParam (required = false) String broj,
                                                                   @RequestParam (required = false) String brojZalbe,
                                                                   @RequestParam (required = false) String gradjaninID,
                                                                   @RequestParam (required = false) Date datum,
                                                                   @RequestParam (required = false) String poverenikID,
                                                                   @RequestParam (required = false) String sluzbenikID) {
        try {
            List<IzjasnjenjeNaZalbu> izjasnjenja;
            if (broj != null && !broj.equals("")) {
                izjasnjenja = izjasnjenjeNaZalbuService.findAllByBroj(broj);
            } else if (brojZalbe != null && !brojZalbe.equals("")) {
                izjasnjenja = izjasnjenjeNaZalbuService.findAllByBrojZalbe(brojZalbe);
            } else if (gradjaninID != null && !gradjaninID.equals("")) {
                izjasnjenja = izjasnjenjeNaZalbuService.findAllByGradjanin(gradjaninID);
            } else if (datum != null) {
                izjasnjenja = izjasnjenjeNaZalbuService.findAllByDatum(datum);
            } else if (poverenikID != null && !poverenikID.equals("")) {
                izjasnjenja = izjasnjenjeNaZalbuService.findAllByPoverenik(poverenikID);
            } else if (sluzbenikID != null && !sluzbenikID.equals("")) {
                izjasnjenja = izjasnjenjeNaZalbuService.findAllBySluzbenik(sluzbenikID);
            } else {
                izjasnjenja = izjasnjenjeNaZalbuService.findAll();
            }
            return ResponseEntity.ok().body(izjasnjenja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<IzjasnjenjeNaZalbu> create(@RequestBody IzjasnjenjeNaZalbu izjasnjenje) {
        try {
            IzjasnjenjeNaZalbu izjasnjenjeNaZalbu = izjasnjenjeNaZalbuService.create(izjasnjenje);
            return ResponseEntity.ok().body(izjasnjenjeNaZalbu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<IzjasnjenjeNaZalbu> edit(@RequestBody IzjasnjenjeNaZalbu izjasnjenjeNaZalbu) {
        try {
            IzjasnjenjeNaZalbu izjasnjenjeNaZalbu1 = izjasnjenjeNaZalbuService.edit(izjasnjenjeNaZalbu);
            return ResponseEntity.ok().body(izjasnjenjeNaZalbu1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = izjasnjenjeNaZalbuService.delete(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            izjasnjenjeNaZalbuService.generateDocuments(id);
            return ResponseEntity.ok().body(new ResponseMessage("Uspesno kreiranje."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage("Neuspesno kreiranje."));
        }
    }

    @PostMapping(value = "/extract-metadata")
    public ResponseEntity<String> extractMetadata(@RequestParam("file") MultipartFile file) throws Exception {
        metadataExtractor.extract(domParserService.readMultipartXMLFile(file), dataset);
        return new ResponseEntity<>("Metadata extraction finished.", HttpStatus.OK);
    }
    
    @PostMapping("/search-metadata")
    public ResponseEntity<Collection<String>> searchMetadata(@RequestBody IzjasnjenjeNaZalbuSPARQL izjasnjenjeNaZalbuSPARQL) throws IOException {
        ArrayList<String> result = izjasnjenjeNaZalbuService.searchMetadata(izjasnjenjeNaZalbuSPARQL, dataset);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-html")
    public ResponseEntity<String> convertToHTML(@RequestParam("file") MultipartFile file) throws Exception {
        String result = izjasnjenjeNaZalbuService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
        ByteArrayOutputStream result = izjasnjenjeNaZalbuService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }


}
