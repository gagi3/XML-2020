package rs.ijz.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ijz.server.dto.ResponseMessage;
import rs.ijz.server.model.resenje_zahtev_odbijen.ResenjeZahtevOdbijen;
import rs.ijz.server.service.ResenjeZahtevOdbijenService;

@CrossOrigin
@RestController
@RequestMapping("/resenje-zahtev-odbijen")
public class ResenjeZahtevOdbijenController {
	
    @Autowired
    private ResenjeZahtevOdbijenService resenjeZahtevOdbijenService;

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
}
