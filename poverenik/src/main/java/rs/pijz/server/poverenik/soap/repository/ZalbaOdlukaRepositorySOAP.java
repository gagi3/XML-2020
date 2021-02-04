package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.service.ZalbaOdlukaService;

@Component
public class ZalbaOdlukaRepositorySOAP {

	@Autowired
	private ZalbaOdlukaService zalbaOdlukaService;

	public ZalbaOdluka getZalbaOdluka(String id) throws Exception {
		ZalbaOdluka zalbaOdluka = zalbaOdlukaService.getOne(id);

		return zalbaOdluka;
	}

	public boolean exchangeZalbaOdluka(ZalbaOdluka zalbaOdluka) throws Exception {
		zalbaOdlukaService.create(zalbaOdluka);

		return true;
	}

}
