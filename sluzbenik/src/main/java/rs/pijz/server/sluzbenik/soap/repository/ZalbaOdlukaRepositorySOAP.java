package rs.pijz.server.sluzbenik.soap.repository;

import org.springframework.stereotype.Component;

import rs.pijz.server.sluzbenik.model.zalba_odluka.ZalbaOdluka;

@Component
public class ZalbaOdlukaRepositorySOAP {
	
	public ZalbaOdluka getZalbaOdluka(String broj) {
		ZalbaOdluka zalbaOdluka = new ZalbaOdluka();
		zalbaOdluka.setBroj(broj);
		
		return zalbaOdluka;
	}
	
	public boolean exchangeZalbaOdluka(ZalbaOdluka zalbaOdluka) {
		// TODO: Handle exchange [zalba-odluka]
		System.out.println(">> handle action: [exchange zalba-odluka]");
		
		return true;
	}

}
