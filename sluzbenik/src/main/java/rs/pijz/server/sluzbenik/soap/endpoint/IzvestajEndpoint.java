package rs.pijz.server.sluzbenik.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.sluzbenik.soap.communication.izvestaj.ExchangeIzvestajRequest;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.ExchangeIzvestajResponse;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.GetIzvestajRequest;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.GetIzvestajResponse;
import rs.pijz.server.sluzbenik.soap.repository.IzvestajRepositorySOAP;

@Endpoint
public class IzvestajEndpoint {

	private static final String NAMESPACE_URI = "http://www.pijz.rs/izvestaj";

	@Autowired
	private IzvestajRepositorySOAP izvestajRepositorySOAP;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIzvestajRequest")
	@ResponsePayload
	public GetIzvestajResponse getIzvestaj(@RequestPayload GetIzvestajRequest request) throws Exception {
		GetIzvestajResponse response = new GetIzvestajResponse();
		response.setIzvestaj(izvestajRepositorySOAP.getIzvestaj(request.getId()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "exchangeIzvestajRequest")
	@ResponsePayload
	public ExchangeIzvestajResponse exchangeIzvestaj(@RequestPayload ExchangeIzvestajRequest request) throws Exception {
		ExchangeIzvestajResponse response = new ExchangeIzvestajResponse();
		response.setStatus(izvestajRepositorySOAP.exchangeIzvestaj(request.getIzvestaj()));

		return response;
	}

}
