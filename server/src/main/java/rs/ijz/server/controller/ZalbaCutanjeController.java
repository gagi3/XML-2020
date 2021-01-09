package rs.ijz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ijz.server.dto.ResponseMessage;
import rs.ijz.server.model.ZalbaCutanje;
import rs.ijz.server.service.ZalbaCutanjeService;

@CrossOrigin
@RestController
@RequestMapping("/zalba-cutanje")
public class ZalbaCutanjeController {
    @Autowired
    private ZalbaCutanjeService zalbaCutanjeService;
    @GetMapping(value = "/search")
    private ResponseEntity<ZalbaCutanje> getOne(@RequestParam String id) {
        try {
            ZalbaCutanje zalba = zalbaCutanjeService.getOne(id);
            return ResponseEntity.ok().body(zalba);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping(value = "/create")
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
}
