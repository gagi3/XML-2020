package rs.pijz.server.sluzbenik.model.zalba_odluka;

import rs.pijz.server.sluzbenik.model.common.Adresa;
import rs.pijz.server.sluzbenik.model.common.FizickoLice;
import rs.pijz.server.sluzbenik.model.common.MetaData;

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
 *         &lt;element name="predmet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kome_je_upucena">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adresa_za_postu" type="{http://www.pijz.rs/common}Adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zalilac">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="osoba_zalilac" type="{http://www.pijz.rs/common}FizickoLice"/>
 *                   &lt;element name="sediste_zalioca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="donosilac_odluke" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_resenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="godina_resenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="razlog_pobijanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podnosilac_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="osoba" type="{http://www.pijz.rs/common}FizickoLice"/>
 *                   &lt;element name="drugi_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="mesto_podnosenja_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "metadata",
        "predmet",
        "komeJeUpucena",
        "zalilac",
        "donosilacOdluke",
        "brojResenja",
        "godinaResenja",
        "razlogPobijanja",
        "podnosilacZalbe",
        "mestoPodnosenjaZalbe"
})
@XmlRootElement(name = "ZalbaOdluka", namespace = "http://www.pijz.rs/zalba-odluka")
public class ZalbaOdluka {

    @XmlElement(required = true)
    protected MetaData metadata;
    @XmlElement(required = true)
    protected String predmet;
    @XmlElement(required = true)
    protected KomeJeUpucena komeJeUpucena;
    @XmlElement(required = true)
    protected Zalilac zalilac;
    @XmlElement(name = "donosilac_odluke", required = true)
    protected String donosilacOdluke;
    @XmlElement(name = "broj_resenja")
    protected int brojResenja;
    @XmlElement(name = "godina_resenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar godinaResenja;
    @XmlElement(name = "razlog_pobijanja", required = true)
    protected String razlogPobijanja;
    @XmlElement(name = "podnosilac_zalbe", required = true)
    protected PodnosilacZalbe podnosilacZalbe;
    @XmlElement(name = "mesto_podnosenja_zalbe", required = true)
    protected MestoPodnosenjaZalbe mestoPodnosenjaZalbe;
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
     * Gets the value of the predmet property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPredmet() {
        return predmet;
    }

    /**
     * Sets the value of the predmet property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPredmet(String value) {
        this.predmet = value;
    }

    /**
     * Gets the value of the komeJeUpucena property.
     *
     * @return possible object is
     * {@link KomeJeUpucena }
     */
    public KomeJeUpucena getKomeJeUpucena() {
        return komeJeUpucena;
    }

    /**
     * Sets the value of the komeJeUpucena property.
     *
     * @param value allowed object is
     *              {@link KomeJeUpucena }
     */
    public void setKomeJeUpucena(KomeJeUpucena value) {
        this.komeJeUpucena = value;
    }

    /**
     * Gets the value of the zalilac property.
     *
     * @return possible object is
     * {@link Zalilac }
     */
    public Zalilac getZalilac() {
        return zalilac;
    }

    /**
     * Sets the value of the zalilac property.
     *
     * @param value allowed object is
     *              {@link Zalilac }
     */
    public void setZalilac(Zalilac value) {
        this.zalilac = value;
    }

    /**
     * Gets the value of the donosilacOdluke property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDonosilacOdluke() {
        return donosilacOdluke;
    }

    /**
     * Sets the value of the donosilacOdluke property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDonosilacOdluke(String value) {
        this.donosilacOdluke = value;
    }

    /**
     * Gets the value of the brojResenja property.
     */
    public int getBrojResenja() {
        return brojResenja;
    }

    /**
     * Sets the value of the brojResenja property.
     */
    public void setBrojResenja(int value) {
        this.brojResenja = value;
    }

    /**
     * Gets the value of the godinaResenja property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getGodinaResenja() {
        return godinaResenja;
    }

    /**
     * Sets the value of the godinaResenja property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setGodinaResenja(XMLGregorianCalendar value) {
        this.godinaResenja = value;
    }

    /**
     * Gets the value of the razlogPobijanja property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRazlogPobijanja() {
        return razlogPobijanja;
    }

    /**
     * Sets the value of the razlogPobijanja property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRazlogPobijanja(String value) {
        this.razlogPobijanja = value;
    }

    /**
     * Gets the value of the podnosilacZalbe property.
     *
     * @return possible object is
     * {@link PodnosilacZalbe }
     */
    public PodnosilacZalbe getPodnosilacZalbe() {
        return podnosilacZalbe;
    }

    /**
     * Sets the value of the podnosilacZalbe property.
     *
     * @param value allowed object is
     *              {@link PodnosilacZalbe }
     */
    public void setPodnosilacZalbe(PodnosilacZalbe value) {
        this.podnosilacZalbe = value;
    }

    /**
     * Gets the value of the mestoPodnosenjaZalbe property.
     *
     * @return possible object is
     * {@link MestoPodnosenjaZalbe }
     */
    public MestoPodnosenjaZalbe getMestoPodnosenjaZalbe() {
        return mestoPodnosenjaZalbe;
    }

    /**
     * Sets the value of the mestoPodnosenjaZalbe property.
     *
     * @param value allowed object is
     *              {@link MestoPodnosenjaZalbe }
     */
    public void setMestoPodnosenjaZalbe(MestoPodnosenjaZalbe value) {
        this.mestoPodnosenjaZalbe = value;
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
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="adresa_za_postu" type="{http://www.pijz.rs/common}Adresa"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "naziv",
            "adresaZaPostu"
    })
    public static class KomeJeUpucena {

