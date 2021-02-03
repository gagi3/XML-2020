package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.poverenik.service.ZalbaCutanjeService;

@Component
public class ZalbaCutanjeRepositorySOAP {

	@Autowired
	private ZalbaCutanjeService zalbaCutanjeService;

	public ZalbaCutanje getZalbaCutanje(String id) throws Exception {
		ZalbaCutanje zalbaCutanje = zalbaCutanjeService.getOne(id);

		return zalbaCutanje;
	}

	public boolean exchangeZalbaCutanje(ZalbaCutanje zalbaCutanje) throws Exception {
		zalbaCutanjeService.create(zalbaCutanje);

		return true;
	}

}
