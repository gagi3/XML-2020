package rs.pijz.server.sluzbenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.sluzbenik.model.izvestaj.Izvestaj;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.ExchangeIzvestajRequest;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.ExchangeIzvestajResponse;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.GetIzvestajRequest;
import rs.pijz.server.sluzbenik.soap.communication.izvestaj.GetIzvestajResponse;

public class IzvestajClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8081/ws/izvestaj-soap.wsdl";

	private static String GET_REQUEST_CALLBACK = "http://www.pijz.rs/izvestaj/GetIzvestajRequest";
	private static String EXCHANGE_REQUEST_CALLBACK = "http://www.pijz.rs/izvestaj/ExchangeIzvestajRequest";

	public GetIzvestajResponse getIzvestaj(String id) {

		GetIzvestajRequest request = new GetIzvestajRequest();
		request.setId(id);

		GetIzvestajResponse response = (GetIzvestajResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(GET_REQUEST_CALLBACK));

		return response;
	}

	public ExchangeIzvestajResponse exchangeIzvestaj(Izvestaj izvestaj) {

		ExchangeIzvestajRequest request = new ExchangeIzvestajRequest();
		request.setIzvestaj(izvestaj);

		ExchangeIzvestajResponse response = (ExchangeIzvestajResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(EXCHANGE_REQUEST_CALLBACK));

		return response;
	}

}
