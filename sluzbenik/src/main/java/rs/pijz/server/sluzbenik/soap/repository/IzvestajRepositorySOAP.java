package rs.pijz.server.sluzbenik.soap.repository;

import org.springframework.stereotype.Component;

import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;

@Component
public class IzvestajRepositorySOAP {
	
	public Izvestaj getIzvestaj(String id) {
		Izvestaj izvestaj = new Izvestaj();
		izvestaj.setId(id);

		return izvestaj;
	}
	
	public boolean exchangeIzvestaj(Izvestaj izvestaj) {
		// TODO: Handle exchange [izvestaj]
		System.out.println(">> handle action: [exchange izvestaj]");
		
		return true;
	}

}
