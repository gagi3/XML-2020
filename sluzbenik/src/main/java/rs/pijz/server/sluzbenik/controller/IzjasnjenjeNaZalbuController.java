package rs.pijz.server.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.sluzbenik.dto.ResponseMessage;
import rs.pijz.server.sluzbenik.fuseki.MetadataExtractor;
import rs.pijz.server.sluzbenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;
import rs.pijz.server.sluzbenik.service.DomParserService;
import rs.pijz.server.sluzbenik.service.IzjasnjenjeNaZalbuService;

import java.util.List;

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

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<IzjasnjenjeNaZalbu>> findAll() {
        try {
            List<IzjasnjenjeNaZalbu> izjasnjenja = izjasnjenjeNaZalbuService.findAll();
            return ResponseEntity.ok().body(izjasnjenja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

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
        metadataExtractor.extract(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>("Metadata extraction finished.", HttpStatus.OK);
    }
}
