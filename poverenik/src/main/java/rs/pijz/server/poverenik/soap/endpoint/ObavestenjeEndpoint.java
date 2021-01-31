package rs.pijz.server.poverenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.poverenik.soap.communication.obavestenje.GetObavestenjeRequest;
import rs.pijz.server.poverenik.soap.communication.obavestenje.GetObavestenjeResponse;
import rs.pijz.server.poverenik.soap.repository.ObavestenjeRepositorySOAP;

@Endpoint
public class ObavestenjeEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.pijz.rs/obavestenje";
	
	@Autowired
	private ObavestenjeRepositorySOAP obavestenjeRepositorySOAP;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getObavestenjeRequest")
	@ResponsePayload
	public GetObavestenjeResponse getObavestenje(@RequestPayload GetObavestenjeRequest request) {
		GetObavestenjeResponse response = new GetObavestenjeResponse();
		response.setObavestenje(obavestenjeRepositorySOAP.findObavestenje(request.getBroj()));

		return response;
	}

}
