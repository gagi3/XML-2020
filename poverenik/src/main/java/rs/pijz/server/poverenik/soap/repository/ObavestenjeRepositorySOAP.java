package rs.pijz.server.poverenik.soap.repository;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import rs.pijz.server.poverenik.model.obavestenje.Obavestenje;

@Component
public class ObavestenjeRepositorySOAP {
	
	private static final Map<String, Obavestenje> obavestenja = new HashMap<>();
	
	@PostConstruct
	public void initData() throws Exception {
		GregorianCalendar dateRaw = new GregorianCalendar();
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateRaw);
		
		Obavestenje obavestenje1 = new Obavestenje();
		obavestenje1.setId("ID-001");
		obavestenje1.setBroj("99-18/9981");
		obavestenje1.setDatum(date);
		obavestenje1.setDatumUvida(date);
		obavestenje1.setDatumZahtevanja(date);
		obavestenje1.setVremeUvidaOd(date);
		obavestenje1.setVremeUvidaDo(date);
		
		Obavestenje obavestenje2 = new Obavestenje();
		obavestenje2.setId("ID-002");
		obavestenje2.setBroj("99-18/9982");
		obavestenje2.setDatum(date);
		obavestenje2.setDatumUvida(date);
		obavestenje2.setDatumZahtevanja(date);
		obavestenje2.setVremeUvidaOd(date);
		obavestenje2.setVremeUvidaDo(date);
		
		obavestenja.put(obavestenje1.getId(), obavestenje1);
		obavestenja.put(obavestenje2.getId(), obavestenje2);
	}
	
	public Obavestenje findObavestenje(String id) {
		return obavestenja.get(id);
	}

}
