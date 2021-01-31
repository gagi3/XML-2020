package rs.pijz.server.poverenik.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

public class MailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    private static final String FROM = "pijz.portal.rs@gmail.com";

    private static void sendObavestenjeToPoverenik(String username, Date date, String sluzbenik, String xhtmlURL, String pdfURL) {
        SimpleMailMessage message = basicSetup(username);
        message.setSubject("Odgovor na zahtev za pristup informacijama od javnog značaja");
        message.setText("Poštovani/a,\n" +
                "\n" +
                "Dobili ste odgovor na vaš zahtev za pristup informacijama od javnog značaja podnet " + date.toString() + ".\n" +
                "\n" +
                "Dostavljamo vam linkove za preuzimanje dokumenta odgovora u HTML i PDF formi.\n" +
                "\n" +
                "HTML: " + xhtmlURL +
                "\n" +
                "PDF: " + pdfURL +
                "\n" +
                "Ukoliko niste zadovoljni odgovorom, imate pravo na žalbu u roku od 15 dana od dana dostavljanja odgovora.\n" +
                "\n" +
                "Žalbu možete podneti na portalu poverenika, klikom na link: http://localhost:4201" +
                "\n" +
                "Sve najbolje,\n" +
                "\n" +
                sluzbenik +
                "Portal za pristup informacijama od javnog značaja.");
    }

    private static SimpleMailMessage basicSetup(String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(username);
        message.setFrom(FROM);
        return message;
    }
}
