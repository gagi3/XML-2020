package rs.ijz.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.ijz.server.model.Adresa;
import rs.ijz.server.model.FizickoLice;
import rs.ijz.server.model.Obavestenje;
import rs.ijz.server.model.PravnoLice;
import rs.ijz.server.service.DocumentService;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.util.GregorianCalendar;

@RestController
@RequestMapping(value = "/document")
public class DocumentController {


    @Autowired
    private DocumentService documentService;

//    @PostMapping(value = "/newObavestenje")
//    public ResponseEntity<Obavestenje> create(@RequestBody Obavestenje obavestenje) throws JAXBException, DatatypeConfigurationException {
//        return new ResponseEntity<>(this.documentService.create(obavestenje), HttpStatus.OK);
//    }


    @PostMapping(value = "/createObavestenje")
    public ResponseEntity<Obavestenje> createObavestenje() throws JAXBException, DatatypeConfigurationException, IOException {

        return new ResponseEntity<>(this.documentService.dummyObavestenjeData(), HttpStatus.OK);
    }

    @GetMapping(value = "/create/XML")
    public ResponseEntity<Obavestenje> createXML() throws JAXBException, DatatypeConfigurationException, IOException {
        Obavestenje obavestenje = this.documentService.dummyObavestenjeData();
        String xmlInstance = "data/xsd/instance/" + "obavestenje1.xml";
        return new ResponseEntity<>(this.documentService.createXML(Obavestenje.class, obavestenje, xmlInstance), HttpStatus.OK);
    }




}
