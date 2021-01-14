@XmlSchema(
        namespace = "http://www.pijz.rs/resenje-zalba-neosnovana",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/resenje-zalba-neosnovana", prefix = "rzn"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.ijz.server.poverenik.model.resenje_zalba_neosnovana;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;