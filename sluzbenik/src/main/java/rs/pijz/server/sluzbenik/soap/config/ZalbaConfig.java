package rs.pijz.server.sluzbenik.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import rs.pijz.server.sluzbenik.soap.client.ZalbaClient;

@Configuration
public class ZalbaConfig {
	
	@Bean
	public Jaxb2Marshaller zalbaMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rs.pijz.server.sluzbenik.soap.communication.zalba");
		return marshaller;
	}

	@Bean
	public ZalbaClient zalbaClient(Jaxb2Marshaller zalbaMarshaller) {
		ZalbaClient client = new ZalbaClient();
		client.setDefaultUri("http://localhost:8082/ws");
		client.setMarshaller(zalbaMarshaller);
		client.setUnmarshaller(zalbaMarshaller);
		return client;
	}

}
