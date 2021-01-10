@XmlSchema(
        namespace = "http://www.pijz.rs/zalba-cutanje",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/zalba-cutanje", prefix = "zc"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.ijz.server.model.zalba_cutanje;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;