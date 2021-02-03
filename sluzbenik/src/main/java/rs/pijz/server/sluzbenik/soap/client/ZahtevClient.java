package rs.pijz.server.sluzbenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.sluzbenik.model.zahtev.Zahtev;
import rs.pijz.server.sluzbenik.soap.communication.zahtev.ExchangeZahtevRequest;
import rs.pijz.server.sluzbenik.soap.communication.zahtev.ExchangeZahtevResponse;
import rs.pijz.server.sluzbenik.soap.communication.zahtev.GetZahtevRequest;
import rs.pijz.server.sluzbenik.soap.communication.zahtev.GetZahtevResponse;

public class ZahtevClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8082/ws/zahtev-soap.wsdl";

	private static String GET_REQUEST_CALLBACK = "http://www.pijz.rs/zahtev/GetZahtevRequest";
	private static String EXCHANGE_REQUEST_CALLBACK = "http://www.pijz.rs/zahtev/ExchangeZahtevRequest";

	public GetZahtevResponse getZahtev(String id) {

		GetZahtevRequest request = new GetZahtevRequest();
		request.setId(id);

		GetZahtevResponse response = (GetZahtevResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(GET_REQUEST_CALLBACK));

		return response;
	}

	public ExchangeZahtevResponse exchangeZahtev(Zahtev zahtev) {

		ExchangeZahtevRequest request = new ExchangeZahtevRequest();
		request.setZahtev(zahtev);

		ExchangeZahtevResponse response = (ExchangeZahtevResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(EXCHANGE_REQUEST_CALLBACK));

		return response;
	}

}
