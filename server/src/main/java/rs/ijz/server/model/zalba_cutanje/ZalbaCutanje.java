
package rs.ijz.server.model.zalba_cutanje;

import rs.ijz.server.model.common.Adresa;
import rs.ijz.server.model.common.FizickoLice;
import rs.ijz.server.model.common.MetaData;

import javax.xml.bind.annotation.*;
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
 *         &lt;element name="protiv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="razlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *       &lt;attribute name="datum_zahteva" type="{http://www.w3.org/2001/XMLSchema}date" />
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
    "predmet",
    "komeJeUpucena",
    "protivOrgana",
    "razlog",
    "podaciOZahtevu",
    "podnosilacZalbe",
    "mestoPodnosenjaZalbe"
})
@XmlRootElement(name = "ZalbaCutanje", namespace = "http://www.pijz.rs/zalba-cutanje")
public class ZalbaCutanje {

    @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected MetaData metadata;
    @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected String predmet;
    @XmlElement(name = "kome_je_upucena", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected ZalbaCutanje.KomeJeUpucena komeJeUpucena;
    @XmlElement(name = "protiv_organa", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected String protivOrgana;
    @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected String razlog;
    @XmlElement(name = "podaci_o_zahtevu", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected String podaciOZahtevu;
    @XmlElement(name = "podnosilac_zalbe", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected ZalbaCutanje.PodnosilacZalbe podnosilacZalbe;
    @XmlElement(name = "mesto_podnosenja_zalbe", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected ZalbaCutanje.MestoPodnosenjaZalbe mestoPodnosenjaZalbe;
    @XmlAttribute(name = "datum_zahteva")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumZahteva;

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
     *     {@link ZalbaCutanje.KomeJeUpucena }
     *     
     */
    public ZalbaCutanje.KomeJeUpucena getKomeJeUpucena() {
        return komeJeUpucena;
    }

    /**
     * Sets the value of the komeJeUpucena property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.KomeJeUpucena }
     *     
     */
    public void setKomeJeUpucena(ZalbaCutanje.KomeJeUpucena value) {
        this.komeJeUpucena = value;
    }

    /**
     * Gets the value of the protivOrgana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtivOrgana() {
        return protivOrgana;
    }

    /**
     * Sets the value of the protivOrgana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtivOrgana(String value) {
        this.protivOrgana = value;
    }

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
     * Gets the value of the podaciOZahtevu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPodaciOZahtevu() {
        return podaciOZahtevu;
    }

    /**
     * Sets the value of the podaciOZahtevu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPodaciOZahtevu(String value) {
        this.podaciOZahtevu = value;
    }

    /**
     * Gets the value of the podnosilacZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.PodnosilacZalbe }
     *     
     */
    public ZalbaCutanje.PodnosilacZalbe getPodnosilacZalbe() {
        return podnosilacZalbe;
    }

    /**
     * Sets the value of the podnosilacZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.PodnosilacZalbe }
     *     
     */
    public void setPodnosilacZalbe(ZalbaCutanje.PodnosilacZalbe value) {
        this.podnosilacZalbe = value;
    }

    /**
     * Gets the value of the mestoPodnosenjaZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.MestoPodnosenjaZalbe }
     *     
     */
    public ZalbaCutanje.MestoPodnosenjaZalbe getMestoPodnosenjaZalbe() {
        return mestoPodnosenjaZalbe;
    }

    /**
     * Sets the value of the mestoPodnosenjaZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.MestoPodnosenjaZalbe }
     *     
     */
    public void setMestoPodnosenjaZalbe(ZalbaCutanje.MestoPodnosenjaZalbe value) {
        this.mestoPodnosenjaZalbe = value;
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
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "naziv",
        "adresaZaPostu"
    })
    public static class KomeJeUpucena {

        @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
        protected String naziv;
        @XmlElement(name = "adresa_za_postu", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
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
     *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
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

        @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
        protected String grad;
        @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
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
     *         &lt;element name="osoba" type="{http://www.pijz.rs/common}FizickoLice"/>
     *         &lt;element name="drugi_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
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

        @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
        protected FizickoLice osoba;
        @XmlElement(name = "drugi_kontakt", namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
        protected String drugiKontakt;
        @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
        protected String potpis;

        /**
         * Gets the value of the osoba property.
         * 
         * @return
         *     possible object is
         *     {@link FizickoLice }
         *     
         */
        public FizickoLice getOsoba() {
            return osoba;
        }

        /**
         * Sets the value of the osoba property.
         * 
         * @param value
         *     allowed object is
         *     {@link FizickoLice }
         *     
         */
        public void setOsoba(FizickoLice value) {
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

}
