package rs.pijz.server.sluzbenik.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;
import rs.pijz.server.sluzbenik.model.common.Adresa;
import rs.pijz.server.sluzbenik.model.common.FizickoLice;
import rs.pijz.server.sluzbenik.model.korisnik.Korisnik;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class AppLoader implements ApplicationRunner {

    private final KorisnikService korisnikService;

    public AppLoader(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if ((korisnikService.findAll() != null && korisnikService.findAll().size() == 0) || !hasAdmin()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            FizickoLice fizickoLice = new FizickoLice();
            fizickoLice.setIme("Prvi");
            fizickoLice.setPrezime("Admin");
            Adresa adresa = new Adresa();
            adresa.setBroj("8");
            adresa.setGrad("Novi Sad");
            adresa.setUlica("Everywhere");
            fizickoLice.setAdresa(adresa);
            Korisnik korisnik = new Korisnik();
            korisnik.setId(UUID.randomUUID().toString());
            korisnik.setUsername("pijz.portal.rs@gmail.com");
            korisnik.setPassword(encoder.encode("ybtmjKNDaw5T98d"));
            korisnik.setFizickoLice(fizickoLice);
            korisnik.setTip("POVERENIK");

            korisnikService.create(korisnik);
            System.out.println("User added.");
        }
    }

    private Boolean hasAdmin() throws XMLDBException {
        AtomicReference<Boolean> hasAdmin = new AtomicReference<>(false);
        
        if (korisnikService.findAll() == null) {
        	return false;
        }
        
        korisnikService.findAll().forEach(user -> {
            if (user.getTip().equals("POVERENIK")) {
                hasAdmin.set(true);
            }
        });
        return hasAdmin.get();
    }
}