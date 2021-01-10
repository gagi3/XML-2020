package rs.ijz.server.repository.rdf;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import rs.ijz.server.util.rdf.FusekiConnectionProperties;

public class AuthenticationUtilities {
	
	/**
	 * Read the configuration properties for the example.
	 * 
	 * @return the configuration object
	 */
	public static FusekiConnectionProperties loadProperties() throws IOException {
		String propsName = "fuseki.properties";

		InputStream propsStream = openStream(propsName);
		if (propsStream == null)
			throw new IOException("Could not read properties " + propsName);

		Properties props = new Properties();
		props.load(propsStream);

		return new FusekiConnectionProperties(props);
	}
	
	public static InputStream openStream(String fileName) throws IOException {
		return AuthenticationUtilities.class.getClassLoader().getResourceAsStream(fileName);
	}

	public static boolean createDataset(FusekiConnectionProperties conn) throws ConnectException {

		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("dbName", conn.dataset);
		map.add("dbType", conn.datasetType);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		try {
			rest.exchange(conn.endpoint + "/$/datasets", HttpMethod.POST, entity, String.class);
			return true;
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 409) {
				System.out.println("[INFO] Dataset already exists");
			}
		}

		return false;
	}

}
