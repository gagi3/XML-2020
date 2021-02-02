package rs.pijz.server.poverenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.poverenik.soap.communication.resenje.GetResenjeRequest;
import rs.pijz.server.poverenik.soap.communication.resenje.GetResenjeResponse;
import rs.pijz.server.poverenik.soap.repository.ResenjeRepositorySOAP;

@Endpoint
public class ResenjeEndpoint {
	
private static final String NAMESPACE_URI = "http://www.pijz.rs/resenje";
	
	@Autowired
	private ResenjeRepositorySOAP resenjeRepositorySOAP;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getResenjeRequest")
	@ResponsePayload
	public GetResenjeResponse getResenje(@RequestPayload GetResenjeRequest request) {
		GetResenjeResponse response = new GetResenjeResponse();
		response.setResenje(resenjeRepositorySOAP.findResenje(request.getBroj()));

		return response;
	}

}
