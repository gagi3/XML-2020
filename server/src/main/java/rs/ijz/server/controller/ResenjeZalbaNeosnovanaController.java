package rs.ijz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ijz.server.dto.ResponseMessage;
import rs.ijz.server.model.ResenjeZalbaNeosnovana;
import rs.ijz.server.service.ResenjeZalbaNeosnovanaService;

@CrossOrigin
@RestController
@RequestMapping("/resenje-zalba-neosnovana")
public class ResenjeZalbaNeosnovanaController {
    @Autowired
    private ResenjeZalbaNeosnovanaService resenjeZalbaNeosnovanaService;
    @GetMapping(value = "/search")
    private ResponseEntity<ResenjeZalbaNeosnovana> getOne(@RequestParam String id) {
        try {
            ResenjeZalbaNeosnovana resenje = resenjeZalbaNeosnovanaService.getOne(id);
            return ResponseEntity.ok().body(resenje);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping(value = "/create")
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
}
