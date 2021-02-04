package rs.pijz.server.mail.soap.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.mail.PijzMailSender;

@Component
public class ObavestenjeRepositorySOAP {
	
	@Autowired
	private PijzMailSender pijzMailSender;

	public void sendObavestenjePoverenik(String username, Date date, String sluzbenik, String xhtmlURL, String pdfURL) throws Exception {
		pijzMailSender.sendObavestenjeToPoverenik(username, date, sluzbenik, xhtmlURL, pdfURL);
	}

}
