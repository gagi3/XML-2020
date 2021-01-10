package rs.ijz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ijz.server.service.ResenjeService;

@RestController
@RequestMapping("/api/resenja")
public class ResenjeController {
	
	@Autowired
    private ResenjeService resenjeService;
	
	@GetMapping(path = "/public/metadata/rdf/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getMetadataRDF(@PathVariable String id) throws Exception {
		String metadataRDF = resenjeService.getMetadataRDF(id);
        return new ResponseEntity<>(metadataRDF, HttpStatus.OK);
    }

    @GetMapping(path = "/public/metadata/json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMetadataJSON(@PathVariable String id) throws Exception {
    	String metadataJSON = resenjeService.getMetadataJSON(id);
        return new ResponseEntity<>(metadataJSON, HttpStatus.OK);
    }

}
