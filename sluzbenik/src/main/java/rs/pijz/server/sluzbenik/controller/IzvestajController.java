package rs.pijz.server.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.sluzbenik.dto.ResponseMessage;
import rs.pijz.server.sluzbenik.fuseki.MetadataExtractor;
import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;
import rs.pijz.server.sluzbenik.service.DomParserService;
import rs.pijz.server.sluzbenik.service.IzvestajService;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/izvestaj")
public class IzvestajController {

    @Autowired
    private IzvestajService izvestajService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;

//    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    private ResponseEntity<?> findAll() {
//        try {
//            List<Izvestaj> obavestenja = new ArrayList<>();
//            obavestenja = izvestajService.findAll();
//            return ResponseEntity.ok(obavestenja);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<Izvestaj>> findAllByParams(@RequestParam (required = false) String sluzbenikID) {
        try {
            List<Izvestaj> list;
            if (sluzbenikID != null && !sluzbenikID.equals("")) {
                list = izvestajService.findAllBySluzbenik(sluzbenikID);
            } else {
                list = izvestajService.findAll();
            }
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Izvestaj> getOne(@RequestParam String id) {
        try {
            Izvestaj izvestaj = izvestajService.getOne(id);
            return ResponseEntity.ok().body(izvestaj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Izvestaj> create(@RequestBody Izvestaj izvestaj) {
        try {
            Izvestaj izvestaj1 = izvestajService.create(izvestaj);
            return ResponseEntity.ok().body(izvestaj1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Izvestaj> edit(@RequestBody Izvestaj izvestaj) {
        try {
            Izvestaj izvestaj1 = izvestajService.edit(izvestaj);
            return ResponseEntity.ok().body(izvestaj1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = izvestajService.delete(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            izvestajService.generateDocuments(id);
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
        String result = izvestajService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
        ByteArrayOutputStream result = izvestajService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }
}
