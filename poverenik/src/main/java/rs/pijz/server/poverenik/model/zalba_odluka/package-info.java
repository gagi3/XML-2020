@XmlSchema(
        namespace = "http://www.pijz.rs/zalba-odluka",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/zalba-odluka", prefix = "zo"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.poverenik.model.zalba_odluka;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;