package rs.pijz.server.poverenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.poverenik.soap.client.IzvestajClient;

@Configuration
public class IzvestajConfiguration {

	@Bean
	public Jaxb2Marshaller izvestajMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.poverenik.soap.communication.izvestaj");
		return marshaller;
	}

	@Bean
	public IzvestajClient izvestajClient(Jaxb2Marshaller izvestajMarshaller) {
		IzvestajClient client = new IzvestajClient();
		client.setDefaultUri("http://localhost:8081/ws");
		client.setMarshaller(izvestajMarshaller);
		client.setUnmarshaller(izvestajMarshaller);
		return client;
	}

}
