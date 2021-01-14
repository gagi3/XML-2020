package rs.pijz.server.poverenik.model.resenje_zalba_neosnovana;

import rs.pijz.server.poverenik.model.common.FizickoLice;
import rs.pijz.server.poverenik.model.common.MetaData;
import rs.pijz.server.poverenik.model.common.PravnoLice;
import rs.pijz.server.poverenik.model.common.Tuzba;

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
 *         &lt;element name="broj_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                             &lt;element name="trazena_informacija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_zahteva" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_zalbe" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_postupka" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_odgovora" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "metadata",
        "trazilac",
        "poverenik",
        "ustanova",
        "brojZalbe",
        "dispozitiv",
        "obrazlozenje"
})
@XmlRootElement(name = "ResenjeZalbaNeosnovana", namespace = "http://www.pijz.rs/resenje-zalba-neosnovana")
public class ResenjeZalbaNeosnovana {

    @XmlElement(required = true)
    protected MetaData metadata;
    @XmlElement(required = true)
    protected FizickoLice trazilac;
    @XmlElement(required = true)
    protected FizickoLice poverenik;
    @XmlElement(required = true)
    protected PravnoLice ustanova;
    @XmlElement(name = "broj_zalbe", required = true)
    protected String brojZalbe;
    @XmlElement(required = true)
    protected Object dispozitiv;
    @XmlElement(required = true)
    protected ResenjeZalbaNeosnovana.Obrazlozenje obrazlozenje;
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
    @XmlAttribute(name = "datum_odgovora")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumOdgovora;

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
     * Gets the value of the trazilac property.
     *
     * @return possible object is
     * {@link FizickoLice }
     */
    public FizickoLice getTrazilac() {
        return trazilac;
    }

    /**
     * Sets the value of the trazilac property.
     *
     * @param value allowed object is
     *              {@link FizickoLice }
     */
    public void setTrazilac(FizickoLice value) {
        this.trazilac = value;
    }

    /**
     * Gets the value of the poverenik property.
     *
     * @return possible object is
     * {@link FizickoLice }
     */
    public FizickoLice getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     *
     * @param value allowed object is
     *              {@link FizickoLice }
     */
    public void setPoverenik(FizickoLice value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the ustanova property.
     *
     * @return possible object is
     * {@link PravnoLice }
     */
    public PravnoLice getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     *
     * @param value allowed object is
     *              {@link PravnoLice }
     */
    public void setUstanova(PravnoLice value) {
        this.ustanova = value;
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
     * Gets the value of the dispozitiv property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getDispozitiv() {
        return dispozitiv;
    }

    /**
     * Sets the value of the dispozitiv property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setDispozitiv(Object value) {
        this.dispozitiv = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     *
     * @return possible object is
     * {@link ResenjeZalbaNeosnovana.Obrazlozenje }
     */
    public ResenjeZalbaNeosnovana.Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     *
     * @param value allowed object is
     *              {@link ResenjeZalbaNeosnovana.Obrazlozenje }
     */
    public void setObrazlozenje(ResenjeZalbaNeosnovana.Obrazlozenje value) {
        this.obrazlozenje = value;
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
     * Gets the value of the datum property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the datumZahteva property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatumZahteva() {
        return datumZahteva;
    }

    /**
     * Sets the value of the datumZahteva property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatumZahteva(XMLGregorianCalendar value) {
        this.datumZahteva = value;
    }

    /**
     * Gets the value of the datumZalbe property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatumZalbe() {
        return datumZalbe;
    }

    /**
     * Sets the value of the datumZalbe property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatumZalbe(XMLGregorianCalendar value) {
        this.datumZalbe = value;
    }

    /**
     * Gets the value of the datumPostupka property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatumPostupka() {
        return datumPostupka;
    }

    /**
     * Sets the value of the datumPostupka property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatumPostupka(XMLGregorianCalendar value) {
        this.datumPostupka = value;
    }

    /**
     * Gets the value of the datumOdgovora property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatumOdgovora() {
        return datumOdgovora;
    }

    /**
     * Sets the value of the datumOdgovora property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatumOdgovora(XMLGregorianCalendar value) {
        this.datumOdgovora = value;
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
     *                   &lt;element name="trazena_informacija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "paragraf",
            "tuzba"
    })
    public static class Obrazlozenje {

        @XmlElement(required = true)
        protected List<ResenjeZalbaNeosnovana.Obrazlozenje.Paragraf> paragraf;
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
         * {@link ResenjeZalbaNeosnovana.Obrazlozenje.Paragraf }
         */
        public List<ResenjeZalbaNeosnovana.Obrazlozenje.Paragraf> getParagraf() {
            if (paragraf == null) {
                paragraf = new ArrayList<ResenjeZalbaNeosnovana.Obrazlozenje.Paragraf>();
            }
            return this.paragraf;
        }

        /**
         * Gets the value of the tuzba property.
         *
         * @return possible object is
         * {@link Tuzba }
         */
        public Tuzba getTuzba() {
            return tuzba;
        }

        /**
         * Sets the value of the tuzba property.
         *
         * @param value allowed object is
         *              {@link Tuzba }
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
         *         &lt;element name="trazena_informacija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
         *         &lt;element name="obavestenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="rok_informisanja" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="razlog_neosnovanosti" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "razlog",
                "trazenaInformacija",
                "obavestenje",
                "rokInformisanja",
                "razlogNeosnovanosti"
        })
        public static class Paragraf {

            @XmlElement(required = true)
            protected String razlog;
            @XmlElement(name = "trazena_informacija", required = true)
            protected List<String> trazenaInformacija;
            @XmlElement(required = true)
            protected String obavestenje;
            @XmlElement(name = "rok_informisanja")
            protected int rokInformisanja;
            @XmlElement(name = "razlog_neosnovanosti", required = true)
            protected String razlogNeosnovanosti;

            /**
             * Gets the value of the razlog property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getRazlog() {
                return razlog;
            }

            /**
             * Sets the value of the razlog property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setRazlog(String value) {
                this.razlog = value;
            }

            /**
             * Gets the value of the trazenaInformacija property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the trazenaInformacija property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTrazenaInformacija().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             */
            public List<String> getTrazenaInformacija() {
                if (trazenaInformacija == null) {
                    trazenaInformacija = new ArrayList<String>();
                }
                return this.trazenaInformacija;
            }

            /**
             * Gets the value of the obavestenje property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getObavestenje() {
                return obavestenje;
            }

            /**
             * Sets the value of the obavestenje property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setObavestenje(String value) {
                this.obavestenje = value;
            }

            /**
             * Gets the value of the rokInformisanja property.
             */
            public int getRokInformisanja() {
                return rokInformisanja;
            }

            /**
             * Sets the value of the rokInformisanja property.
             */
            public void setRokInformisanja(int value) {
                this.rokInformisanja = value;
            }

            /**
             * Gets the value of the razlogNeosnovanosti property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getRazlogNeosnovanosti() {
                return razlogNeosnovanosti;
            }

            /**
             * Sets the value of the razlogNeosnovanosti property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setRazlogNeosnovanosti(String value) {
                this.razlogNeosnovanosti = value;
            }

        }

    }

}
