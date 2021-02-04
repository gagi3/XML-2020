package rs.pijz.server.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.sluzbenik.dto.ResponseMessage;
import rs.pijz.server.sluzbenik.fuseki.MetadataExtractor;
import rs.pijz.server.sluzbenik.model.zahtev.Zahtev;
import rs.pijz.server.sluzbenik.service.DomParserService;
import rs.pijz.server.sluzbenik.service.ZahtevService;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/zahtev")
public class ZahtevController {

    @Autowired
    private ZahtevService zahtevService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;

//    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    private ResponseEntity<?> findAll() {
//        try {
//            List<Zahtev> zahtevi = new ArrayList<>();
//            zahtevi = zahtevService.findAll();
//            return ResponseEntity.ok(zahtevi);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<Zahtev>> findAllByParams(@RequestParam (required = false) String gradjaninID,
                                                         @RequestParam (required = false) Date datum,
                                                         @RequestParam (required = false) String sluzbenikID) {
        try {
            List<Zahtev> list;
            if (gradjaninID != null && !gradjaninID.equals("")) {
                list = zahtevService.findAllByGradjanin(gradjaninID);
            } else if (datum != null) {
                list = zahtevService.findAllByDatum(datum);
            } else if (sluzbenikID != null && !sluzbenikID.equals("")) {
                list = zahtevService.findAllBySluzbenik(sluzbenikID);
            } else {
                list = zahtevService.findAll();
            }
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Zahtev> getOne(@RequestParam String id) {
        try {
            Zahtev zahtev = zahtevService.getOne(id);
            return ResponseEntity.ok().body(zahtev);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Zahtev> create(@RequestBody Zahtev zahtev) {
        try {
            Zahtev Zahtev = zahtevService.create(zahtev);
            return ResponseEntity.ok().body(Zahtev);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Zahtev> edit(@RequestBody Zahtev zahtev) {
        try {
            Zahtev zahtev1 = zahtevService.edit(zahtev);
            return ResponseEntity.ok().body(zahtev1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = zahtevService.delete(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            zahtevService.generateDocuments(id);
            return ResponseEntity.ok().body(new ResponseMessage("Uspesno kreiranje."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage("Neuspesno kreiranje."));
        }
    }

    @PostMapping(value = "/extract-metadata")
    public ResponseEntity<String> extractMetadata(@RequestParam("file") MultipartFile file) throws Exception {
        metadataExtractor.extract(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>("Metadata extraction finished.", HttpStatus.OK);
    }
    
    @PostMapping(value = "/convert-to-html")
    public ResponseEntity<String> convertToHTML(@RequestParam("file") MultipartFile file) throws Exception {
        String result = zahtevService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
        ByteArrayOutputStream result = zahtevService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }
}
