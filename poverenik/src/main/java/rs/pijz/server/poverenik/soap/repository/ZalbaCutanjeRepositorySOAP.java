package rs.pijz.server.poverenik.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.zalba_cutanje.ZalbaCutanje;

@Component
public class ZalbaCutanjeRepositorySOAP {
	
	private static final Map<String, ZalbaCutanje> zalbe = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		ZalbaCutanje zalbaCutanje1 = new ZalbaCutanje();
		zalbaCutanje1.setBroj("ZC-001");
		
		ZalbaCutanje zalbaCutanje2 = new ZalbaCutanje();
		zalbaCutanje2.setBroj("ZC-002");
		
		zalbe.put(zalbaCutanje1.getBroj(), zalbaCutanje1);
		zalbe.put(zalbaCutanje2.getBroj(), zalbaCutanje2);
	}
	
	public ZalbaCutanje findZalbaCutanje(String broj) {
		return zalbe.get(broj);
	}

}
