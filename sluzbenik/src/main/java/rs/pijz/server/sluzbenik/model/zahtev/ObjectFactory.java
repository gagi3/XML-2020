
package rs.pijz.server.sluzbenik.model.zahtev;

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
     * Create an instance of {@link MetaData }
     * 
     */
    public MetaData createMetaData() {
        return new MetaData();
    }

    /**
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
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

}
