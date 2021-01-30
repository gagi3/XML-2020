
package rs.pijz.server.poverenik.model.obavestenje;

import rs.pijz.server.poverenik.model.common.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
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

    private final static QName _Obavestenje_QNAME = new QName("http://www.pijz.rs/obavestenje", "Obavestenje");

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
     * Create an instance of {@link Obavestenje }
     * 
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
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
     * Create an instance of {@link Obavestenje.Organ }
     * 
     */
    public Obavestenje.Organ createObavestenjeOrgan() {
        return new Obavestenje.Organ();
    }

    /**
     * Create an instance of {@link Obavestenje.Podnosilac }
     * 
     */
    public Obavestenje.Podnosilac createObavestenjePodnosilac() {
        return new Obavestenje.Podnosilac();
    }

    /**
     * Create an instance of {@link Obavestenje.Telo }
     * 
     */
    public Obavestenje.Telo createObavestenjeTelo() {
        return new Obavestenje.Telo();
    }

    /**
     * Create an instance of {@link Obavestenje.Podnozje }
     * 
     */
    public Obavestenje.Podnozje createObavestenjePodnozje() {
        return new Obavestenje.Podnozje();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/obavestenje", name = "Obavestenje")
    public JAXBElement<Obavestenje> createObavestenje(Obavestenje value) {
        return new JAXBElement<Obavestenje>(_Obavestenje_QNAME, Obavestenje.class, null, value);
    }

}
