package rs.ijz.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rs.ijz.server.dto.ResponseMessage;
import rs.ijz.server.fuseki.MetadataExtractor;
import rs.ijz.server.model.resenje_zalba_osnovana.ResenjeZalbaOsnovana;
import rs.ijz.server.service.DomParserService;
import rs.ijz.server.service.ResenjeZalbaOsnovanaService;

@CrossOrigin
@RestController
@RequestMapping("/resenje-zalba-osnovana")
public class ResenjeZalbaOsnovanaController {
	
    @Autowired
    private ResenjeZalbaOsnovanaService resenjeZalbaOsnovanaService;
    
    @Autowired
    private DomParserService domParserService;
    
    @Autowired
    private MetadataExtractor metadataExtractor;
    
    @GetMapping(value = "")
    private ResponseEntity<?> findAll() {
        try {
            List<ResenjeZalbaOsnovana> resenja = new ArrayList<>();
            resenja = resenjeZalbaOsnovanaService.findAll();
            return ResponseEntity.ok(resenja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping(value = "/search", produces = "application/xml")
    private ResponseEntity<ResenjeZalbaOsnovana> getOne(@RequestParam String id) {
        try {
            ResenjeZalbaOsnovana resenje = resenjeZalbaOsnovanaService.getOne(id);
            return ResponseEntity.ok().body(resenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping(value = "/create", produces = "application/xml")
    private ResponseEntity<ResenjeZalbaOsnovana> create(@RequestBody ResenjeZalbaOsnovana resenje) {
        try {
            ResenjeZalbaOsnovana resenjeZalbaOsnovana = resenjeZalbaOsnovanaService.create(resenje);
            return ResponseEntity.ok().body(resenjeZalbaOsnovana);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            resenjeZalbaOsnovanaService.generateDocuments(id);
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
