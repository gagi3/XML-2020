package rs.pijz.server.poverenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.poverenik.soap.client.ZalbaOdlukaClient;

@Configuration
public class ZalbaOdlukaConfiguration {

	@Bean
	public Jaxb2Marshaller zalbaOdlukaMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.poverenik.soap.communication.zalba_odluka");
		return marshaller;
	}

	@Bean
	public ZalbaOdlukaClient zalbaOdlukaClient(Jaxb2Marshaller zalbaOdlukaMarshaller) {
		ZalbaOdlukaClient client = new ZalbaOdlukaClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(zalbaOdlukaMarshaller);
		client.setUnmarshaller(zalbaOdlukaMarshaller);
		return client;
	}

}
