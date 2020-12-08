
package rs.ijz.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Adresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Adresa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ulica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Broj_ulice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresa", namespace = "http://www.pijz.rs/zalba-odluka", propOrder = {
    "grad",
    "ulica",
    "brojUlice"
})
public class Adresa {

    @XmlElement(name = "Grad", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected String grad;
    @XmlElement(name = "Ulica", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected String ulica;
    @XmlElement(name = "Broj_ulice", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected String brojUlice;

    /**
     * Gets the value of the grad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    /**
     * Gets the value of the ulica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the brojUlice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojUlice() {
        return brojUlice;
    }

    /**
     * Sets the value of the brojUlice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojUlice(String value) {
        this.brojUlice = value;
    }

}
