package rs.pijz.server.poverenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.poverenik.soap.client.ObavestenjeClient;

@Configuration
public class ObavestenjeConfig {
	
	@Bean
	public Jaxb2Marshaller obavestenjeMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.poverenik.soap.communication.obavestenje");
		return marshaller;
	}

	@Bean
	public ObavestenjeClient obavestenjeClient(Jaxb2Marshaller obavestenjeMarshaller) {
		ObavestenjeClient client = new ObavestenjeClient();
		client.setDefaultUri("http://localhost:8081/ws");
		client.setMarshaller(obavestenjeMarshaller);
		client.setUnmarshaller(obavestenjeMarshaller);
		return client;
	}

}
