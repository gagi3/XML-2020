package rs.pijz.server.poverenik.soap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.repository.ZalbaOdlukaRepository;

@Component
public class ZalbaOdlukaRepositorySOAP {

	@Autowired
	private ZalbaOdlukaRepository zalbaOdlukaRepository;

	public ZalbaOdluka getZalbaOdluka(String broj) {
		ZalbaOdluka zalbaOdluka = new ZalbaOdluka();
		zalbaOdluka.setBroj(broj);

		return zalbaOdluka;
	}

	public boolean exchangeZalbaOdluka(ZalbaOdluka zalbaOdluka) throws Exception {
		zalbaOdlukaRepository.save(zalbaOdluka);

		return true;
	}

}
