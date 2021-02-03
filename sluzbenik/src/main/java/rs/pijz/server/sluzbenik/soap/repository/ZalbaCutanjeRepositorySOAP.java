package rs.pijz.server.sluzbenik.soap.repository;

import org.springframework.stereotype.Component;

import rs.pijz.server.sluzbenik.model.zalba_cutanje.ZalbaCutanje;

@Component
public class ZalbaCutanjeRepositorySOAP {
	
	public ZalbaCutanje getZalbaCutanje(String broj) {
		ZalbaCutanje zalbaCutanje = new ZalbaCutanje();
		zalbaCutanje.setBroj(broj);
		
		return zalbaCutanje;
	}
	
	public boolean exchangeZalbaCutanje(ZalbaCutanje zalbaCutanje) {
		// TODO: Handle exchange [zalba-cutanje]
		System.out.println(">> handle action: [exchange zalba-cutanje]");
		
		return true;
	}

}
