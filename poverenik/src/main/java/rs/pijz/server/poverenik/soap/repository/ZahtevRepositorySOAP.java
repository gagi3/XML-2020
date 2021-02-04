package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zahtev.Zahtev;
import rs.pijz.server.poverenik.service.ZahtevService;

@Component
public class ZahtevRepositorySOAP {

	@Autowired
	private ZahtevService zahtevService;

	public Zahtev getZahtev(String id) throws Exception {
		Zahtev zahtev = zahtevService.getOne(id);

		return zahtev;
	}

	public boolean exchangeZahtev(Zahtev zahtev) throws Exception {
		zahtevService.create(zahtev);

		return true;
	}

}