        @XmlElement(required = true)
        protected String naziv;
        @XmlElement(name = "adresa_za_postu", required = true)
        protected Adresa adresaZaPostu;

        /**
         * Gets the value of the naziv property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

        /**
         * Gets the value of the adresaZaPostu property.
         *
         * @return possible object is
         * {@link Adresa }
         */
        public Adresa getAdresaZaPostu() {
            return adresaZaPostu;
        }

        /**
         * Sets the value of the adresaZaPostu property.
         *
         * @param value allowed object is
         *              {@link Adresa }
         */
        public void setAdresaZaPostu(Adresa value) {
            this.adresaZaPostu = value;
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
     *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "grad",
            "datum"
    })
    public static class MestoPodnosenjaZalbe {

        @XmlElement(required = true)
        protected String grad;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datum;

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
     *         &lt;element name="osoba" type="{http://www.pijz.rs/common}FizickoLice"/>
     *         &lt;element name="drugi_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "osoba",
            "drugiKontakt",
            "potpis"
    })
    public static class PodnosilacZalbe {

        @XmlElement(required = true)
        protected FizickoLice osoba;
        @XmlElement(name = "drugi_kontakt", required = true)
        protected String drugiKontakt;
        @XmlElement(required = true)
        protected String potpis;

        /**
         * Gets the value of the osoba property.
         *
         * @return possible object is
         * {@link FizickoLice }
         */
        public FizickoLice getOsoba() {
            return osoba;
        }

        /**
         * Sets the value of the osoba property.
         *
         * @param value allowed object is
         *              {@link FizickoLice }
         */
        public void setOsoba(FizickoLice value) {
            this.osoba = value;
        }

        /**
         * Gets the value of the drugiKontakt property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDrugiKontakt() {
            return drugiKontakt;
        }

        /**
         * Sets the value of the drugiKontakt property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDrugiKontakt(String value) {
            this.drugiKontakt = value;
        }

        /**
         * Gets the value of the potpis property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPotpis() {
            return potpis;
        }

        /**
         * Sets the value of the potpis property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPotpis(String value) {
            this.potpis = value;
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
     *         &lt;element name="osoba_zalilac" type="{http://www.pijz.rs/common}FizickoLice"/>
     *         &lt;element name="sediste_zalioca" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "osobaZalilac",
            "sedisteZalioca",
            "naziv"
    })
    public static class Zalilac {

        @XmlElement(name = "osoba_zalilac", required = true)
        protected FizickoLice osobaZalilac;
        @XmlElement(name = "sediste_zalioca", required = true)
        protected String sedisteZalioca;
        @XmlElement(required = true)
        protected String naziv;

        /**
         * Gets the value of the osobaZalilac property.
         *
         * @return possible object is
         * {@link FizickoLice }
         */
        public FizickoLice getOsobaZalilac() {
            return osobaZalilac;
        }

        /**
         * Sets the value of the osobaZalilac property.
         *
         * @param value allowed object is
         *              {@link FizickoLice }
         */
        public void setOsobaZalilac(FizickoLice value) {
            this.osobaZalilac = value;
        }

        /**
         * Gets the value of the sedisteZalioca property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSedisteZalioca() {
            return sedisteZalioca;
        }

        /**
         * Sets the value of the sedisteZalioca property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSedisteZalioca(String value) {
            this.sedisteZalioca = value;
        }

        /**
         * Gets the value of the naziv property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

    }

}
