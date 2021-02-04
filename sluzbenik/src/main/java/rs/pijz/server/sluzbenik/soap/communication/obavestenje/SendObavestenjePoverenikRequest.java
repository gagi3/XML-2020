//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.04 at 10:27:34 PM CET 
//


package rs.pijz.server.sluzbenik.soap.communication.obavestenje;

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
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="sluzbenik" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="xhtmlURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pdfURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "username",
    "date",
    "sluzbenik",
    "xhtmlURL",
    "pdfURL"
})
@XmlRootElement(name = "sendObavestenjePoverenikRequest")
public class SendObavestenjePoverenikRequest {

    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(required = true)
    protected String sluzbenik;
    @XmlElement(required = true)
    protected String xhtmlURL;
    @XmlElement(required = true)
    protected String pdfURL;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the sluzbenik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSluzbenik() {
        return sluzbenik;
    }

    /**
     * Sets the value of the sluzbenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSluzbenik(String value) {
        this.sluzbenik = value;
    }

    /**
     * Gets the value of the xhtmlURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXhtmlURL() {
        return xhtmlURL;
    }

    /**
     * Sets the value of the xhtmlURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXhtmlURL(String value) {
        this.xhtmlURL = value;
    }

    /**
     * Gets the value of the pdfURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdfURL() {
        return pdfURL;
    }

    /**
     * Sets the value of the pdfURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdfURL(String value) {
        this.pdfURL = value;
    }

}
