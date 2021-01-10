
package rs.ijz.server.model.obavestenje;

import rs.ijz.server.model.common.Adresa;
import rs.ijz.server.model.common.FizickoLice;
import rs.ijz.server.model.common.MetaData;
import rs.ijz.server.model.common.PravnoLice;

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
 *         &lt;element name="organ">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sediste" type="{http://www.pijz.rs/common}Adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podnosilac">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="fizickoLice" type="{http://www.pijz.rs/common}FizickoLice"/>
 *                   &lt;element name="pravnoLice" type="{http://www.pijz.rs/common}PravnoLice"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podnaslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="paragraf" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podnozje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pecat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "metadata",
    "organ",
    "podnosilac",
    "naslov",
    "podnaslov",
    "telo",
    "podnozje"
})
@XmlRootElement(name = "Obavestenje", namespace = "http://www.pijz.rs/obavestenje")
public class Obavestenje {

    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected MetaData metadata;
    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected Obavestenje.Organ organ;
    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected Obavestenje.Podnosilac podnosilac;
    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected String naslov;
    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected String podnaslov;
    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected Obavestenje.Telo telo;
    @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
    protected Obavestenje.Podnozje podnozje;
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
     * Gets the value of the organ property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Organ }
     *     
     */
    public Obavestenje.Organ getOrgan() {
        return organ;
    }

    /**
     * Sets the value of the organ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Organ }
     *     
     */
    public void setOrgan(Obavestenje.Organ value) {
        this.organ = value;
    }

    /**
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Podnosilac }
     *     
     */
    public Obavestenje.Podnosilac getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Podnosilac }
     *     
     */
    public void setPodnosilac(Obavestenje.Podnosilac value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the podnaslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPodnaslov() {
        return podnaslov;
    }

    /**
     * Sets the value of the podnaslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPodnaslov(String value) {
        this.podnaslov = value;
    }

    /**
     * Gets the value of the telo property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Telo }
     *     
     */
    public Obavestenje.Telo getTelo() {
        return telo;
    }

    /**
     * Sets the value of the telo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Telo }
     *     
     */
    public void setTelo(Obavestenje.Telo value) {
        this.telo = value;
    }

    /**
     * Gets the value of the podnozje property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Podnozje }
     *     
     */
    public Obavestenje.Podnozje getPodnozje() {
        return podnozje;
    }

    /**
     * Sets the value of the podnozje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Podnozje }
     *     
     */
    public void setPodnozje(Obavestenje.Podnozje value) {
        this.podnozje = value;
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
     *         &lt;element name="sediste" type="{http://www.pijz.rs/common}Adresa"/>
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
        "sediste"
    })
    public static class Organ {

        @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
        protected String naziv;
        @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
        protected Adresa sediste;

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
         * Gets the value of the sediste property.
         * 
         * @return
         *     possible object is
         *     {@link Adresa }
         *     
         */
        public Adresa getSediste() {
            return sediste;
        }

        /**
         * Sets the value of the sediste property.
         * 
         * @param value
         *     allowed object is
         *     {@link Adresa }
         *     
         */
        public void setSediste(Adresa value) {
            this.sediste = value;
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
     *       &lt;choice>
     *         &lt;element name="fizickoLice" type="{http://www.pijz.rs/common}FizickoLice"/>
     *         &lt;element name="pravnoLice" type="{http://www.pijz.rs/common}PravnoLice"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fizickoLice",
        "pravnoLice"
    })
    public static class Podnosilac {

        @XmlElement(namespace = "http://www.pijz.rs/obavestenje")
        protected FizickoLice fizickoLice;
        @XmlElement(namespace = "http://www.pijz.rs/obavestenje")
        protected PravnoLice pravnoLice;

        /**
         * Gets the value of the fizickoLice property.
         * 
         * @return
         *     possible object is
         *     {@link FizickoLice }
         *     
         */
        public FizickoLice getFizickoLice() {
            return fizickoLice;
        }

        /**
         * Sets the value of the fizickoLice property.
         * 
         * @param value
         *     allowed object is
         *     {@link FizickoLice }
         *     
         */
        public void setFizickoLice(FizickoLice value) {
            this.fizickoLice = value;
        }

        /**
         * Gets the value of the pravnoLice property.
         * 
         * @return
         *     possible object is
         *     {@link PravnoLice }
         *     
         */
        public PravnoLice getPravnoLice() {
            return pravnoLice;
        }

        /**
         * Sets the value of the pravnoLice property.
         * 
         * @param value
         *     allowed object is
         *     {@link PravnoLice }
         *     
         */
        public void setPravnoLice(PravnoLice value) {
            this.pravnoLice = value;
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
     *         &lt;element name="pecat" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "pecat",
        "potpis"
    })
    public static class Podnozje {

        @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
        protected String pecat;
        @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
        protected String potpis;

        /**
         * Gets the value of the pecat property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPecat() {
            return pecat;
        }

        /**
         * Sets the value of the pecat property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPecat(String value) {
            this.pecat = value;
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
     *         &lt;element name="paragraf" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "paragraf"
    })
    public static class Telo {

        @XmlElement(namespace = "http://www.pijz.rs/obavestenje", required = true)
        protected List<String> paragraf;

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
         * {@link String }
         * 
         * 
         */
        public List<String> getParagraf() {
            if (paragraf == null) {
                paragraf = new ArrayList<String>();
            }
            return this.paragraf;
        }

    }

}
