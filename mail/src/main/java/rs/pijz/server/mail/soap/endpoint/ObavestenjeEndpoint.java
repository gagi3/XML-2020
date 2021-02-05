package rs.pijz.server.mail.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.mail.soap.communication.obavestenje.SendObavestenjePoverenikRequest;
import rs.pijz.server.mail.soap.communication.obavestenje.SendObavestenjePoverenikResponse;
import rs.pijz.server.mail.soap.repository.ObavestenjeRepositorySOAP;

@Endpoint
public class ObavestenjeEndpoint {

	private static final String NAMESPACE_URI = "http://www.pijz.rs/obavestenje";

	@Autowired
	private ObavestenjeRepositorySOAP obavestenjeRepositorySOAP;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendObavestenjePoverenikRequest")
	@ResponsePayload
	public SendObavestenjePoverenikResponse sendObavestenjePoverenik(@RequestPayload SendObavestenjePoverenikRequest request) {
		SendObavestenjePoverenikResponse response = new SendObavestenjePoverenikResponse();

		obavestenjeRepositorySOAP.sendObavestenjePoverenik(request.getUsername(),
				request.getDate().toGregorianCalendar().getTime(), request.getSluzbenik(), request.getXhtmlURL(),
				request.getPdfURL());

		response.setStatus(true);

		return response;
	}

}
