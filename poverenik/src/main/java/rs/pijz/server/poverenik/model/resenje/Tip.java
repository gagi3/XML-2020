
package rs.pijz.server.poverenik.model.resenje;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tip.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Tip">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="zalba_osnovana"/>
 *     &lt;enumeration value="zalba_neosnovana"/>
 *     &lt;enumeration value="zahtev_odbijen"/>
 *     &lt;enumeration value="ponisteno"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Tip", namespace = "http://www.pijz.rs/resenje")
@XmlEnum
public enum Tip {

    @XmlEnumValue("zalba_osnovana")
    ZALBA_OSNOVANA("zalba_osnovana"),
    @XmlEnumValue("zalba_neosnovana")
    ZALBA_NEOSNOVANA("zalba_neosnovana"),
    @XmlEnumValue("zahtev_odbijen")
    ZAHTEV_ODBIJEN("zahtev_odbijen"),
    @XmlEnumValue("ponisteno")
    PONISTENO("ponisteno");
    private final String value;

    Tip(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Tip fromValue(String v) {
        for (Tip c: Tip.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
