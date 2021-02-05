package rs.pijz.server.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PijzMailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    private final String FROM = "pijz.portal.rs@gmail.com";

    public void sendObavestenjeToPoverenik(String username, Date date, String sluzbenik, String xhtmlURL, String pdfURL) {
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
        javaMailSender.send(message);
    }

    public void sendZalbaToSluzbenik(String username, String obavestenjeID, Date date, String poverenik, String xhtmlURL, String pdfURL) {
        SimpleMailMessage message = basicSetup(username);
        message.setSubject("Uložena žalba");
        message.setText("Poštovani/a,\n" +
                "\n" +
                "Uložena je žalba na vašu odluku u postupku broj " + obavestenjeID + " podnetu " + date.toString() + ".\n" +
                "\n" +
                "Dostavljamo vam linkove za preuzimanje dokumenta žalbe u HTML i PDF formi.\n" +
                "\n" +
                "HTML: " + xhtmlURL +
                "\n" +
                "PDF: " + pdfURL +
                "\n" +
                "Rok za izjašnjavanje o žalbi je sedam dana od dana dostave dokumenta.\n" +
                "\n" +
                "Izjašnjenje možete podneti na vašem portalu." +
                "\n" +
                "Sve najbolje,\n" +
                "\n" +
                poverenik +
                "Portal za pristup informacijama od javnog značaja.");
        javaMailSender.send(message);
    }

    public void sendResenjeToGradjanin(String username, String zalbaID, Date date, String poverenik, String xhtmlURL, String pdfURL) {
        SimpleMailMessage message = basicSetup(username);
        message.setSubject("Rešenje po žalbi broj " + zalbaID);
        message.setText("Poštovani/a,\n" +
                "\n" +
                "Doneto je rešenje na vašu žalbu broj " + zalbaID + " podnetu " + date.toString() + ".\n" +
                "\n" +
                "Dostavljamo vam linkove za preuzimanje dokumenta rešenja u HTML i PDF formi.\n" +
                "\n" +
                "HTML: " + xhtmlURL +
                "\n" +
                "PDF: " + pdfURL +
                "\n" +
                "O izvršenju rešenja će vas obavestiti organ vlasti.\n" +
                "\n" +
                "Sve najbolje,\n" +
                "\n" +
                poverenik +
                "Portal za pristup informacijama od javnog značaja.");
        javaMailSender.send(message);
    }

    public void sendResenjeToSluzbenik(String username, String zalbaID, Date date, String poverenik, String xhtmlURL, String pdfURL) {
        SimpleMailMessage message = basicSetup(username);
        message.setSubject("Rešenje po žalbi broj " + zalbaID);
        message.setText("Poštovani/a,\n" +
                "\n" +
                "Doneto je rešenje na žalbu broj " + zalbaID + " podnetu " + date.toString() + ".\n" +
                "\n" +
                "Dostavljamo vam linkove za preuzimanje dokumenta rešenja u HTML i PDF formi.\n" +
                "\n" +
                "HTML: " + xhtmlURL +
                "\n" +
                "PDF: " + pdfURL +
                "\n" +
                "Molimo da pratite zakonske rokove u izvršenju rešenja.\n" +
                "\n" +
                "Sve najbolje,\n" +
                "\n" +
                poverenik +
                "Portal za pristup informacijama od javnog značaja.");
        javaMailSender.send(message);
    }

    private SimpleMailMessage basicSetup(String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(username);
        message.setFrom(FROM);
        return message;
    }
}
