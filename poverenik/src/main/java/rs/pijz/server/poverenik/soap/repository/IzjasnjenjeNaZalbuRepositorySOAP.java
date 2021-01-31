package rs.pijz.server.poverenik.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.izjasnjenje_na_zalbu.IzjasnjenjeNaZalbu;

@Component
public class IzjasnjenjeNaZalbuRepositorySOAP {
	
	private static final Map<String, IzjasnjenjeNaZalbu> izjasnjenja = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		IzjasnjenjeNaZalbu izjasnjenje1 = new IzjasnjenjeNaZalbu();
		izjasnjenje1.setBroj("IZ-001");
		
		IzjasnjenjeNaZalbu izjasnjenje2 = new IzjasnjenjeNaZalbu();
		izjasnjenje2.setBroj("IZ-002");
		
		izjasnjenja.put(izjasnjenje1.getBroj(), izjasnjenje1);
		izjasnjenja.put(izjasnjenje2.getBroj(), izjasnjenje2);
	}
	
	public IzjasnjenjeNaZalbu findIzjasnjenje(String broj) {
		return izjasnjenja.get(broj);
	}

}
