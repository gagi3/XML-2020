
package rs.ijz.server.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaOdluka }
     * 
     */
    public ZalbaOdluka createZalbaOdluka() {
        return new ZalbaOdluka();
    }

    /**
     * Create an instance of {@link ZalbaOdluka.KomeJeUpucena }
     * 
     */
    public ZalbaOdluka.KomeJeUpucena createZalbaOdlukaKomeJeUpucena() {
        return new ZalbaOdluka.KomeJeUpucena();
    }

    /**
     * Create an instance of {@link ZalbaOdluka.Zalilac }
     * 
     */
    public ZalbaOdluka.Zalilac createZalbaOdlukaZalilac() {
        return new ZalbaOdluka.Zalilac();
    }

    /**
     * Create an instance of {@link ZalbaOdluka.PodnosilacZalbe }
     * 
     */
    public ZalbaOdluka.PodnosilacZalbe createZalbaOdlukaPodnosilacZalbe() {
        return new ZalbaOdluka.PodnosilacZalbe();
    }

    /**
     * Create an instance of {@link ZalbaOdluka.MestoPodnosenjaZalbe }
     * 
     */
    public ZalbaOdluka.MestoPodnosenjaZalbe createZalbaOdlukaMestoPodnosenjaZalbe() {
        return new ZalbaOdluka.MestoPodnosenjaZalbe();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Osoba }
     * 
     */
    public Osoba createOsoba() {
        return new Osoba();
    }

}