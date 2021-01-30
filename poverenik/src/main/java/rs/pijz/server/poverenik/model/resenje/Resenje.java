
package rs.pijz.server.poverenik.model.resenje;

import rs.pijz.server.poverenik.model.common.*;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Resenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Resenje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metadata" type="{http://www.pijz.rs/common}MetaData"/>
 *         &lt;element name="trazilac" type="{http://www.pijz.rs/common}FizickoLice"/>
 *         &lt;element name="poverenik" type="{http://www.pijz.rs/common}FizickoLice"/>
 *         &lt;element name="ustanova" type="{http://www.pijz.rs/common}PravnoLice"/>
 *         &lt;element name="dispozitiv">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="stav" type="{http://www.pijz.rs/resenje}Stav" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="obrazlozenje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="paragraf" type="{http://www.pijz.rs/resenje}Paragraf" maxOccurs="unbounded"/>
 *                   &lt;element name="tuzba" type="{http://www.pijz.rs/common}Tuzba"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datum_zahteva" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_zalbe" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_postupka" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="tip" type="{http://www.pijz.rs/resenje}Tip" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resenje", namespace = "http://www.pijz.rs/resenje", propOrder = {
    "metadata",
    "trazilac",
    "poverenik",
    "ustanova",
    "dispozitiv",
    "obrazlozenje"
})
public class Resenje {

    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected MetaData metadata;
    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected FizickoLice trazilac;
    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected FizickoLice poverenik;
    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected PravnoLice ustanova;
    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected Dispozitiv dispozitiv;
    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected Obrazlozenje obrazlozenje;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "broj")
    protected String broj;
    @XmlAttribute(name = "datum_zahteva")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumZahteva;
    @XmlAttribute(name = "datum_zalbe")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumZalbe;
    @XmlAttribute(name = "datum_postupka")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPostupka;
    @XmlAttribute(name = "tip")
    protected Tip tip;

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
     *     {@link FizickoLice }
     *     
     */
    public FizickoLice getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link FizickoLice }
     *     
     */
    public void setPoverenik(FizickoLice value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the ustanova property.
     * 
     * @return
     *     possible object is
     *     {@link PravnoLice }
     *     
     */
    public PravnoLice getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link PravnoLice }
     *     
     */
    public void setUstanova(PravnoLice value) {
        this.ustanova = value;
    }

    /**
     * Gets the value of the dispozitiv property.
     * 
     * @return
     *     possible object is
     *     {@link Dispozitiv }
     *     
     */
    public Dispozitiv getDispozitiv() {
        return dispozitiv;
    }

    /**
     * Sets the value of the dispozitiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dispozitiv }
     *     
     */
    public void setDispozitiv(Dispozitiv value) {
        this.dispozitiv = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     * 
     * @return
     *     possible object is
     *     {@link Obrazlozenje }
     *     
     */
    public Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obrazlozenje }
     *     
     */
    public void setObrazlozenje(Obrazlozenje value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
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
    public void setID(String value) {
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
     * Gets the value of the datumZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumZahteva() {
        return datumZahteva;
    }

    /**
     * Sets the value of the datumZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumZahteva(XMLGregorianCalendar value) {
        this.datumZahteva = value;
    }

    /**
     * Gets the value of the datumZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumZalbe() {
        return datumZalbe;
    }

    /**
     * Sets the value of the datumZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumZalbe(XMLGregorianCalendar value) {
        this.datumZalbe = value;
    }

    /**
     * Gets the value of the datumPostupka property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPostupka() {
        return datumPostupka;
    }

    /**
     * Sets the value of the datumPostupka property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPostupka(XMLGregorianCalendar value) {
        this.datumPostupka = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link Tip }
     *     
     */
    public Tip getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tip }
     *     
     */
    public void setTip(Tip value) {
        this.tip = value;
    }


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
     *         &lt;element name="stav" type="{http://www.pijz.rs/resenje}Stav" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "stav"
    })
    public static class Dispozitiv {

        @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
        protected List<Stav> stav;

        /**
         * Gets the value of the stav property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stav property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStav().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Stav }
         * 
         * 
         */
        public List<Stav> getStav() {
            if (stav == null) {
                stav = new ArrayList<Stav>();
            }
            return this.stav;
        }

    }


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
     *         &lt;element name="paragraf" type="{http://www.pijz.rs/resenje}Paragraf" maxOccurs="unbounded"/>
     *         &lt;element name="tuzba" type="{http://www.pijz.rs/common}Tuzba"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paragraf",
        "tuzba"
    })
    public static class Obrazlozenje {

        @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
        protected List<Paragraf> paragraf;
        @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
        protected Tuzba tuzba;

        /**
         * Gets the value of the paragraf property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paragraf property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParagraf().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Paragraf }
         * 
         * 
         */
        public List<Paragraf> getParagraf() {
            if (paragraf == null) {
                paragraf = new ArrayList<Paragraf>();
            }
            return this.paragraf;
        }

        /**
         * Gets the value of the tuzba property.
         * 
         * @return
         *     possible object is
         *     {@link Tuzba }
         *     
         */
        public Tuzba getTuzba() {
            return tuzba;
        }

        /**
         * Sets the value of the tuzba property.
         * 
         * @param value
         *     allowed object is
         *     {@link Tuzba }
         *     
         */
        public void setTuzba(Tuzba value) {
            this.tuzba = value;
        }

    }

}
