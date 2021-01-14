package rs.pijz.server.poverenik.model.resenje_zalba_osnovana;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Stav complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Stav">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dokument">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="zasticena_informacija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="rok_obavestenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Stav", namespace = "http://www.pijz.rs/resenje-zalba-osnovana", propOrder = {
        "dokument",
        "rokObavestenja"
})
public class Stav {

    @XmlElement(required = true)
    protected Stav.Dokument dokument;
    @XmlElement(name = "rok_obavestenja")
    protected int rokObavestenja;
    @XmlAttribute(name = "redni_broj")
    protected Integer redniBroj;

    /**
     * Gets the value of the dokument property.
     *
     * @return possible object is
     * {@link Stav.Dokument }
     */
    public Stav.Dokument getDokument() {
        return dokument;
    }

    /**
     * Sets the value of the dokument property.
     *
     * @param value allowed object is
     *              {@link Stav.Dokument }
     */
    public void setDokument(Stav.Dokument value) {
        this.dokument = value;
    }

    /**
     * Gets the value of the rokObavestenja property.
     */
    public int getRokObavestenja() {
        return rokObavestenja;
    }

    /**
     * Sets the value of the rokObavestenja property.
     */
    public void setRokObavestenja(int value) {
        this.rokObavestenja = value;
    }

    /**
     * Gets the value of the redniBroj property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getRedniBroj() {
        return redniBroj;
    }

    /**
     * Sets the value of the redniBroj property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setRedniBroj(Integer value) {
        this.redniBroj = value;
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
     *         &lt;element name="zasticena_informacija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "naziv",
            "zasticenaInformacija"
    })
    public static class Dokument {

        @XmlElement(namespace = "http://www.pijz.rs/resenje-zalba-osnovana", required = true)
        protected String naziv;
        @XmlElement(name = "zasticena_informacija", namespace = "http://www.pijz.rs/resenje-zalba-osnovana", required = true)
        protected List<String> zasticenaInformacija;

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
         * Gets the value of the zasticenaInformacija property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zasticenaInformacija property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZasticenaInformacija().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getZasticenaInformacija() {
            if (zasticenaInformacija == null) {
                zasticenaInformacija = new ArrayList<String>();
            }
            return this.zasticenaInformacija;
        }

    }

}
