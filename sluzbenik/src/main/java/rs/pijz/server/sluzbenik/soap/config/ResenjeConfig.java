package rs.pijz.server.sluzbenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.sluzbenik.soap.client.ResenjeClient;

@Configuration
public class ResenjeConfig {
	
	@Bean
	public Jaxb2Marshaller resenjeMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.sluzbenik.soap.communication.resenje");
		return marshaller;
	}

	@Bean
	public ResenjeClient resenjeClient(Jaxb2Marshaller resenjeMarshaller) {
		ResenjeClient client = new ResenjeClient();
		client.setDefaultUri("http://localhost:8082/ws");
		client.setMarshaller(resenjeMarshaller);
		client.setUnmarshaller(resenjeMarshaller);
		return client;
	}

}
