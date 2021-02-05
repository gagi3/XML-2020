package rs.pijz.server.poverenik.controller;

import java.io.ByteArrayOutputStream;
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
import rs.pijz.server.poverenik.fuseki.MetadataExtractor;
import rs.pijz.server.poverenik.model.obavestenje.Obavestenje;
import rs.pijz.server.poverenik.service.DomParserService;
import rs.pijz.server.poverenik.service.ObavestenjeService;

@CrossOrigin
@RestController
@RequestMapping("/obavestenje")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService obavestenjeService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;
    
    private final String dataset = "conn.obavestenje-dataset";

//    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    private ResponseEntity<?> findAll() {
//        try {
//            List<Obavestenje> obavestenja = new ArrayList<>();
//            obavestenja = obavestenjeService.findAll();
//            return ResponseEntity.ok(obavestenja);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<Obavestenje>> findAllByParams(@RequestParam (required = false) String gradjaninID,
                                                             @RequestParam (required = false) String sluzbenikID) {
        try {
            List<Obavestenje> list;
            if (gradjaninID != null && !gradjaninID.equals("")) {
                list = obavestenjeService.findAllByGradjanin(gradjaninID);
            } else if (sluzbenikID != null && !sluzbenikID.equals("")) {
                list = obavestenjeService.findAllBySluzbenik(sluzbenikID);
            } else {
                list = obavestenjeService.findAll();
            }
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Obavestenje> getOne(@RequestParam String id) {
        try {
            Obavestenje obavestenje = obavestenjeService.getOne(id);
            return ResponseEntity.ok().body(obavestenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Obavestenje> create(@RequestBody Obavestenje obavestenje) {
        try {
            Obavestenje obavestenje1 = obavestenjeService.create(obavestenje);
            return ResponseEntity.ok().body(obavestenje1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Obavestenje> edit(@RequestBody Obavestenje obavestenje) {
        try {
            Obavestenje obavestenje1 = obavestenjeService.edit(obavestenje);
            return ResponseEntity.ok().body(obavestenje1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = obavestenjeService.delete(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            obavestenjeService.generateDocuments(id);
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

    @PostMapping(value = "/convert-to-html")
    public ResponseEntity<String> convertToHTML(@RequestParam("file") MultipartFile file) throws Exception {
        String result = obavestenjeService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
        ByteArrayOutputStream result = obavestenjeService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }
}
