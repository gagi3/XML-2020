package rs.pijz.server.mail.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.mail.soap.client.ObavestenjeClient;

@Configuration
public class ObavestenjeConfig {
	
	@Bean
	public Jaxb2Marshaller obavestenjeMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.mail.soap.communication.obavestenje");
		return marshaller;
	}

	@Bean
	public ObavestenjeClient obavestenjeClient(Jaxb2Marshaller obavestenjeMarshaller) {
		ObavestenjeClient client = new ObavestenjeClient();
		client.setDefaultUri("http://localhost:8083/ws");
		client.setMarshaller(obavestenjeMarshaller);
		client.setUnmarshaller(obavestenjeMarshaller);
		return client;
	}

}
