//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.03 at 10:42:03 PM CET 
//


package rs.pijz.server.sluzbenik.soap.communication.zalba_cutanje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import rs.pijz.server.sluzbenik.model.zalba_cutanje.ZalbaCutanje;


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
 *         &lt;element name="zalbaCutanje" type="{http://www.pijz.rs/zalba-cutanje}ZalbaCutanje"/>
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
    "zalbaCutanje"
})
@XmlRootElement(name = "exchangeZalbaCutanjeRequest", namespace = "http://www.pijz.rs/zalba-cutanje")
public class ExchangeZalbaCutanjeRequest {

    @XmlElement(namespace = "http://www.pijz.rs/zalba-cutanje", required = true)
    protected ZalbaCutanje zalbaCutanje;

    /**
     * Gets the value of the zalbaCutanje property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje }
     *     
     */
    public ZalbaCutanje getZalbaCutanje() {
        return zalbaCutanje;
    }

    /**
     * Sets the value of the zalbaCutanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje }
     *     
     */
    public void setZalbaCutanje(ZalbaCutanje value) {
        this.zalbaCutanje = value;
    }

}
