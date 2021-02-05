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
import rs.pijz.server.poverenik.model.poverenik.Poverenik;
import rs.pijz.server.poverenik.service.PoverenikService;

@CrossOrigin
@RestController
@RequestMapping("/poverenik")
public class PoverenikController {

	@Autowired
	private PoverenikService poverenikService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<?> findAll() {
		try {
			List<Poverenik> obavestenja = new ArrayList<>();
			obavestenja = poverenikService.findAll();
			return ResponseEntity.ok(obavestenja);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Poverenik> getOne(@RequestParam String id) {
		try {
			Poverenik poverenik = poverenikService.getOne(id);
			return ResponseEntity.ok().body(poverenik);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Poverenik> create(@RequestBody Poverenik poverenik) {
		try {
			Poverenik poverenik1 = poverenikService.create(poverenik);
			return ResponseEntity.ok().body(poverenik1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Poverenik> edit(@RequestBody Poverenik poverenik) {
		try {
			Poverenik poverenik1 = poverenikService.edit(poverenik);
			return ResponseEntity.ok().body(poverenik1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Boolean> delete(@RequestParam String id) {
		try {
			Boolean deleted = poverenikService.delete(id);
			return ResponseEntity.ok().body(deleted);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/generate")
	private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
		try {
			poverenikService.generateDocuments(id);
			return ResponseEntity.ok().body(new ResponseMessage("Uspesno kreiranje."));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage("Neuspesno kreiranje."));
		}
	}
}
