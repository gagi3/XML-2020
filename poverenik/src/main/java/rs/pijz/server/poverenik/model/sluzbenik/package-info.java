@XmlSchema(
        namespace = "http://www.pijz.rs/sluzbenik",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/sluzbenik", prefix = "s"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/korisnik", prefix = "k"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.poverenik.model.sluzbenik;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;