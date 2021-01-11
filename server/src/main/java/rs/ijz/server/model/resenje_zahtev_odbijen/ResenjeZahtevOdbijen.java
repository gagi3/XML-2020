
package rs.ijz.server.model.resenje_zahtev_odbijen;

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
 *         &lt;element name="dispozitiv" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
 *                             &lt;element name="razlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="trazeni_odgovor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                             &lt;element name="obavestenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="rok_informisanja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="razlog_neosnovanosti" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_obavestenja" type="{http://www.w3.org/2001/XMLSchema}date" />
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
@XmlRootElement(name = "ResenjeZahtevOdbijen", namespace = "http://www.pijz.rs/resenje-zahtev-odbijen")
public class ResenjeZahtevOdbijen {

    @XmlElement(required = true)
    protected MetaData metadata;
    @XmlElement(required = true)
    protected FizickoLice trazilac;
    @XmlElement(required = true)
    protected FizickoLice poverenik;
    @XmlElement(required = true)
    protected PravnoLice ustanova;
    @XmlElement(required = true)
    protected Object dispozitiv;
    @XmlElement(required = true)
    protected ResenjeZahtevOdbijen.Obrazlozenje obrazlozenje;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "broj")
    protected String broj;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAttribute(name = "datum_obavestenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumObavestenja;
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
     *     {@link Object }
     *     
     */
    public Object getDispozitiv() {
        return dispozitiv;
    }

    /**
     * Sets the value of the dispozitiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDispozitiv(Object value) {
        this.dispozitiv = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     * 
     * @return
     *     possible object is
     *     {@link ResenjeZahtevOdbijen.Obrazlozenje }
     *     
     */
    public ResenjeZahtevOdbijen.Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResenjeZahtevOdbijen.Obrazlozenje }
     *     
     */
    public void setObrazlozenje(ResenjeZahtevOdbijen.Obrazlozenje value) {
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
     * Gets the value of the datumObavestenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumObavestenja() {
        return datumObavestenja;
    }

    /**
     * Sets the value of the datumObavestenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumObavestenja(XMLGregorianCalendar value) {
        this.datumObavestenja = value;
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
     *         &lt;element name="paragraf" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="razlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="trazeni_odgovor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *                   &lt;element name="obavestenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="rok_informisanja" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="razlog_neosnovanosti" type="{http://www.w3.org/2001/XMLSchema}string"/>
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

        @XmlElement(required = true)
        protected List<ResenjeZahtevOdbijen.Obrazlozenje.Paragraf> paragraf;
        @XmlElement(required = true)
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
         * {@link ResenjeZahtevOdbijen.Obrazlozenje.Paragraf }
         * 
         * 
         */
        public List<ResenjeZahtevOdbijen.Obrazlozenje.Paragraf> getParagraf() {
            if (paragraf == null) {
                paragraf = new ArrayList<ResenjeZahtevOdbijen.Obrazlozenje.Paragraf>();
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
         *         &lt;element name="razlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="trazeni_odgovor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
         *         &lt;element name="obavestenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="rok_informisanja" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="razlog_neosnovanosti" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "razlog",
            "trazeniOdgovor",
            "obavestenje",
            "rokInformisanja",
            "razlogNeosnovanosti"
        })
        public static class Paragraf {

            @XmlElement(required = true)
            protected String razlog;
            @XmlElement(name = "trazeni_odgovor", required = true)
            protected List<String> trazeniOdgovor;
            @XmlElement(required = true)
            protected String obavestenje;
            @XmlElement(name = "rok_informisanja", namespace = "http://www.pijz.rs/resenje-zahtev-odbijen")
            protected int rokInformisanja;
            @XmlElement(name = "razlog_neosnovanosti", required = true)
            protected String razlogNeosnovanosti;

            /**
             * Gets the value of the razlog property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRazlog() {
                return razlog;
            }

            /**
             * Sets the value of the razlog property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRazlog(String value) {
                this.razlog = value;
            }

            /**
             * Gets the value of the trazeniOdgovor property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the trazeniOdgovor property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTrazeniOdgovor().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getTrazeniOdgovor() {
                if (trazeniOdgovor == null) {
                    trazeniOdgovor = new ArrayList<String>();
                }
                return this.trazeniOdgovor;
            }

            /**
             * Gets the value of the obavestenje property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObavestenje() {
                return obavestenje;
            }

            /**
             * Sets the value of the obavestenje property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObavestenje(String value) {
                this.obavestenje = value;
            }

            /**
             * Gets the value of the rokInformisanja property.
             * 
             */
            public int getRokInformisanja() {
                return rokInformisanja;
            }

            /**
             * Sets the value of the rokInformisanja property.
             * 
             */
            public void setRokInformisanja(int value) {
                this.rokInformisanja = value;
            }

            /**
             * Gets the value of the razlogNeosnovanosti property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRazlogNeosnovanosti() {
                return razlogNeosnovanosti;
            }

            /**
             * Sets the value of the razlogNeosnovanosti property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRazlogNeosnovanosti(String value) {
                this.razlogNeosnovanosti = value;
            }

        }

    }

}
