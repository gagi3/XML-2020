package rs.pijz.server.sluzbenik.soap.repository;

import org.springframework.stereotype.Component;

import rs.pijz.server.sluzbenik.model.zahtev.Zahtev;

@Component
public class ZahtevRepositorySOAP {
	
	public Zahtev getZahtev(String id) {
		Zahtev zahtev = new Zahtev();
		zahtev.setId(id);

		return zahtev;
	}
	
	public boolean exchangeZahtev(Zahtev zahtev) {
		// TODO: Handle exchange [zahtev]
		System.out.println(">> handle action: [exchange zahtev]");
		
		return true;
	}

}
