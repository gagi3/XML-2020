@XmlSchema(
        namespace = "http://www.pijz.rs/izvestaj",
        xmlns = {
                @XmlNs(namespaceURI = "http://www.pijz.rs/izvestaj", prefix = "iz"),
                @XmlNs(namespaceURI = "http://www.pijz.rs/common", prefix = "cmn")
        },
        elementFormDefault = XmlNsForm.QUALIFIED
)
package rs.pijz.server.sluzbenik.model.izvestaj;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;