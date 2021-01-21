package rs.pijz.server.poverenik.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.pijz.server.poverenik.auth.JWTResponse;
import rs.pijz.server.poverenik.entity.auth.LoginRequest;
import rs.pijz.server.poverenik.entity.auth.RegistrationRequest;
import rs.pijz.server.poverenik.entity.auth.User;
import rs.pijz.server.poverenik.service.auth.intf.UserService;
import rs.pijz.server.poverenik.service.auth.intf.VerificationTokenService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    VerificationTokenService verificationTokenService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) throws Exception {
        User user = userService.create(request);
        if (user == null) {
            return new ResponseEntity<>("Neuspešna registracija!", HttpStatus.BAD_REQUEST);
        }
        verificationTokenService.create(user);
        return new ResponseEntity<>("Registracija uspešna! Proverite vaš email za potvrdu registracije.", HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginRequest request) throws Exception {
        JWTResponse response = userService.login(request);
        if (response == null) {
            return new ResponseEntity<>("Neuspešno prijavljivanje!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/confirm", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> confirm(@RequestParam String token) throws Exception {
        Boolean confirm = userService.confirm(token);
        if (!confirm) {
            return new ResponseEntity<>("Došlo je do greške.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registracija je potvrđena.", HttpStatus.OK);
    }

    @GetMapping(value = "/request-token", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> requestToken(@RequestParam String email) throws Exception {
        verificationTokenService.requestToken(email);
        return new ResponseEntity<>("Zahtev je poslat. Molimo vas da proverite email kako biste potvrdili registraciju.", HttpStatus.OK);
    }

}
