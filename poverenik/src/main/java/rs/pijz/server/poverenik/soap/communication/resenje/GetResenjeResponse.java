//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.31 at 03:59:57 PM CET 
//


package rs.pijz.server.poverenik.soap.communication.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import rs.pijz.server.poverenik.model.resenje.Resenje;


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
 *         &lt;element name="resenje" type="{http://www.pijz.rs/resenje}Resenje"/>
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
    "resenje"
})
@XmlRootElement(name = "getResenjeResponse", namespace = "http://www.pijz.rs/resenje")
public class GetResenjeResponse {

    @XmlElement(namespace = "http://www.pijz.rs/resenje", required = true)
    protected Resenje resenje;

    /**
     * Gets the value of the resenje property.
     * 
     * @return
     *     possible object is
     *     {@link Resenje }
     *     
     */
    public Resenje getResenje() {
        return resenje;
    }

    /**
     * Sets the value of the resenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Resenje }
     *     
     */
    public void setResenje(Resenje value) {
        this.resenje = value;
    }

}