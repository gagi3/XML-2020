
package rs.pijz.server.poverenik.model.zahtev;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Dostava.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Dostava">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="posta"/>
 *     &lt;enumeration value="email"/>
 *     &lt;enumeration value="faks"/>
 *     &lt;enumeration value="drugo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Dostava", namespace = "http://www.pijz.rs/zahtev")
@XmlEnum
public enum Dostava {

    @XmlEnumValue("posta")
    POSTA("posta"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("faks")
    FAKS("faks"),
    @XmlEnumValue("drugo")
    DRUGO("drugo");
    private final String value;

    Dostava(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Dostava fromValue(String v) {
        for (Dostava c: Dostava.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
