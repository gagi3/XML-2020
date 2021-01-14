@XmlSchema(
        namespace = "http://www.pijz.rs/resenje-zahtev-odbijen",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/resenje-zahtev-odbijen", prefix = "rzho"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.ijz.server.poverenik.model.resenje_zahtev_odbijen;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;