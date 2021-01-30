@XmlSchema(
        namespace = "http://www.pijz.rs/poverenik",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/poverenik", prefix = "p"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/korisnik", prefix = "k"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.poverenik;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;