@XmlSchema(
        namespace = "http://www.pijz.rs/gradjanin",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/gradjanin", prefix = "g"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/korisnik", prefix = "k"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.gradjanin;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;