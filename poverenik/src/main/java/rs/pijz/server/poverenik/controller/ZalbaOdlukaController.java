package rs.pijz.server.poverenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.poverenik.dto.ResponseMessage;
import rs.pijz.server.poverenik.fuseki.MetadataExtractor;
import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.service.DomParserService;
import rs.pijz.server.poverenik.service.ZalbaOdlukaService;

import java.io.ByteArrayOutputStream;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/zalba-odluka")
public class ZalbaOdlukaController {
    @Autowired
    private ZalbaOdlukaService zalbaOdlukaService;
    @Autowired
    private DomParserService domParserService;
    @Autowired
    private MetadataExtractor metadataExtractor;

    @GetMapping(value = "")
    private ResponseEntity<List<ZalbaOdluka>> findAll() {
        try {
            List<ZalbaOdluka> zalbe = zalbaOdlukaService.findAll();
            return ResponseEntity.ok().body(zalbe);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = "application/xml")
    private ResponseEntity<ZalbaOdluka> getOne(@RequestParam String id) {
        try {
            ZalbaOdluka zalba = zalbaOdlukaService.getOne(id);
            return ResponseEntity.ok().body(zalba);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = "application/xml")
    private ResponseEntity<ZalbaOdluka> create(@RequestBody ZalbaOdluka zalba) {
        try {
            ZalbaOdluka zalbaOdluka = zalbaOdlukaService.create(zalba);
            return ResponseEntity.ok().body(zalbaOdluka);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            zalbaOdlukaService.generateDocuments(id);
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
    	String result = zalbaOdlukaService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
    	ByteArrayOutputStream result = zalbaOdlukaService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }
}
