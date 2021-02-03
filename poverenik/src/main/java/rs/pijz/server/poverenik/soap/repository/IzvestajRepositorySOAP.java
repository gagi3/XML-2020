package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.izvestaj.Izvestaj;
import rs.pijz.server.poverenik.repository.IzvestajRepository;

@Component
public class IzvestajRepositorySOAP {

	@Autowired
	private IzvestajRepository izvestajRepository;

	public Izvestaj getIzvestaj(String id) {
		Izvestaj izvestaj = new Izvestaj();
		izvestaj.setId(id);

		return izvestaj;
	}

	public boolean exchangeIzvestaj(Izvestaj izvestaj) throws Exception {
		izvestajRepository.save(izvestaj);

		return true;
	}

}
