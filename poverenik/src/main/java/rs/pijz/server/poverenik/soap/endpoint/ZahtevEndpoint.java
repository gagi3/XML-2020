package rs.pijz.server.poverenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.poverenik.soap.communication.zahtev.GetZahtevRequest;
import rs.pijz.server.poverenik.soap.communication.zahtev.GetZahtevResponse;
import rs.pijz.server.poverenik.soap.repository.ZahtevRepositorySOAP;

@Endpoint
public class ZahtevEndpoint {
	
private static final String NAMESPACE_URI = "http://www.pijz.rs/zahtev";
	
	@Autowired
	private ZahtevRepositorySOAP zahtevRepositorySOAP;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZahtevRequest")
	@ResponsePayload
	public GetZahtevResponse getZahtev(@RequestPayload GetZahtevRequest request) {
		GetZahtevResponse response = new GetZahtevResponse();
		response.setZahtev(zahtevRepositorySOAP.findZahtev(request.getId()));

		return response;
	}

}
