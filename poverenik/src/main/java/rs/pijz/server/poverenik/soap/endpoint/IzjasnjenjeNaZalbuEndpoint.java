package rs.pijz.server.poverenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.poverenik.soap.communication.izjasnjenje_na_zalbu.GetIzjasnjenjeNaZalbuRequest;
import rs.pijz.server.poverenik.soap.communication.izjasnjenje_na_zalbu.GetIzjasnjenjeNaZalbuResponse;
import rs.pijz.server.poverenik.soap.repository.IzjasnjenjeNaZalbuRepositorySOAP;

@Endpoint
public class IzjasnjenjeNaZalbuEndpoint {
	
private static final String NAMESPACE_URI = "http://www.pijz.rs/izjasnjenje-na-zalbu";
	
	@Autowired
	private IzjasnjenjeNaZalbuRepositorySOAP izjasnjenjeNaZalbuRepositorySOAP;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIzjasnjenjeNaZalbuRequest")
	@ResponsePayload
	public GetIzjasnjenjeNaZalbuResponse getIzjasnjenjeNaZalbu(@RequestPayload GetIzjasnjenjeNaZalbuRequest request) {
		GetIzjasnjenjeNaZalbuResponse response = new GetIzjasnjenjeNaZalbuResponse();
		response.setIzjasnjenjeNaZalbu(izjasnjenjeNaZalbuRepositorySOAP.findIzjasnjenje(request.getBroj()));

		return response;
	}

}
