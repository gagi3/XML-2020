package rs.pijz.server.poverenik.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.resenje.Resenje;

@Component
public class ResenjeRepositorySOAP {
	
	private static final Map<String, Resenje> resenja = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		Resenje resenje1 = new Resenje();
		resenje1.setBroj("R-001");
		
		Resenje resenje2 = new Resenje();
		resenje2.setBroj("R-002");
		
		resenja.put(resenje1.getBroj(), resenje1);
		resenja.put(resenje2.getBroj(), resenje2);
	}
	
	public Resenje findResenje(String broj) {
		return resenja.get(broj);
	}

}
