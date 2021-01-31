
package rs.pijz.server.sluzbenik.model.gradjanin;

import rs.pijz.server.sluzbenik.model.korisnik.Korisnik;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Gradjanin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Gradjanin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="korisnik" type="{http://www.pijz.rs/korisnik}Korisnik"/>
 *         &lt;element name="zahtevi" type="{http://www.w3.org/2001/XMLSchema}ID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="zalbe" type="{http://www.w3.org/2001/XMLSchema}ID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resenja" type="{http://www.w3.org/2001/XMLSchema}ID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="odgovori" type="{http://www.w3.org/2001/XMLSchema}ID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "Gradjanin", namespace = "http://www.pijz.rs/gradjanin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gradjanin", namespace = "http://www.pijz.rs/gradjanin", propOrder = {
    "korisnik",
    "zahtevi",
    "zalbe",
    "resenja",
    "odgovori"
})
public class Gradjanin {

    @XmlElement(required = true)
    protected Korisnik korisnik;
    @XmlElementRef(name = "zahtevi", namespace = "http://www.pijz.rs/gradjanin", type = JAXBElement.class, required = false)
    protected List<JAXBElement<String>> zahtevi;
    @XmlElementRef(name = "zalbe", namespace = "http://www.pijz.rs/gradjanin", type = JAXBElement.class, required = false)
    protected List<JAXBElement<String>> zalbe;
    @XmlElementRef(name = "resenja", namespace = "http://www.pijz.rs/gradjanin", type = JAXBElement.class, required = false)
    protected List<JAXBElement<String>> resenja;
    @XmlElementRef(name = "odgovori", namespace = "http://www.pijz.rs/gradjanin", type = JAXBElement.class, required = false)
    protected List<JAXBElement<String>> odgovori;

    /**
     * Gets the value of the korisnik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Sets the value of the korisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setKorisnik(Korisnik value) {
        this.korisnik = value;
    }

    /**
     * Gets the value of the zahtevi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zahtevi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZahtevi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getZahtevi() {
        if (zahtevi == null) {
            zahtevi = new ArrayList<JAXBElement<String>>();
        }
        return this.zahtevi;
    }

    /**
     * Gets the value of the zalbe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zalbe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZalbe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getZalbe() {
        if (zalbe == null) {
            zalbe = new ArrayList<JAXBElement<String>>();
        }
        return this.zalbe;
    }

    /**
     * Gets the value of the resenja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resenja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResenja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getResenja() {
        if (resenja == null) {
            resenja = new ArrayList<JAXBElement<String>>();
        }
        return this.resenja;
    }

    /**
     * Gets the value of the odgovori property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the odgovori property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOdgovori().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getOdgovori() {
        if (odgovori == null) {
            odgovori = new ArrayList<JAXBElement<String>>();
        }
        return this.odgovori;
    }

}
