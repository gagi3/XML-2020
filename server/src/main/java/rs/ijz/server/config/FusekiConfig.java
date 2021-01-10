package rs.ijz.server.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.ijz.server.repository.rdf.AuthenticationUtilities;
import rs.ijz.server.util.rdf.FusekiConnectionProperties;

@Configuration
public class FusekiConfig {
	
	@Bean
	public FusekiConnectionProperties fusekiConnectionProperties() throws IOException {
		return AuthenticationUtilities.loadProperties();
	}

}
