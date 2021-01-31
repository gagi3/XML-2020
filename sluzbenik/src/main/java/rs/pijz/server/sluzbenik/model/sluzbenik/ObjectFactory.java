
package rs.pijz.server.sluzbenik.model.sluzbenik;

import rs.pijz.server.sluzbenik.model.korisnik.Korisnik;
import rs.pijz.server.sluzbenik.model.common.*;

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

    private final static QName _Sluzbenik_QNAME = new QName("http://www.pijz.rs/sluzbenik", "Sluzbenik");
    private final static QName _Korisnik_QNAME = new QName("http://www.pijz.rs/korisnik", "Korisnik");
    private final static QName _SluzbenikResenja_QNAME = new QName("http://www.pijz.rs/sluzbenik", "resenja");
    private final static QName _SluzbenikOdgovori_QNAME = new QName("http://www.pijz.rs/sluzbenik", "odgovori");
    private final static QName _SluzbenikZahtevi_QNAME = new QName("http://www.pijz.rs/sluzbenik", "zahtevi");
    private final static QName _SluzbenikIzvestaji_QNAME = new QName("http://www.pijz.rs/sluzbenik", "izvestaji");
    private final static QName _SluzbenikZalbe_QNAME = new QName("http://www.pijz.rs/sluzbenik", "zalbe");

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
     * Create an instance of {@link Sluzbenik }
     * 
     */
    public Sluzbenik createSluzbenik() {
        return new Sluzbenik();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Sluzbenik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/sluzbenik", name = "Sluzbenik")
    public JAXBElement<Sluzbenik> createSluzbenik(Sluzbenik value) {
        return new JAXBElement<Sluzbenik>(_Sluzbenik_QNAME, Sluzbenik.class, null, value);
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
    @XmlElementDecl(namespace = "http://www.pijz.rs/sluzbenik", name = "resenja", scope = Sluzbenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createSluzbenikResenja(String value) {
        return new JAXBElement<String>(_SluzbenikResenja_QNAME, String.class, Sluzbenik.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/sluzbenik", name = "odgovori", scope = Sluzbenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createSluzbenikOdgovori(String value) {
        return new JAXBElement<String>(_SluzbenikOdgovori_QNAME, String.class, Sluzbenik.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/sluzbenik", name = "zahtevi", scope = Sluzbenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createSluzbenikZahtevi(String value) {
        return new JAXBElement<String>(_SluzbenikZahtevi_QNAME, String.class, Sluzbenik.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/sluzbenik", name = "izvestaji", scope = Sluzbenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createSluzbenikIzvestaji(String value) {
        return new JAXBElement<String>(_SluzbenikIzvestaji_QNAME, String.class, Sluzbenik.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/sluzbenik", name = "zalbe", scope = Sluzbenik.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    public JAXBElement<String> createSluzbenikZalbe(String value) {
        return new JAXBElement<String>(_SluzbenikZalbe_QNAME, String.class, Sluzbenik.class, value);
    }

}
