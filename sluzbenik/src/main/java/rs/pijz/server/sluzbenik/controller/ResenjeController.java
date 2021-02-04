package rs.pijz.server.sluzbenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.pijz.server.sluzbenik.dto.ResponseMessage;
import rs.pijz.server.sluzbenik.fuseki.MetadataExtractor;
import rs.pijz.server.sluzbenik.model.resenje.Resenje;
import rs.pijz.server.sluzbenik.service.DomParserService;
import rs.pijz.server.sluzbenik.service.ResenjeService;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resenje")
public class ResenjeController {

    @Autowired
    private ResenjeService resenjeService;

    @Autowired
    private DomParserService domParserService;

    @Autowired
    private MetadataExtractor metadataExtractor;

//    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    private ResponseEntity<?> findAll() {
//        try {
//            List<Resenje> resenja = new ArrayList<>();
//            resenja = resenjeService.findAll();
//            return ResponseEntity.ok(resenja);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<List<Resenje>> findAllByParams(@RequestParam (required = false) String broj,
                                                         @RequestParam (required = false) String zalbaID,
                                                         @RequestParam (required = false) String gradjaninID,
                                                         @RequestParam (required = false) Date datum,
                                                          @RequestParam (required = false) Date datumZahteva,
                                                          @RequestParam (required = false) Date datumZalbe,
                                                          @RequestParam (required = false) Date datumPostupka,
                                                         @RequestParam (required = false) String poverenikID,
                                                         @RequestParam (required = false) String sluzbenikID) {
        try {
            List<Resenje> list;
            if (broj != null && !broj.equals("")) {
                list = resenjeService.findAllByBroj(broj);
            } else if (zalbaID != null && !zalbaID.equals("")) {
                list = resenjeService.findAllByZalbaId(zalbaID);
            } else if (gradjaninID != null && !gradjaninID.equals("")) {
                list = resenjeService.findAllByGradjanin(gradjaninID);
            } else if (datum != null) {
                list = resenjeService.findAllByDatum(datum);
            } else if (datumZahteva != null) {
                list = resenjeService.findAllByDatumZahteva(datumZahteva);
            } else if (datumZalbe != null) {
                list = resenjeService.findAllByDatumZalbe(datumZalbe);
            } else if (datumPostupka != null) {
                list = resenjeService.findAllByDatumPostupka(datumPostupka);
            } else if (poverenikID != null && !poverenikID.equals("")) {
                list = resenjeService.findAllByPoverenik(poverenikID);
            } else if (sluzbenikID != null && !sluzbenikID.equals("")) {
                list = resenjeService.findAllBySluzbenik(sluzbenikID);
            } else {
                list = resenjeService.findAll();
            }
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Resenje> getOne(@RequestParam String id) {
        try {
            Resenje resenje = resenjeService.getOne(id);
            return ResponseEntity.ok().body(resenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Resenje> create(@RequestBody Resenje resenje) {
        try {
            Resenje Resenje = resenjeService.create(resenje);
            return ResponseEntity.ok().body(Resenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Resenje> edit(@RequestBody Resenje resenje) {
        try {
            Resenje resenje1 = resenjeService.edit(resenje);
            return ResponseEntity.ok().body(resenje1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = resenjeService.delete(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            resenjeService.generateDocuments(id);
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
        String result = resenjeService.convertToHTML(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/convert-to-pdf")
    public ResponseEntity<byte[]> convertToPDF(@RequestParam("file") MultipartFile file) throws Exception {
        ByteArrayOutputStream result = resenjeService.convertToPDF(domParserService.readMultipartXMLFile(file));
        return new ResponseEntity<>(result.toByteArray(), HttpStatus.OK);
    }
}
