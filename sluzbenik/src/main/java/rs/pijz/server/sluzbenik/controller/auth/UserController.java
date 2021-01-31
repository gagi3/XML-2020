package rs.pijz.server.sluzbenik.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import rs.pijz.server.sluzbenik.auth.JWTProvider;
import rs.pijz.server.sluzbenik.auth.JWTResponse;
import rs.pijz.server.sluzbenik.entity.auth.LoginRequest;
import rs.pijz.server.sluzbenik.entity.auth.UserDetailsImpl;
import rs.pijz.server.sluzbenik.model.korisnik.Korisnik;
import rs.pijz.server.sluzbenik.service.KorisnikService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    KorisnikService korisnikService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTProvider provider;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> register(@RequestBody Korisnik request) throws Exception {
        Korisnik korisnik = korisnikService.create(request);
        if (korisnik == null) {
            return new ResponseEntity<>("Neuspešna registracija!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registracija uspešna! Proverite vaš email za potvrdu registracije.", HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginRequest request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.generateToken(authentication);
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        JWTResponse response = new JWTResponse(token, user.getUsername(), user.getAuthorities());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
