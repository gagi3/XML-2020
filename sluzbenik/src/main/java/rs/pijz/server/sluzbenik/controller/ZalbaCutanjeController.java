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

import java.io.ByteArrayOutputStream;
import java.util.Date;
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

//    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    private ResponseEntity<List<ZalbaCutanje>> findAll() {
//        try {
//            List<ZalbaCutanje> zalbe = zalbaCutanjeService.findAll();
//            return ResponseEntity.ok().body(zalbe);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<ZalbaCutanje>> findAllByParams(@RequestParam (required = false) String broj,
                                                          @RequestParam (required = false) String gradjaninID,
                                                          @RequestParam (required = false) Date datum,
                                                          @RequestParam (required = false) Date datumZahteva,
                                                          @RequestParam (required = false) String poverenikID,
                                                          @RequestParam (required = false) String sluzbenikID) {
        try {
            List<ZalbaCutanje> list;
            if (broj != null && !broj.equals("")) {
                list = zalbaCutanjeService.findAllByBroj(broj);
            } else if (gradjaninID != null && !gradjaninID.equals("")) {
                list = zalbaCutanjeService.findAllByGradjanin(gradjaninID);
            } else if (datum != null) {
                list = zalbaCutanjeService.findAllByDatum(datum);
            } else if (datumZahteva != null) {
                list = zalbaCutanjeService.findAllByDatumZahteva(datumZahteva);
            } else if (poverenikID != null && !poverenikID.equals("")) {
                list = zalbaCutanjeService.findAllByPoverenik(poverenikID);
            } else if (sluzbenikID != null && !sluzbenikID.equals("")) {
                list = zalbaCutanjeService.findAllBySluzbenik(sluzbenikID);
            } else {
                list = zalbaCutanjeService.findAll();
            }
            return ResponseEntity.ok().body(list);
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

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<ZalbaCutanje> edit(@RequestBody ZalbaCutanje zalbaCutanje) {
        try {
            ZalbaCutanje zalbaCutanje1 = zalbaCutanjeService.edit(zalbaCutanje);
            return ResponseEntity.ok().body(zalbaCutanje1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = zalbaCutanjeService.delete(id);
            return ResponseEntity.ok().body(deleted);
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
    
    @PostMapping(value = "/convert-to-html")
    public ResponseEntity<String> convertToHTML(@RequestParam("file") MultipartFile file) throws Exception {
        String result = zalbaCutanjeService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
        ByteArrayOutputStream result = zalbaCutanjeService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }
}
