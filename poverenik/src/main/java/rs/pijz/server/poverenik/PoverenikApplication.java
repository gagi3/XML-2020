package rs.pijz.server.poverenik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rs.pijz.server.poverenik.soap.client.ObavestenjeClient;
import rs.pijz.server.poverenik.soap.client.ResenjeClient;
import rs.pijz.server.poverenik.soap.communication.obavestenje.GetObavestenjeResponse;
import rs.pijz.server.poverenik.soap.communication.resenje.GetResenjeResponse;

@SpringBootApplication
public class PoverenikApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoverenikApplication.class, args);
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

}
