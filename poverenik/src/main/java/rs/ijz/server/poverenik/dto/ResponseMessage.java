package rs.ijz.server.poverenik.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "message"
})
@XmlRootElement(name = "ResponseMessage", namespace = "http://www.pijz.rs/response-message")
public class ResponseMessage {

    @XmlElement(name = "message")
    private String message;

    public ResponseMessage() {
    }

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
