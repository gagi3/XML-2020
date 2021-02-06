
package rs.pijz.server.poverenik.model.izvestaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ZalbaSadrzaj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZalbaSadrzaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zalbaID" type="{http://www.w3.org/2001/XMLSchema}ID"/>
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZalbaSadrzaj", namespace = "http://www.pijz.rs/izvestaj", propOrder = {
    "zalbaID",
    "sadrzaj"
})
public class ZalbaSadrzaj {

    @XmlElement(namespace = "http://www.pijz.rs/izvestaj", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String zalbaID;
    @XmlElement(namespace = "http://www.pijz.rs/izvestaj", required = true)
    protected String sadrzaj;

    /**
     * Gets the value of the zalbaID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZalbaID() {
        return zalbaID;
    }

    /**
     * Sets the value of the zalbaID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZalbaID(String value) {
        this.zalbaID = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
    }

}
