package rs.pijz.server.sluzbenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.sluzbenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.sluzbenik.service.ZalbaCutanjeService;

@Component
public class ZalbaCutanjeRepositorySOAP {

	@Autowired
	private ZalbaCutanjeService zalbaCutanjeService;

	public ZalbaCutanje getZalbaCutanje(String broj) throws Exception {
		ZalbaCutanje zalbaCutanje = zalbaCutanjeService.getOne(broj);

		return zalbaCutanje;
	}

	public boolean exchangeZalbaCutanje(ZalbaCutanje zalbaCutanje) throws Exception {
		zalbaCutanjeService.create(zalbaCutanje);

		return true;
	}

}
