package rs.pijz.server.poverenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.ExchangeZalbaCutanjeRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.ExchangeZalbaCutanjeResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeResponse;
import rs.pijz.server.poverenik.soap.repository.ZalbaCutanjeRepositorySOAP;

@Endpoint
public class ZalbaCutanjeEndpoint {

	private static final String NAMESPACE_URI = "http://www.pijz.rs/zalba-cutanje";

	@Autowired
	private ZalbaCutanjeRepositorySOAP zalbaCutanjeRepositorySOAP;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZalbaCutanjeRequest")
	@ResponsePayload
	public GetZalbaCutanjeResponse getZalbaCutanje(@RequestPayload GetZalbaCutanjeRequest request) throws Exception {
		GetZalbaCutanjeResponse response = new GetZalbaCutanjeResponse();
		response.setZalbaCutanje(zalbaCutanjeRepositorySOAP.getZalbaCutanje(request.getBroj()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "exchangeZalbaCutanjeRequest")
	@ResponsePayload
	public ExchangeZalbaCutanjeResponse exchangeZalbaCutanje(@RequestPayload ExchangeZalbaCutanjeRequest request)
			throws Exception {
		ExchangeZalbaCutanjeResponse response = new ExchangeZalbaCutanjeResponse();
		response.setStatus(zalbaCutanjeRepositorySOAP.exchangeZalbaCutanje(request.getZalbaCutanje()));

		return response;
	}

}
