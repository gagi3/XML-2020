package rs.pijz.server.poverenik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rs.pijz.server.poverenik.soap.client.IzjasnjenjeNaZalbuClient;
import rs.pijz.server.poverenik.soap.client.ObavestenjeClient;
import rs.pijz.server.poverenik.soap.client.ResenjeClient;
import rs.pijz.server.poverenik.soap.client.ZahtevClient;
import rs.pijz.server.poverenik.soap.client.ZalbaCutanjeClient;
import rs.pijz.server.poverenik.soap.client.ZalbaOdlukaClient;
import rs.pijz.server.poverenik.soap.communication.izjasnjenje_na_zalbu.GetIzjasnjenjeNaZalbuResponse;
import rs.pijz.server.poverenik.soap.communication.obavestenje.GetObavestenjeResponse;
import rs.pijz.server.poverenik.soap.communication.resenje.GetResenjeResponse;
import rs.pijz.server.poverenik.soap.communication.zahtev.GetZahtevResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.GetZalbaOdlukaResponse;

@SpringBootApplication
public class PoverenikApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoverenikApplication.class, args);
    }
    
    @Bean
    CommandLineRunner lookupIzjasnjenjeNaZalbu(IzjasnjenjeNaZalbuClient izjasnjenjeNaZalbuClient) {
      return args -> {
        String broj = "IZ-001";

        if (args.length > 0) {
          broj = args[0];
        }
        
        GetIzjasnjenjeNaZalbuResponse response = izjasnjenjeNaZalbuClient.getIzjasnjenjeNaZalbu(broj);
        System.err.println(response.getIzjasnjenjeNaZalbu().getBroj());
      };
    }
    
    @Bean
    CommandLineRunner lookupObavestenje(ObavestenjeClient obavestenjeClient) {
      return args -> {
        String broj = "OB-001";

        if (args.length > 0) {
          broj = args[0];
        }
        
        GetObavestenjeResponse response = obavestenjeClient.getObavestenje(broj);
        System.err.println(response.getObavestenje().getBroj());
      };
    }
    
    @Bean
    CommandLineRunner lookupResenje(ResenjeClient resenjeClient) {
      return args -> {
        String broj = "R-001";

        if (args.length > 0) {
          broj = args[0];
        }
        
        GetResenjeResponse response = resenjeClient.getResenje(broj);
        System.err.println(response.getResenje().getBroj());
      };
    }
    
    @Bean
    CommandLineRunner lookupZahtev(ZahtevClient zahtevClient) {
      return args -> {
        String id = "ID-Z-001";

        if (args.length > 0) {
          id = args[0];
        }
        
        GetZahtevResponse response = zahtevClient.getZahtev(id);
        System.err.println(response.getZahtev().getId());
      };
    }
    
    @Bean
    CommandLineRunner lookupZalbaCutanje(ZalbaCutanjeClient zalbaCutanjeClient) {
      return args -> {
        String broj = "ZC-001";

        if (args.length > 0) {
          broj = args[0];
        }
        
        GetZalbaCutanjeResponse response = zalbaCutanjeClient.getZalbaCutanje(broj);
        System.err.println(response.getZalbaCutanje().getBroj());
      };
    }
    
    @Bean
    CommandLineRunner lookupZalbaOdila(ZalbaOdlukaClient zalbaOdlukaClient) {
      return args -> {
        String broj = "ZO-001";

        if (args.length > 0) {
          broj = args[0];
        }
        
        GetZalbaOdlukaResponse response = zalbaOdlukaClient.getZalbaOdluka(broj);
        System.err.println(response.getZalbaOdluka().getBroj());
      };
    }

}
