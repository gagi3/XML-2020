
package rs.ijz.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="Predmet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Kome_je_upucena">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Adresa_za_postu" type="{http://www.pijz.rs/zalba-odluka}Adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Zalilac">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Osoba_zalilac" type="{http://www.pijz.rs/zalba-odluka}Osoba"/>
 *                   &lt;element name="Sediste_zalioca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Donosilac_odluke" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Broj_resenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Godina_podnosenja_resenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Datum_podnosenja_zahteva" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Razlog_pobijanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Podnosilac_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Osoba" type="{http://www.pijz.rs/zalba-odluka}Osoba"/>
 *                   &lt;element name="Drugi_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Mesto_podnosenja_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "predmet",
    "komeJeUpucena",
    "zalilac",
    "donosilacOdluke",
    "brojResenja",
    "godinaPodnosenjaResenja",
    "datumPodnosenjaZahteva",
    "razlogPobijanja",
    "podnosilacZalbe",
    "mestoPodnosenjaZalbe"
})
@XmlRootElement(name = "ZalbaOdluka", namespace = "http://www.pijz.rs/zalba-odluka")
public class ZalbaOdluka {

    @XmlElement(name = "Predmet", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected String predmet;
    @XmlElement(name = "Kome_je_upucena", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected ZalbaOdluka.KomeJeUpucena komeJeUpucena;
    @XmlElement(name = "Zalilac", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected ZalbaOdluka.Zalilac zalilac;
    @XmlElement(name = "Donosilac_odluke", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected String donosilacOdluke;
    @XmlElement(name = "Broj_resenja", namespace = "http://www.pijz.rs/zalba-odluka")
    protected int brojResenja;
    @XmlElement(name = "Godina_podnosenja_resenja", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar godinaPodnosenjaResenja;
    @XmlElement(name = "Datum_podnosenja_zahteva", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenjaZahteva;
    @XmlElement(name = "Razlog_pobijanja", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected String razlogPobijanja;
    @XmlElement(name = "Podnosilac_zalbe", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected ZalbaOdluka.PodnosilacZalbe podnosilacZalbe;
    @XmlElement(name = "Mesto_podnosenja_zalbe", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected ZalbaOdluka.MestoPodnosenjaZalbe mestoPodnosenjaZalbe;

    /**
     * Gets the value of the predmet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPredmet() {
        return predmet;
    }

    /**
     * Sets the value of the predmet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPredmet(String value) {
        this.predmet = value;
    }

    /**
     * Gets the value of the komeJeUpucena property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaOdluka.KomeJeUpucena }
     *     
     */
    public ZalbaOdluka.KomeJeUpucena getKomeJeUpucena() {
        return komeJeUpucena;
    }

    /**
     * Sets the value of the komeJeUpucena property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaOdluka.KomeJeUpucena }
     *     
     */
    public void setKomeJeUpucena(ZalbaOdluka.KomeJeUpucena value) {
        this.komeJeUpucena = value;
    }

    /**
     * Gets the value of the zalilac property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaOdluka.Zalilac }
     *     
     */
    public ZalbaOdluka.Zalilac getZalilac() {
        return zalilac;
    }

    /**
     * Sets the value of the zalilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaOdluka.Zalilac }
     *     
     */
    public void setZalilac(ZalbaOdluka.Zalilac value) {
        this.zalilac = value;
    }

    /**
     * Gets the value of the donosilacOdluke property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonosilacOdluke() {
        return donosilacOdluke;
    }

    /**
     * Sets the value of the donosilacOdluke property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonosilacOdluke(String value) {
        this.donosilacOdluke = value;
    }

    /**
     * Gets the value of the brojResenja property.
     * 
     */
    public int getBrojResenja() {
        return brojResenja;
    }

    /**
     * Sets the value of the brojResenja property.
     * 
     */
    public void setBrojResenja(int value) {
        this.brojResenja = value;
    }

    /**
     * Gets the value of the godinaPodnosenjaResenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGodinaPodnosenjaResenja() {
        return godinaPodnosenjaResenja;
    }

    /**
     * Sets the value of the godinaPodnosenjaResenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGodinaPodnosenjaResenja(XMLGregorianCalendar value) {
        this.godinaPodnosenjaResenja = value;
    }

    /**
     * Gets the value of the datumPodnosenjaZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPodnosenjaZahteva() {
        return datumPodnosenjaZahteva;
    }

    /**
     * Sets the value of the datumPodnosenjaZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPodnosenjaZahteva(XMLGregorianCalendar value) {
        this.datumPodnosenjaZahteva = value;
    }

    /**
     * Gets the value of the razlogPobijanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazlogPobijanja() {
        return razlogPobijanja;
    }

    /**
     * Sets the value of the razlogPobijanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazlogPobijanja(String value) {
        this.razlogPobijanja = value;
    }

    /**
     * Gets the value of the podnosilacZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaOdluka.PodnosilacZalbe }
     *     
     */
    public ZalbaOdluka.PodnosilacZalbe getPodnosilacZalbe() {
        return podnosilacZalbe;
    }

    /**
     * Sets the value of the podnosilacZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaOdluka.PodnosilacZalbe }
     *     
     */
    public void setPodnosilacZalbe(ZalbaOdluka.PodnosilacZalbe value) {
        this.podnosilacZalbe = value;
    }

    /**
     * Gets the value of the mestoPodnosenjaZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaOdluka.MestoPodnosenjaZalbe }
     *     
     */
    public ZalbaOdluka.MestoPodnosenjaZalbe getMestoPodnosenjaZalbe() {
        return mestoPodnosenjaZalbe;
    }

    /**
     * Sets the value of the mestoPodnosenjaZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaOdluka.MestoPodnosenjaZalbe }
     *     
     */
    public void setMestoPodnosenjaZalbe(ZalbaOdluka.MestoPodnosenjaZalbe value) {
        this.mestoPodnosenjaZalbe = value;
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
     *         &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Adresa_za_postu" type="{http://www.pijz.rs/zalba-odluka}Adresa"/>
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
        "naziv",
        "adresaZaPostu"
    })
    public static class KomeJeUpucena {

        @XmlElement(name = "Naziv", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected String naziv;
        @XmlElement(name = "Adresa_za_postu", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected Adresa adresaZaPostu;

        /**
         * Gets the value of the naziv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

        /**
         * Gets the value of the adresaZaPostu property.
         * 
         * @return
         *     possible object is
         *     {@link Adresa }
         *     
         */
        public Adresa getAdresaZaPostu() {
            return adresaZaPostu;
        }

        /**
         * Sets the value of the adresaZaPostu property.
         * 
         * @param value
         *     allowed object is
         *     {@link Adresa }
         *     
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
     *         &lt;element name="Grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "grad",
        "datum"
    })
    public static class MestoPodnosenjaZalbe {

        @XmlElement(name = "Grad", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected String grad;
        @XmlElement(name = "Datum", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datum;

        /**
         * Gets the value of the grad property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGrad() {
            return grad;
        }

        /**
         * Sets the value of the grad property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGrad(String value) {
            this.grad = value;
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
     *         &lt;element name="Osoba" type="{http://www.pijz.rs/zalba-odluka}Osoba"/>
     *         &lt;element name="Drugi_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "osoba",
        "drugiKontakt",
        "potpis"
    })
    public static class PodnosilacZalbe {

        @XmlElement(name = "Osoba", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected Osoba osoba;
        @XmlElement(name = "Drugi_kontakt", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected String drugiKontakt;
        @XmlElement(name = "Potpis", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected String potpis;

        /**
         * Gets the value of the osoba property.
         * 
         * @return
         *     possible object is
         *     {@link Osoba }
         *     
         */
        public Osoba getOsoba() {
            return osoba;
        }

        /**
         * Sets the value of the osoba property.
         * 
         * @param value
         *     allowed object is
         *     {@link Osoba }
         *     
         */
        public void setOsoba(Osoba value) {
            this.osoba = value;
        }

        /**
         * Gets the value of the drugiKontakt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDrugiKontakt() {
            return drugiKontakt;
        }

        /**
         * Sets the value of the drugiKontakt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDrugiKontakt(String value) {
            this.drugiKontakt = value;
        }

        /**
         * Gets the value of the potpis property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPotpis() {
            return potpis;
        }

        /**
         * Sets the value of the potpis property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
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
     *         &lt;element name="Osoba_zalilac" type="{http://www.pijz.rs/zalba-odluka}Osoba"/>
     *         &lt;element name="Sediste_zalioca" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "osobaZalilac",
        "sedisteZalioca",
        "naziv"
    })
    public static class Zalilac {

        @XmlElement(name = "Osoba_zalilac", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected Osoba osobaZalilac;
        @XmlElement(name = "Sediste_zalioca", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected String sedisteZalioca;
        @XmlElement(name = "Naziv", namespace = "http://www.pijz.rs/zalba-odluka", required = true)
        protected String naziv;

        /**
         * Gets the value of the osobaZalilac property.
         * 
         * @return
         *     possible object is
         *     {@link Osoba }
         *     
         */
        public Osoba getOsobaZalilac() {
            return osobaZalilac;
        }

        /**
         * Sets the value of the osobaZalilac property.
         * 
         * @param value
         *     allowed object is
         *     {@link Osoba }
         *     
         */
        public void setOsobaZalilac(Osoba value) {
            this.osobaZalilac = value;
        }

        /**
         * Gets the value of the sedisteZalioca property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSedisteZalioca() {
            return sedisteZalioca;
        }

        /**
         * Sets the value of the sedisteZalioca property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSedisteZalioca(String value) {
            this.sedisteZalioca = value;
        }

        /**
         * Gets the value of the naziv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

    }

}
