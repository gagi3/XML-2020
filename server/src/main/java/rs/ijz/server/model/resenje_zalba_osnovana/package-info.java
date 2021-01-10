@XmlSchema(
        namespace = "http://www.pijz.rs/resenje-zalba-osnovana",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/resenje-zalba-osnovana", prefix = "rzo"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.ijz.server.model.resenje_zalba_osnovana;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;