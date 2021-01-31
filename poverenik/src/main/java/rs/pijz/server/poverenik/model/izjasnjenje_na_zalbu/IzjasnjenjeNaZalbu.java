
package rs.pijz.server.poverenik.model.izjasnjenje_na_zalbu;

import rs.pijz.server.poverenik.model.common.MetaData;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for IzjasnjenjeNaZalbu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IzjasnjenjeNaZalbu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metadata" type="{http://www.pijz.rs/common}MetaData"/>
 *         &lt;element name="tekst_izjave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="saglasnost_sa_zalbom" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="broj_zalbe" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datum_izjave" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="sluzbenikID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="poverenikID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="gradjaninID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "IzjasnjenjeNaZalbu", namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzjasnjenjeNaZalbu", namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu", propOrder = {
    "metadata",
    "tekstIzjave",
    "saglasnostSaZalbom"
})
public class IzjasnjenjeNaZalbu {

    @XmlElement(namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu", required = true)
    protected MetaData metadata;
    @XmlElement(name = "tekst_izjave", namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu", required = true)
    protected String tekstIzjave;
    @XmlElement(name = "saglasnost_sa_zalbom", namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu")
    protected boolean saglasnostSaZalbom;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "broj")
    protected String broj;
    @XmlAttribute(name = "broj_zalbe")
    protected String brojZalbe;
    @XmlAttribute(name = "datum_izjave")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzjave;
    @XmlAttribute(name = "sluzbenikID")
    protected String sluzbenikID;
    @XmlAttribute(name = "poverenikID")
    protected String poverenikID;
    @XmlAttribute(name = "gradjaninID")
    protected String gradjaninID;

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
     * Gets the value of the tekstIzjave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekstIzjave() {
        return tekstIzjave;
    }

    /**
     * Sets the value of the tekstIzjave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekstIzjave(String value) {
        this.tekstIzjave = value;
    }

    /**
     * Gets the value of the saglasnostSaZalbom property.
     * 
     */
    public boolean isSaglasnostSaZalbom() {
        return saglasnostSaZalbom;
    }

    /**
     * Sets the value of the saglasnostSaZalbom property.
     * 
     */
    public void setSaglasnostSaZalbom(boolean value) {
        this.saglasnostSaZalbom = value;
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
     * Gets the value of the broj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroj(String value) {
        this.broj = value;
    }

    /**
     * Gets the value of the brojZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojZalbe() {
        return brojZalbe;
    }

    /**
     * Sets the value of the brojZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojZalbe(String value) {
        this.brojZalbe = value;
    }

    /**
     * Gets the value of the datumIzjave property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzjave() {
        return datumIzjave;
    }

    /**
     * Sets the value of the datumIzjave property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzjave(XMLGregorianCalendar value) {
        this.datumIzjave = value;
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

    /**
     * Gets the value of the poverenikID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoverenikID() {
        return poverenikID;
    }

    /**
     * Sets the value of the poverenikID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoverenikID(String value) {
        this.poverenikID = value;
    }

    /**
     * Gets the value of the gradjaninID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGradjaninID() {
        return gradjaninID;
    }

    /**
     * Sets the value of the gradjaninID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGradjaninID(String value) {
        this.gradjaninID = value;
    }

}
