package rs.pijz.server.sluzbenik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SluzbenikApplication {

    public static void main(String[] args) {
        SpringApplication.run(SluzbenikApplication.class, args);
    }
    
//    @Bean
//    CommandLineRunner lookupObavestenje(ObavestenjeClient obavestenjeClient) {
//      return args -> {
//        String broj = "OB-001";
//
//        if (args.length > 0) {
//          broj = args[0];
//        }
//        
//        GetObavestenjeResponse response = obavestenjeClient.getObavestenje(broj);
//        System.err.println(response.getObavestenje().getBroj());
//      };
//    }

}
