package rs.ijz.server.model.resenje_zalba_osnovana;

import rs.ijz.server.model.common.FizickoLice;
import rs.ijz.server.model.common.MetaData;
import rs.ijz.server.model.common.PravnoLice;
import rs.ijz.server.model.common.Tuzba;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="trazilac" type="{http://www.pijz.rs/common}FizickoLice"/>
 *         &lt;element name="poverenik" type="{http://www.pijz.rs/common}FizickoLice"/>
 *         &lt;element name="ustanova" type="{http://www.pijz.rs/common}PravnoLice"/>
 *         &lt;element name="dispozitiv">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="stav" type="{http://www.pijz.rs/resenje-zalba-osnovana}Stav" maxOccurs="unbounded"/>
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
 *                   &lt;element name="paragraf" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="rok_postupka" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="rok_zahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="tuzba" type="{http://www.pijz.rs/common}Tuzba"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_zahteva" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_zalbe" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_postupka" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metadata",
    "trazilac",
    "poverenik",
    "ustanova",
    "dispozitiv",
    "obrazlozenje"
})
@XmlRootElement(name = "ResenjeZalbaOsnovana")
public class ResenjeZalbaOsnovana {

    @XmlElement(required = true)
    protected MetaData metadata;
    @XmlElement(required = true)
    protected FizickoLice trazilac;
    @XmlElement(required = true)
    protected FizickoLice poverenik;
    @XmlElement(required = true)
    protected PravnoLice ustanova;
    @XmlElement(required = true)
    protected ResenjeZalbaOsnovana.Dispozitiv dispozitiv;
    @XmlElement(required = true)
    protected ResenjeZalbaOsnovana.Obrazlozenje obrazlozenje;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "broj")
    protected String broj;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAttribute(name = "datum_zahteva")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumZahteva;
    @XmlAttribute(name = "datum_zalbe")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumZalbe;
    @XmlAttribute(name = "datum_postupka")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPostupka;

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
     *     {@link ResenjeZalbaOsnovana.Dispozitiv }
     *     
     */
    public ResenjeZalbaOsnovana.Dispozitiv getDispozitiv() {
        return dispozitiv;
    }

    /**
     * Sets the value of the dispozitiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResenjeZalbaOsnovana.Dispozitiv }
     *     
     */
    public void setDispozitiv(ResenjeZalbaOsnovana.Dispozitiv value) {
        this.dispozitiv = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     * 
     * @return
     *     possible object is
     *     {@link ResenjeZalbaOsnovana.Obrazlozenje }
     *     
     */
    public ResenjeZalbaOsnovana.Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResenjeZalbaOsnovana.Obrazlozenje }
     *     
     */
    public void setObrazlozenje(ResenjeZalbaOsnovana.Obrazlozenje value) {
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="stav" type="{http://www.pijz.rs/resenje-zalba-osnovana}Stav" maxOccurs="unbounded"/>
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

        @XmlElement(required = true)
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
     *         &lt;element name="paragraf" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="rok_postupka" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="rok_zahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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

        @XmlElement(namespace = "http://www.pijz.rs/resenje-zalba-osnovana", required = true)
        protected List<ResenjeZalbaOsnovana.Obrazlozenje.Paragraf> paragraf;
        @XmlElement(namespace = "http://www.pijz.rs/resenje-zalba-osnovana", required = true)
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
         * {@link ResenjeZalbaOsnovana.Obrazlozenje.Paragraf }
         * 
         * 
         */
        public List<ResenjeZalbaOsnovana.Obrazlozenje.Paragraf> getParagraf() {
            if (paragraf == null) {
                paragraf = new ArrayList<ResenjeZalbaOsnovana.Obrazlozenje.Paragraf>();
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
         *         &lt;element name="rok_postupka" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="rok_zahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
            "rokPostupka",
            "rokZahteva"
        })
        public static class Paragraf {

            @XmlElement(name = "rok_postupka", namespace = "http://www.pijz.rs/resenje-zalba-osnovana")
            protected int rokPostupka;
            @XmlElement(name = "rok_zahteva", namespace = "http://www.pijz.rs/resenje-zalba-osnovana")
            protected int rokZahteva;

            /**
             * Gets the value of the rokPostupka property.
             * 
             */
            public int getRokPostupka() {
                return rokPostupka;
            }

            /**
             * Sets the value of the rokPostupka property.
             * 
             */
            public void setRokPostupka(int value) {
                this.rokPostupka = value;
            }

            /**
             * Gets the value of the rokZahteva property.
             * 
             */
            public int getRokZahteva() {
                return rokZahteva;
            }

            /**
             * Sets the value of the rokZahteva property.
             * 
             */
            public void setRokZahteva(int value) {
                this.rokZahteva = value;
            }

        }

    }

}
