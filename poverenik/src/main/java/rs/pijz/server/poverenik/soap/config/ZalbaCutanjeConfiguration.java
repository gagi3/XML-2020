package rs.pijz.server.poverenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.poverenik.soap.client.ZalbaCutanjeClient;

@Configuration
public class ZalbaCutanjeConfiguration {

	@Bean
	public Jaxb2Marshaller zalbaCutanjeMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.poverenik.soap.communication.zalba_cutanje");
		return marshaller;
	}

	@Bean
	public ZalbaCutanjeClient zalbaCutanjeClient(Jaxb2Marshaller zalbaCutanjeMarshaller) {
		ZalbaCutanjeClient client = new ZalbaCutanjeClient();
		client.setDefaultUri("http://localhost:8081/ws");
		client.setMarshaller(zalbaCutanjeMarshaller);
		client.setUnmarshaller(zalbaCutanjeMarshaller);
		return client;
	}

}
