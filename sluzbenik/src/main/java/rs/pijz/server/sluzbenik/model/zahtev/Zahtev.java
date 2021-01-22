
package rs.pijz.server.sluzbenik.model.zahtev;

import rs.pijz.server.sluzbenik.model.common.FizickoLice;
import rs.pijz.server.sluzbenik.model.common.MetaData;
import rs.pijz.server.sluzbenik.model.common.PravnoLice;

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
 *         &lt;element name="opisInformacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="metadata" type="{http://www.pijz.rs/common}MetaData"/>
 *         &lt;element name="trazilac" type="{http://www.pijz.rs/common}FizickoLice"/>
 *         &lt;element name="poverenik" type="{http://www.pijz.rs/common}PravnoLice"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trazilacDodatniKontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drugiNacinDostave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "opisInformacije",
    "metadata",
    "trazilac",
    "poverenik",
    "mesto",
    "trazilacDodatniKontakt",
    "drugiNacinDostave"
})
@XmlRootElement(name = "Zahtev", namespace = "http://www.pijz.rs/zahtev")
public class Zahtev {

    @XmlElement(required = true)
    protected String opisInformacije;
    @XmlElement(required = true)
    protected MetaData metadata;
    @XmlElement(required = true)
    protected FizickoLice trazilac;
    @XmlElement(required = true)
    protected PravnoLice poverenik;
    @XmlElement(required = true)
    protected String mesto;
    @XmlElement(required = true)
    protected String trazilacDodatniKontakt;
    @XmlElement(required = true)
    protected String drugiNacinDostave;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the opisInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisInformacije() {
        return opisInformacije;
    }

    /**
     * Sets the value of the opisInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisInformacije(String value) {
        this.opisInformacije = value;
    }

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
     * Gets the value of the trazilac property.
     * 
     * @return
     *     possible object is
     *     {@link FizickoLice }
     *     
     */
    public FizickoLice getTrazilac() {
        return trazilac;
    }

    /**
     * Sets the value of the trazilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link FizickoLice }
     *     
     */
    public void setTrazilac(FizickoLice value) {
        this.trazilac = value;
    }

    /**
     * Gets the value of the poverenik property.
     * 
     * @return
     *     possible object is
     *     {@link PravnoLice }
     *     
     */
    public PravnoLice getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link PravnoLice }
     *     
     */
    public void setPoverenik(PravnoLice value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the trazilacDodatniKontakt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrazilacDodatniKontakt() {
        return trazilacDodatniKontakt;
    }

    /**
     * Sets the value of the trazilacDodatniKontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrazilacDodatniKontakt(String value) {
        this.trazilacDodatniKontakt = value;
    }

    /**
     * Gets the value of the drugiNacinDostave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugiNacinDostave() {
        return drugiNacinDostave;
    }

    /**
     * Sets the value of the drugiNacinDostave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugiNacinDostave(String value) {
        this.drugiNacinDostave = value;
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
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

}
