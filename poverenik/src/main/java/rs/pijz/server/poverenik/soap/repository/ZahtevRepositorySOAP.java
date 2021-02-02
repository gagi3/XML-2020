package rs.pijz.server.poverenik.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.resenje.Resenje;
import rs.pijz.server.poverenik.model.zahtev.Zahtev;

@Component
public class ZahtevRepositorySOAP {
	
	private static final Map<String, Zahtev> zahtevi = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		Zahtev zahtev1 = new Zahtev();
		zahtev1.setId("ID-Z-001");
		
		Zahtev zahtev2 = new Zahtev();
		zahtev2.setId("ID-Z-002");
		
		zahtevi.put(zahtev1.getId(), zahtev1);
		zahtevi.put(zahtev2.getId(), zahtev2);
	}
	
	public Zahtev findZahtev(String id) {
		return zahtevi.get(id);
	}

}
