//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.03 at 09:56:43 PM CET 
//


package rs.pijz.server.sluzbenik.soap.communication.zalba_odluka;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import rs.pijz.server.sluzbenik.model.zalba_odluka.ZalbaOdluka;


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
 *         &lt;element name="zalbaOdluka" type="{http://www.pijz.rs/zalba-odluka}ZalbaOdluka"/>
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
    "zalbaOdluka"
})
@XmlRootElement(name = "exchangeZalbaOdlukaRequest", namespace = "http://www.pijz.rs/zalba-odluka")
public class ExchangeZalbaOdlukaRequest {

    @XmlElement(namespace = "http://www.pijz.rs/zalba-odluka", required = true)
    protected ZalbaOdluka zalbaOdluka;

    /**
     * Gets the value of the zalbaOdluka property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaOdluka }
     *     
     */
    public ZalbaOdluka getZalbaOdluka() {
        return zalbaOdluka;
    }

    /**
     * Sets the value of the zalbaOdluka property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaOdluka }
     *     
     */
    public void setZalbaOdluka(ZalbaOdluka value) {
        this.zalbaOdluka = value;
    }

}
