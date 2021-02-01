package rs.pijz.server.poverenik.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;

@Component
public class ZalbaOdlukaRepositorySOAP {
	
private static final Map<String, ZalbaOdluka> zalbe = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		ZalbaOdluka zalbaOdluka1 = new ZalbaOdluka();
		zalbaOdluka1.setBroj("ZO-001");
		
		ZalbaOdluka zalbaOdluka2 = new ZalbaOdluka();
		zalbaOdluka2.setBroj("ZO-002");
		
		zalbe.put(zalbaOdluka1.getBroj(), zalbaOdluka1);
		zalbe.put(zalbaOdluka2.getBroj(), zalbaOdluka2);
	}
	
	public ZalbaOdluka findZalbaOdluka(String broj) {
		return zalbe.get(broj);
	}

}
