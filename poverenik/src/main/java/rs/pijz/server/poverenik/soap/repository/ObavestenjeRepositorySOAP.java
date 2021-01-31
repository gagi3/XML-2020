package rs.pijz.server.poverenik.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.obavestenje.Obavestenje;

@Component
public class ObavestenjeRepositorySOAP {
	
	private static final Map<String, Obavestenje> obavestenja = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		Obavestenje obavestenje1 = new Obavestenje();
		obavestenje1.setBroj("OB-001");
		
		Obavestenje obavestenje2 = new Obavestenje();
		obavestenje2.setBroj("OB-002");
		
		obavestenja.put(obavestenje1.getBroj(), obavestenje1);
		obavestenja.put(obavestenje2.getBroj(), obavestenje2);
	}
	
	public Obavestenje findObavestenje(String broj) {
		return obavestenja.get(broj);
	}

}
