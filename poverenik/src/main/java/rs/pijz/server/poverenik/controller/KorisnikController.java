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
import rs.pijz.server.poverenik.model.korisnik.Korisnik;
import rs.pijz.server.poverenik.service.KorisnikService;

@CrossOrigin
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<?> findAll() {
		try {
			List<Korisnik> obavestenja = new ArrayList<>();
			obavestenja = korisnikService.findAll();
			return ResponseEntity.ok(obavestenja);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Korisnik> getOne(@RequestParam String id) {
		try {
			Korisnik korisnik = korisnikService.getOne(id);
			return ResponseEntity.ok().body(korisnik);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Korisnik> create(@RequestBody Korisnik korisnik) {
		try {
			Korisnik korisnik1 = korisnikService.create(korisnik);
			return ResponseEntity.ok().body(korisnik1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Korisnik> edit(@RequestBody Korisnik korisnik) {
		try {
			Korisnik korisnik1 = korisnikService.edit(korisnik);
			return ResponseEntity.ok().body(korisnik1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Boolean> delete(@RequestParam String id) {
		try {
			Boolean deleted = korisnikService.delete(id);
			return ResponseEntity.ok().body(deleted);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/generate")
	private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
		try {
			korisnikService.generateDocuments(id);
			return ResponseEntity.ok().body(new ResponseMessage("Uspesno kreiranje."));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage("Neuspesno kreiranje."));
		}
	}
}
