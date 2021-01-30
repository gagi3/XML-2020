
package rs.pijz.server.poverenik.model.gradjanin;

import rs.pijz.server.poverenik.model.common.*;
import rs.pijz.server.poverenik.model.korisnik.Korisnik;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


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

    private final static QName _Gradjanin_QNAME = new QName("http://www.pijz.rs/gradjanin", "Gradjanin");
    private final static QName _Korisnik_QNAME = new QName("http://www.pijz.rs/korisnik", "Korisnik");
    private final static QName _GradjaninZahtevi_QNAME = new QName("http://www.pijz.rs/gradjanin", "zahtevi");
    private final static QName _GradjaninZalbe_QNAME = new QName("http://www.pijz.rs/gradjanin", "zalbe");
    private final static QName _GradjaninResenja_QNAME = new QName("http://www.pijz.rs/gradjanin", "resenja");
    private final static QName _GradjaninOdgovori_QNAME = new QName("http://www.pijz.rs/gradjanin", "odgovori");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MetaData }
     * 
     */
    public MetaData createMetaData() {
        return new MetaData();
    }

    /**
     * Create an instance of {@link Gradjanin }
     * 
     */
    public Gradjanin createGradjanin() {
        return new Gradjanin();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link FizickoLice }
     * 
     */
    public FizickoLice createFizickoLice() {
        return new FizickoLice();
    }

    /**
     * Create an instance of {@link PravnoLice }
     * 
     */
    public PravnoLice createPravnoLice() {
        return new PravnoLice();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Tuzba }
     * 
     */
    public Tuzba createTuzba() {
        return new Tuzba();
    }

    /**
     * Create an instance of {@link MetaData.Meta }
     * 
     */
    public MetaData.Meta createMetaDataMeta() {
        return new MetaData.Meta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gradjanin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/gradjanin", name = "Gradjanin")
    public JAXBElement<Gradjanin> createGradjanin(Gradjanin value) {
        return new JAXBElement<Gradjanin>(_Gradjanin_QNAME, Gradjanin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Korisnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/korisnik", name = "Korisnik")
    public JAXBElement<Korisnik> createKorisnik(Korisnik value) {
        return new JAXBElement<Korisnik>(_Korisnik_QNAME, Korisnik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/gradjanin", name = "zahtevi", scope = Gradjanin.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createGradjaninZahtevi(String value) {
        return new JAXBElement<String>(_GradjaninZahtevi_QNAME, String.class, Gradjanin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/gradjanin", name = "zalbe", scope = Gradjanin.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createGradjaninZalbe(String value) {
        return new JAXBElement<String>(_GradjaninZalbe_QNAME, String.class, Gradjanin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/gradjanin", name = "resenja", scope = Gradjanin.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createGradjaninResenja(String value) {
        return new JAXBElement<String>(_GradjaninResenja_QNAME, String.class, Gradjanin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/gradjanin", name = "odgovori", scope = Gradjanin.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createGradjaninOdgovori(String value) {
        return new JAXBElement<String>(_GradjaninOdgovori_QNAME, String.class, Gradjanin.class, value);
    }

}
