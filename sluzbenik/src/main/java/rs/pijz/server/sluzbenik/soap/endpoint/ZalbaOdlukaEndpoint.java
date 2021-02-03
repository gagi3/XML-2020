package rs.pijz.server.sluzbenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.sluzbenik.soap.communication.zalba_odluka.ExchangeZalbaOdlukaRequest;
import rs.pijz.server.sluzbenik.soap.communication.zalba_odluka.ExchangeZalbaOdlukaResponse;
import rs.pijz.server.sluzbenik.soap.communication.zalba_odluka.GetZalbaOdlukaRequest;
import rs.pijz.server.sluzbenik.soap.communication.zalba_odluka.GetZalbaOdlukaResponse;
import rs.pijz.server.sluzbenik.soap.repository.ZalbaOdlukaRepositorySOAP;

@Endpoint
public class ZalbaOdlukaEndpoint {

	private static final String NAMESPACE_URI = "http://www.pijz.rs/zalba-odluka";

	@Autowired
	private ZalbaOdlukaRepositorySOAP zalbaOdlukaRepositorySOAP;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZalbaOdlukaRequest")
	@ResponsePayload
	public GetZalbaOdlukaResponse getZalbaOdluka(@RequestPayload GetZalbaOdlukaRequest request) {
		GetZalbaOdlukaResponse response = new GetZalbaOdlukaResponse();
		response.setZalbaOdluka(zalbaOdlukaRepositorySOAP.getZalbaOdluka(request.getBroj()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "exchangeZalbaOdlukaRequest")
	@ResponsePayload
	public ExchangeZalbaOdlukaResponse exchangeZalbaCutanje(@RequestPayload ExchangeZalbaOdlukaRequest request)
			throws Exception {
		ExchangeZalbaOdlukaResponse response = new ExchangeZalbaOdlukaResponse();
		response.setStatus(zalbaOdlukaRepositorySOAP.exchangeZalbaOdluka(request.getZalbaOdluka()));

		return response;
	}

}
