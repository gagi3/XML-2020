
package rs.pijz.server.sluzbenik.model.zalba_cutanje;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Razlog.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Razlog">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="organ_nije_postupio"/>
 *     &lt;enumeration value="organ_nije_postupio_u_celosti"/>
 *     &lt;enumeration value="organ_nije_postupio_u_zakonskom_roku"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Razlog", namespace = "http://www.pijz.rs/zalba-cutanje")
@XmlEnum
public enum Razlog {

    @XmlEnumValue("organ_nije_postupio")
    ORGAN_NIJE_POSTUPIO("organ_nije_postupio"),
    @XmlEnumValue("organ_nije_postupio_u_celosti")
    ORGAN_NIJE_POSTUPIO_U_CELOSTI("organ_nije_postupio_u_celosti"),
    @XmlEnumValue("organ_nije_postupio_u_zakonskom_roku")
    ORGAN_NIJE_POSTUPIO_U_ZAKONSKOM_ROKU("organ_nije_postupio_u_zakonskom_roku");
    private final String value;

    Razlog(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Razlog fromValue(String v) {
        for (Razlog c: Razlog.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
