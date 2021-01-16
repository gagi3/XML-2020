package rs.pijz.server.sluzbenik.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PravnoLice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PravnoLice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa" type="{http://www.pijz.rs/common}Adresa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PravnoLice", propOrder = {
        "naziv",
        "adresa"
})
public class PravnoLice {

    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected Adresa adresa;

    /**
     * Gets the value of the naziv property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the adresa property.
     *
     * @return possible object is
     * {@link Adresa }
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     *
     * @param value allowed object is
     *              {@link Adresa }
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

}
