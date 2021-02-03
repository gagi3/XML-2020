package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.poverenik.repository.ZalbaCutanjeRepository;

@Component
public class ZalbaCutanjeRepositorySOAP {

	@Autowired
	private ZalbaCutanjeRepository zalbaCutanjeRepository;

	public ZalbaCutanje getZalbaCutanje(String broj) {
		ZalbaCutanje zalbaCutanje = new ZalbaCutanje();
		zalbaCutanje.setBroj(broj);

		return zalbaCutanje;
	}

	public boolean exchangeZalbaCutanje(ZalbaCutanje zalbaCutanje) throws Exception {
		zalbaCutanjeRepository.save(zalbaCutanje);

		return true;
	}

}
