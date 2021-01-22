
package rs.pijz.server.poverenik.model.zahtev;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipZahteva.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipZahteva">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="obavestenje"/>
 *     &lt;enumeration value="uvid"/>
 *     &lt;enumeration value="kopija"/>
 *     &lt;enumeration value="dostava"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipZahteva", namespace = "http://www.pijz.rs/zahtev")
@XmlEnum
public enum TipZahteva {

    @XmlEnumValue("obavestenje")
    OBAVESTENJE("obavestenje"),
    @XmlEnumValue("uvid")
    UVID("uvid"),
    @XmlEnumValue("kopija")
    KOPIJA("kopija"),
    @XmlEnumValue("dostava")
    DOSTAVA("dostava");
    private final String value;

    TipZahteva(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipZahteva fromValue(String v) {
        for (TipZahteva c: TipZahteva.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
