@XmlSchema(
        namespace = "http://www.pijz.rs/resenje",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/resenje", prefix = "r"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.resenje;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;