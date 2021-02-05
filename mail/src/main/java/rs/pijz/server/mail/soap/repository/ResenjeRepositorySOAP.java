package rs.pijz.server.mail.soap.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.pijz.server.mail.PijzMailSender;

@Component
public class ResenjeRepositorySOAP {
	
	@Autowired
	private PijzMailSender pijzMailSender;

	public void sendResenjeGradjanin(String username, String zalbaID, Date date, String poverenik, String xhtmlURL, String pdfURL) throws Exception {
		pijzMailSender.sendResenjeToGradjanin(username, zalbaID, date, poverenik, xhtmlURL, pdfURL);
	}
	
	public void sendResenjeSluzbenik(String username, String zalbaID, Date date, String poverenik, String xhtmlURL, String pdfURL) throws Exception {
		pijzMailSender.sendResenjeToSluzbenik(username, zalbaID, date, poverenik, xhtmlURL, pdfURL);
	}

}
