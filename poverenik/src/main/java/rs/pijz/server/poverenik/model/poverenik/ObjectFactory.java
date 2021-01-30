
package rs.pijz.server.poverenik.model.poverenik;

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

    private final static QName _Poverenik_QNAME = new QName("http://www.pijz.rs/poverenik", "Poverenik");
    private final static QName _Korisnik_QNAME = new QName("http://www.pijz.rs/korisnik", "Korisnik");
    private final static QName _PoverenikIzvestaji_QNAME = new QName("http://www.pijz.rs/poverenik", "izvestaji");
    private final static QName _PoverenikZalbe_QNAME = new QName("http://www.pijz.rs/poverenik", "zalbe");
    private final static QName _PoverenikResenja_QNAME = new QName("http://www.pijz.rs/poverenik", "resenja");

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
     * Create an instance of {@link Poverenik }
     * 
     */
    public Poverenik createPoverenik() {
        return new Poverenik();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Poverenik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/poverenik", name = "Poverenik")
    public JAXBElement<Poverenik> createPoverenik(Poverenik value) {
        return new JAXBElement<Poverenik>(_Poverenik_QNAME, Poverenik.class, null, value);
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
    @XmlElementDecl(namespace = "http://www.pijz.rs/poverenik", name = "izvestaji", scope = Poverenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createPoverenikIzvestaji(String value) {
        return new JAXBElement<String>(_PoverenikIzvestaji_QNAME, String.class, Poverenik.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/poverenik", name = "zalbe", scope = Poverenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createPoverenikZalbe(String value) {
        return new JAXBElement<String>(_PoverenikZalbe_QNAME, String.class, Poverenik.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/poverenik", name = "resenja", scope = Poverenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createPoverenikResenja(String value) {
        return new JAXBElement<String>(_PoverenikResenja_QNAME, String.class, Poverenik.class, value);
    }

}
