package rs.pijz.server.sluzbenik.model.common;

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
 *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresa", propOrder = {
        "grad",
        "ulica",
        "broj"
})
public class Adresa {

    @XmlElement(required = true)
    protected String grad;
    @XmlElement(required = true)
    protected String ulica;
    @XmlElement(required = true)
    protected String broj;

    /**
     * Gets the value of the grad property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    /**
     * Gets the value of the ulica property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the broj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBroj(String value) {
        this.broj = value;
    }

}
