package rs.pijz.server.sluzbenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;
import rs.pijz.server.sluzbenik.service.IzvestajService;

@Component
public class IzvestajRepositorySOAP {

	@Autowired
	private IzvestajService izvestajService;

	public Izvestaj getIzvestaj(String id) throws Exception {
		Izvestaj izvestaj = izvestajService.getOne(id);

		return izvestaj;
	}

	public boolean exchangeIzvestaj(Izvestaj izvestaj) throws Exception {
		izvestajService.create(izvestaj);

		return true;
	}

}
