package rs.ijz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ijz.server.dto.ResponseMessage;
import rs.ijz.server.model.ZalbaOdluka;
import rs.ijz.server.service.ZalbaOdlukaService;

@CrossOrigin
@RestController
@RequestMapping("/zalba-odluka")
public class ZalbaOdlukaController {
    @Autowired
    private ZalbaOdlukaService zalbaOdlukaService;
    @GetMapping(value = "/search")
    private ResponseEntity<ZalbaOdluka> getOne(@RequestParam String id) {
        try {
            ZalbaOdluka zalba = zalbaOdlukaService.getOne(id);
            return ResponseEntity.ok().body(zalba);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping(value = "/create")
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
}
