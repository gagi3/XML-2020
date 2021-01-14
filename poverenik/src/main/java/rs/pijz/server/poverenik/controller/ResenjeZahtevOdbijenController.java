package rs.pijz.server.poverenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.poverenik.dto.ResponseMessage;
import rs.pijz.server.poverenik.fuseki.MetadataExtractor;
import rs.pijz.server.poverenik.model.resenje_zahtev_odbijen.ResenjeZahtevOdbijen;
import rs.pijz.server.poverenik.service.DomParserService;
import rs.pijz.server.poverenik.service.ResenjeZahtevOdbijenService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resenje-zahtev-odbijen")
public class ResenjeZahtevOdbijenController {

    @Autowired
    private ResenjeZahtevOdbijenService resenjeZahtevOdbijenService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;

    @GetMapping(value = "")
    private ResponseEntity<List<ResenjeZahtevOdbijen>> findAll() {
        try {
            List<ResenjeZahtevOdbijen> resenja = resenjeZahtevOdbijenService.findAll();
            return ResponseEntity.ok().body(resenja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = "application/xml")
    private ResponseEntity<ResenjeZahtevOdbijen> getOne(@RequestParam String id) {
        try {
            ResenjeZahtevOdbijen resenje = resenjeZahtevOdbijenService.getOne(id);
            return ResponseEntity.ok().body(resenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = "application/xml")
    private ResponseEntity<ResenjeZahtevOdbijen> create(@RequestBody ResenjeZahtevOdbijen resenje) {
        try {
            ResenjeZahtevOdbijen resenjeZahtevOdbijen = resenjeZahtevOdbijenService.create(resenje);
            return ResponseEntity.ok().body(resenjeZahtevOdbijen);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            resenjeZahtevOdbijenService.generateDocuments(id);
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
