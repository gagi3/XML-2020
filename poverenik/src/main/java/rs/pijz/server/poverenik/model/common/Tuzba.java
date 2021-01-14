package rs.ijz.server.poverenik.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tuzba complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tuzba">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rok" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taksa" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tuzba", propOrder = {
        "rok",
        "taksa"
})
public class Tuzba {

    protected int rok;
    protected double taksa;

    /**
     * Gets the value of the rok property.
     */
    public int getRok() {
        return rok;
    }

    /**
     * Sets the value of the rok property.
     */
    public void setRok(int value) {
        this.rok = value;
    }

    /**
     * Gets the value of the taksa property.
     */
    public double getTaksa() {
        return taksa;
    }

    /**
     * Sets the value of the taksa property.
     */
    public void setTaksa(double value) {
        this.taksa = value;
    }

}
