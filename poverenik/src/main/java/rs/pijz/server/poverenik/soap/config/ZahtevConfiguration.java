package rs.pijz.server.poverenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.poverenik.soap.client.ZahtevClient;

@Configuration
public class ZahtevConfiguration {

	@Bean
	public Jaxb2Marshaller zahtevMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.poverenik.soap.communication.zahtev");
		return marshaller;
	}

	@Bean
	public ZahtevClient zahtevClient(Jaxb2Marshaller zahtevMarshaller) {
		ZahtevClient client = new ZahtevClient();
		client.setDefaultUri("http://localhost:8081/ws");
		client.setMarshaller(zahtevMarshaller);
		client.setUnmarshaller(zahtevMarshaller);
		return client;
	}

}
