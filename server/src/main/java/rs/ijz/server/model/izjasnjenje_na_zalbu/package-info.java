@XmlSchema(
        namespace = "http://www.pijz.rs/izjasnjenje-na-zalbu",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/izjasnjenje-na-zalbu", prefix = "i"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.ijz.server.model.izjasnjenje_na_zalbu;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;