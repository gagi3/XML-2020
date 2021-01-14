package rs.pijz.server.poverenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.poverenik.dto.ResponseMessage;
import rs.pijz.server.poverenik.fuseki.MetadataExtractor;
import rs.pijz.server.poverenik.model.resenje_zalba_neosnovana.ResenjeZalbaNeosnovana;
import rs.pijz.server.poverenik.service.DomParserService;
import rs.pijz.server.poverenik.service.ResenjeZalbaNeosnovanaService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resenje-zalba-neosnovana")
public class ResenjeZalbaNeosnovanaController {

    @Autowired
    private ResenjeZalbaNeosnovanaService resenjeZalbaNeosnovanaService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;

    @GetMapping(value = "")
    private ResponseEntity<List<ResenjeZalbaNeosnovana>> findAll() {
        try {
            List<ResenjeZalbaNeosnovana> resenja = resenjeZalbaNeosnovanaService.findAll();
            return ResponseEntity.ok().body(resenja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = "application/xml")
    private ResponseEntity<ResenjeZalbaNeosnovana> getOne(@RequestParam String id) {
        try {
            ResenjeZalbaNeosnovana resenje = resenjeZalbaNeosnovanaService.getOne(id);
            return ResponseEntity.ok().body(resenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = "application/xml")
    private ResponseEntity<ResenjeZalbaNeosnovana> create(@RequestBody ResenjeZalbaNeosnovana resenje) {
        try {
            ResenjeZalbaNeosnovana resenjeZalbaNeosnovana = resenjeZalbaNeosnovanaService.create(resenje);
            return ResponseEntity.ok().body(resenjeZalbaNeosnovana);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            resenjeZalbaNeosnovanaService.generateDocuments(id);
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
