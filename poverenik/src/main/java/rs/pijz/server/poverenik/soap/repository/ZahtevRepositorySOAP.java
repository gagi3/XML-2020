package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zahtev.Zahtev;
import rs.pijz.server.poverenik.repository.ZahtevRepository;

@Component
public class ZahtevRepositorySOAP {

	@Autowired
	private ZahtevRepository zahtevRepository;

	public Zahtev getZahtev(String id) {
		Zahtev zahtev = new Zahtev();
		zahtev.setId(id);

		return zahtev;
	}

	public boolean exchangeZahtev(Zahtev zahtev) throws Exception {
		zahtevRepository.save(zahtev);

		return true;
	}

}
