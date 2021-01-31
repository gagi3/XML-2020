
package rs.pijz.server.poverenik.model.izvestaj;

import rs.pijz.server.poverenik.model.common.MetaData;
import rs.pijz.server.poverenik.model.izvestaj.ZalbaSadrzaj;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Izvestaj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Izvestaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metadata" type="{http://www.pijz.rs/common}MetaData"/>
 *         &lt;element name="brojPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="brojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="brojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="zalbe" type="{http://www.pijz.rs/izvestaj}ZalbaSadrzaj"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="sluzbenikID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "Izvestaj", namespace = "http://www.pijz.rs/izvestaj")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Izvestaj", namespace = "http://www.pijz.rs/izvestaj", propOrder = {
    "metadata",
    "brojPodnetihZahteva",
    "brojOdbijenihZahteva",
    "brojZalbiOdluka",
    "zalbe"
})
public class Izvestaj {

    @XmlElement(namespace = "http://www.pijz.rs/izvestaj", required = true)
    protected MetaData metadata;
    @XmlElement(namespace = "http://www.pijz.rs/izvestaj")
    protected int brojPodnetihZahteva;
    @XmlElement(namespace = "http://www.pijz.rs/izvestaj")
    protected int brojOdbijenihZahteva;
    @XmlElement(namespace = "http://www.pijz.rs/izvestaj")
    protected int brojZalbiOdluka;
    @XmlElement(namespace = "http://www.pijz.rs/izvestaj", required = true)
    protected ZalbaSadrzaj zalbe;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "sluzbenikID")
    protected String sluzbenikID;

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link MetaData }
     *     
     */
    public MetaData getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaData }
     *     
     */
    public void setMetadata(MetaData value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the brojPodnetihZahteva property.
     * 
     */
    public int getBrojPodnetihZahteva() {
        return brojPodnetihZahteva;
    }

    /**
     * Sets the value of the brojPodnetihZahteva property.
     * 
     */
    public void setBrojPodnetihZahteva(int value) {
        this.brojPodnetihZahteva = value;
    }

    /**
     * Gets the value of the brojOdbijenihZahteva property.
     * 
     */
    public int getBrojOdbijenihZahteva() {
        return brojOdbijenihZahteva;
    }

    /**
     * Sets the value of the brojOdbijenihZahteva property.
     * 
     */
    public void setBrojOdbijenihZahteva(int value) {
        this.brojOdbijenihZahteva = value;
    }

    /**
     * Gets the value of the brojZalbiOdluka property.
     * 
     */
    public int getBrojZalbiOdluka() {
        return brojZalbiOdluka;
    }

    /**
     * Sets the value of the brojZalbiOdluka property.
     * 
     */
    public void setBrojZalbiOdluka(int value) {
        this.brojZalbiOdluka = value;
    }

    /**
     * Gets the value of the zalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaSadrzaj }
     *     
     */
    public ZalbaSadrzaj getZalbe() {
        return zalbe;
    }

    /**
     * Sets the value of the zalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaSadrzaj }
     *     
     */
    public void setZalbe(ZalbaSadrzaj value) {
        this.zalbe = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the sluzbenikID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSluzbenikID() {
        return sluzbenikID;
    }

    /**
     * Sets the value of the sluzbenikID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSluzbenikID(String value) {
        this.sluzbenikID = value;
    }

}
