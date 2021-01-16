@XmlSchema(
        namespace = "http://www.pijz.rs/obavestenje",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/obavestenje", prefix = "o"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.obavestenje;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;