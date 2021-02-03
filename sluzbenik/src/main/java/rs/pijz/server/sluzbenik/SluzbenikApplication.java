package rs.pijz.server.sluzbenik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rs.pijz.server.sluzbenik.model.obavestenje.Obavestenje;
import rs.pijz.server.sluzbenik.soap.client.ObavestenjeClient;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.ExchangeObavestenjeResponse;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.GetObavestenjeResponse;

@SpringBootApplication
public class SluzbenikApplication {

    public static void main(String[] args) {
        SpringApplication.run(SluzbenikApplication.class, args);
    }
    
    @Bean
    CommandLineRunner getObavestenje(ObavestenjeClient obavestenjeClient) {
      return args -> {
        String broj = "OB-001";
        
        GetObavestenjeResponse response = obavestenjeClient.getObavestenje(broj);
        System.err.println(response.getObavestenje().getBroj());
      };
    }
    
    @Bean
    CommandLineRunner exchangeObavestenje(ObavestenjeClient obavestenjeClient) {
      return args -> {
        String broj = "RANDOM-001";
        
        Obavestenje obavestenje = new Obavestenje();
        obavestenje.setBroj(broj);
        
        ExchangeObavestenjeResponse response = obavestenjeClient.exchangeObavestenje(obavestenje);
        System.err.println(response.isStatus());
      };
    }

}
