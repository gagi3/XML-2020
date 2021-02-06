package rs.pijz.server.poverenik.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.pijz.server.poverenik.dto.ResponseMessage;
import rs.pijz.server.poverenik.model.gradjanin.Gradjanin;
import rs.pijz.server.poverenik.service.GradjaninService;

@CrossOrigin
@RestController
@RequestMapping("/gradjanin")
public class GradjaninController {

    @Autowired
    private GradjaninService gradjaninService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<?> findAll() {
        try {
            List<Gradjanin> obavestenja = new ArrayList<>();
            obavestenja = gradjaninService.findAll();
            return ResponseEntity.ok(obavestenja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Gradjanin> getOne(@RequestParam String id) {
        try {
            Gradjanin gradjanin = gradjaninService.getOne(id);
            return ResponseEntity.ok().body(gradjanin);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Gradjanin> create(@RequestBody Gradjanin gradjanin) {
        try {
            Gradjanin gradjanin1 = gradjaninService.create(gradjanin);
            return ResponseEntity.ok().body(gradjanin1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Gradjanin> edit(@RequestBody Gradjanin gradjanin) {
        try {
            Gradjanin gradjanin1 = gradjaninService.edit(gradjanin);
            return ResponseEntity.ok().body(gradjanin1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    private ResponseEntity<Boolean> delete(@RequestParam String id) {
        try {
            Boolean deleted = gradjaninService.delete(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/generate")
    private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
        try {
            gradjaninService.generateDocuments(id);
            return ResponseEntity.ok().body(new ResponseMessage("Uspesno kreiranje."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage("Neuspesno kreiranje."));
        }
    }
}
