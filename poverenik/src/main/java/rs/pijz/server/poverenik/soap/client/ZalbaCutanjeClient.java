package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.model.zalba_cutanje.ZalbaCutanje;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.ExchangeZalbaCutanjeRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.ExchangeZalbaCutanjeResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeResponse;

public class ZalbaCutanjeClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8081/ws/zalba-cutanje-soap.wsdl";

	private static String GET_REQUEST_CALLBACK = "http://www.pijz.rs/zalba-cutanje/GetZalbaCutanjeRequest";
	private static String EXCHANGE_REQUEST_CALLBACK = "http://www.pijz.rs/zalba-cutanje/ExchangeZalbaCutanjeRequest";

	public GetZalbaCutanjeResponse getZalbaCutanje(String id) {

		GetZalbaCutanjeRequest request = new GetZalbaCutanjeRequest();
		request.setId(id);

		GetZalbaCutanjeResponse response = (GetZalbaCutanjeResponse) getWebServiceTemplate()
				.marshalSendAndReceive(WSDL_URL, request, new SoapActionCallback(GET_REQUEST_CALLBACK));

		return response;
	}

	public ExchangeZalbaCutanjeResponse exchangeZalbaCutanje(ZalbaCutanje zalbaCutanje) {

		ExchangeZalbaCutanjeRequest request = new ExchangeZalbaCutanjeRequest();
		request.setZalbaCutanje(zalbaCutanje);

		ExchangeZalbaCutanjeResponse response = (ExchangeZalbaCutanjeResponse) getWebServiceTemplate()
				.marshalSendAndReceive(WSDL_URL, request, new SoapActionCallback(EXCHANGE_REQUEST_CALLBACK));

		return response;
	}

}
