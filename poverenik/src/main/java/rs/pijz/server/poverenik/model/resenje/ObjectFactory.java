
package rs.pijz.server.poverenik.model.resenje;

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

    private final static QName _Resenje_QNAME = new QName("http://www.pijz.rs/resenje", "Resenje");

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
     * Create an instance of {@link Stav }
     * 
     */
    public Stav createStav() {
        return new Stav();
    }

    /**
     * Create an instance of {@link Resenje }
     * 
     */
    public Resenje createResenje() {
        return new Resenje();
    }

    /**
     * Create an instance of {@link Paragraf }
     * 
     */
    public Paragraf createParagraf() {
        return new Paragraf();
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
     * Create an instance of {@link Stav.Dokument }
     * 
     */
    public Stav.Dokument createStavDokument() {
        return new Stav.Dokument();
    }

    /**
     * Create an instance of {@link Resenje.Dispozitiv }
     * 
     */
    public Resenje.Dispozitiv createResenjeDispozitiv() {
        return new Resenje.Dispozitiv();
    }

    /**
     * Create an instance of {@link Resenje.Obrazlozenje }
     * 
     */
    public Resenje.Obrazlozenje createResenjeObrazlozenje() {
        return new Resenje.Obrazlozenje();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pijz.rs/resenje", name = "Resenje")
    public JAXBElement<Resenje> createResenje(Resenje value) {
        return new JAXBElement<Resenje>(_Resenje_QNAME, Resenje.class, null, value);
    }

}
