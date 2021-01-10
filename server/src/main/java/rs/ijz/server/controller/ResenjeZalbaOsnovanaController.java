package rs.ijz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ijz.server.dto.ResponseMessage;
import rs.ijz.server.model.ResenjeZalbaOsnovana;
import rs.ijz.server.service.ResenjeZalbaOsnovanaService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resenje-zalba-osnovana")
public class ResenjeZalbaOsnovanaController {
    @Autowired
    private ResenjeZalbaOsnovanaService resenjeZalbaOsnovanaService;
    @GetMapping(value = "", produces = "application/xml")
    private ResponseEntity<List<ResenjeZalbaOsnovana>> findAll() {
        try {
            List<ResenjeZalbaOsnovana> resenja = resenjeZalbaOsnovanaService.findAll();
            return ResponseEntity.ok().body(resenja);
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
}
