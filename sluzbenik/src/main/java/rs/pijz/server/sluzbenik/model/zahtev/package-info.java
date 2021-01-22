@XmlSchema(
        namespace = "http://www.pijz.rs/zahtev",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/zahtev", prefix = "z"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.zahtev;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;