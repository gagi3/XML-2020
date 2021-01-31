package rs.pijz.server.poverenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.poverenik.soap.repository.ZalbaOdlukaRepositorySOAP;
import rs.pijz.server.poverenik.soap.request.zalba_odluka.GetZalbaOdlukaRequest;
import rs.pijz.server.poverenik.soap.response.zalba_odluka.GetZalbaOdlukaResponse;

@Endpoint
public class ZalbaOdlukaEndpoint {
	
private static final String NAMESPACE_URI = "http://www.pijz.rs/zalba-odluka";
	
	@Autowired
	private ZalbaOdlukaRepositorySOAP zalbaOdlukaRepositorySOAP;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZalbaOdlukaRequest")
	@ResponsePayload
	public GetZalbaOdlukaResponse getZalbaOdluka(@RequestPayload GetZalbaOdlukaRequest request) {
		GetZalbaOdlukaResponse response = new GetZalbaOdlukaResponse();
		response.setZalbaOdluka(zalbaOdlukaRepositorySOAP.findZalbaOdluka(request.getBroj()));

		return response;
	}

}
