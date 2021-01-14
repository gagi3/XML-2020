package rs.ijz.server.poverenik.model.izjasnjenje_na_zalbu;

import rs.ijz.server.poverenik.model.common.MetaData;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "metadata",
        "tekstIzjave",
        "saglasnostSaZalbom"
})
@XmlRootElement(name = "izjasnjenjeNaZalbu", namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu")
public class IzjasnjenjeNaZalbu {

    @XmlElement(required = true)
    protected MetaData metadata;
    @XmlElement(name = "tekst_izjave", required = true)
    protected String tekstIzjave;
    @XmlElement(name = "saglasnost_sa_zalbom")
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

    /**
     * Gets the value of the metadata property.
     *
     * @return possible object is
     * {@link MetaData }
     */
    public MetaData getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     *
     * @param value allowed object is
     *              {@link MetaData }
     */
    public void setMetadata(MetaData value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the tekstIzjave property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTekstIzjave() {
        return tekstIzjave;
    }

    /**
     * Sets the value of the tekstIzjave property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTekstIzjave(String value) {
        this.tekstIzjave = value;
    }

    /**
     * Gets the value of the saglasnostSaZalbom property.
     */
    public boolean isSaglasnostSaZalbom() {
        return saglasnostSaZalbom;
    }

    /**
     * Sets the value of the saglasnostSaZalbom property.
     */
    public void setSaglasnostSaZalbom(boolean value) {
        this.saglasnostSaZalbom = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
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

    /**
     * Gets the value of the brojZalbe property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrojZalbe() {
        return brojZalbe;
    }

    /**
     * Sets the value of the brojZalbe property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrojZalbe(String value) {
        this.brojZalbe = value;
    }

    /**
     * Gets the value of the datumIzjave property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatumIzjave() {
        return datumIzjave;
    }

    /**
     * Sets the value of the datumIzjave property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatumIzjave(XMLGregorianCalendar value) {
        this.datumIzjave = value;
    }

}
