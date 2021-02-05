package rs.pijz.server.mail.soap.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.mail.PijzMailSender;

@Component
public class ZalbaRepositorySOAP {
	
	@Autowired
	private PijzMailSender pijzMailSender;

	public void sendZalbaSluzbenik(String username, String zalbaID, Date date, String poverenik, String xhtmlURL, String pdfURL) throws Exception {
		pijzMailSender.sendZalbaToSluzbenik(username, zalbaID, date, poverenik, xhtmlURL, pdfURL);
	}

}
