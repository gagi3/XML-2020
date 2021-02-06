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
import rs.pijz.server.poverenik.model.sluzbenik.Sluzbenik;
import rs.pijz.server.poverenik.service.SluzbenikService;

@CrossOrigin
@RestController
@RequestMapping("/sluzbenik")
public class SluzbenikController {

	@Autowired
	private SluzbenikService sluzbenikService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<?> findAll() {
		try {
			List<Sluzbenik> obavestenja = new ArrayList<>();
			obavestenja = sluzbenikService.findAll();
			return ResponseEntity.ok(obavestenja);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Sluzbenik> getOne(@RequestParam String id) {
		try {
			Sluzbenik sluzbenik = sluzbenikService.getOne(id);
			return ResponseEntity.ok().body(sluzbenik);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Sluzbenik> create(@RequestBody Sluzbenik sluzbenik) {
		try {
			Sluzbenik sluzbenik1 = sluzbenikService.create(sluzbenik);
			return ResponseEntity.ok().body(sluzbenik1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value = "/edit", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Sluzbenik> edit(@RequestBody Sluzbenik sluzbenik) {
		try {
			Sluzbenik sluzbenik1 = sluzbenikService.edit(sluzbenik);
			return ResponseEntity.ok().body(sluzbenik1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<Boolean> delete(@RequestParam String id) {
		try {
			Boolean deleted = sluzbenikService.delete(id);
			return ResponseEntity.ok().body(deleted);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/generate")
	private ResponseEntity<ResponseMessage> generateDocuments(@RequestParam String id) {
		try {
			sluzbenikService.generateDocuments(id);
			return ResponseEntity.ok().body(new ResponseMessage("Uspesno kreiranje."));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage("Neuspesno kreiranje."));
		}
	}
}
