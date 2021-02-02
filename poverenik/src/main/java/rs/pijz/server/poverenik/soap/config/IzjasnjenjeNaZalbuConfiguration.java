package rs.pijz.server.poverenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.poverenik.soap.client.IzjasnjenjeNaZalbuClient;

@Configuration
public class IzjasnjenjeNaZalbuConfiguration {

	@Bean
	public Jaxb2Marshaller izjasnjenjeNaZalbuMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.poverenik.soap.communication.izjasnjenje_na_zalbu");
		return marshaller;
	}

	@Bean
	public IzjasnjenjeNaZalbuClient izjasnjenjeNaZalbuClient(Jaxb2Marshaller izjasnjenjeNaZalbuMarshaller) {
		IzjasnjenjeNaZalbuClient client = new IzjasnjenjeNaZalbuClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(izjasnjenjeNaZalbuMarshaller);
		client.setUnmarshaller(izjasnjenjeNaZalbuMarshaller);
		return client;
	}

}
