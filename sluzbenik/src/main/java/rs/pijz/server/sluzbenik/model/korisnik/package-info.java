@XmlSchema(
        namespace = "http://www.pijz.rs/korisnik",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/korisnik", prefix = "k"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.korisnik;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;