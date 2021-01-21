package rs.pijz.server.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.sluzbenik.dto.ResponseMessage;
import rs.pijz.server.sluzbenik.fuseki.MetadataExtractor;
import rs.pijz.server.sluzbenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.sluzbenik.service.DomParserService;
import rs.pijz.server.sluzbenik.service.ZalbaCutanjeService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/zalba-cutanje")
public class ZalbaCutanjeController {
    @Autowired
    private ZalbaCutanjeService zalbaCutanjeService;
    @Autowired
    private DomParserService domParserService;
    @Autowired
    private MetadataExtractor metadataExtractor;

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<ZalbaCutanje>> findAll() {
        try {
            List<ZalbaCutanje> zalbe = zalbaCutanjeService.findAll();
            return ResponseEntity.ok().body(zalbe);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<ZalbaCutanje> getOne(@RequestParam String id) {
        try {
            ZalbaCutanje zalba = zalbaCutanjeService.getOne(id);
            return ResponseEntity.ok().body(zalba);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<ZalbaCutanje> create(@RequestBody ZalbaCutanje zalba) {
        try {
            ZalbaCutanje zalbaCutanje = zalbaCutanjeService.create(zalba);
            return ResponseEntity.ok().body(zalbaCutanje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            zalbaCutanjeService.generateDocuments(id);
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
}
