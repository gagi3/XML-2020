package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.model.zalba_odluka.ZalbaOdluka;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.ExchangeZalbaOdlukaRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.ExchangeZalbaOdlukaResponse;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.GetZalbaOdlukaRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.GetZalbaOdlukaResponse;

public class ZalbaOdlukaClient extends WebServiceGatewaySupport {
	
	private static String WSDL_URL = "http://localhost:8081/ws/zalba-odluka-soap.wsdl";

	private static String GET_REQUEST_CALLBACK = "http://www.pijz.rs/zalba-odluka/GetZalbaOdlukaRequest";
	private static String EXCHANGE_REQUEST_CALLBACK = "http://www.pijz.rs/zalba-odluka/ExchangeZalbaOdlukaRequest";

	public GetZalbaOdlukaResponse getZalbaOdluka(String id) {

		GetZalbaOdlukaRequest request = new GetZalbaOdlukaRequest();
		request.setId(id);

		GetZalbaOdlukaResponse response = (GetZalbaOdlukaResponse) getWebServiceTemplate()
				.marshalSendAndReceive(WSDL_URL, request, new SoapActionCallback(GET_REQUEST_CALLBACK));

		return response;
	}

	public ExchangeZalbaOdlukaResponse exchangeZalbaOdluka(ZalbaOdluka zalbaOdluka) {

		ExchangeZalbaOdlukaRequest request = new ExchangeZalbaOdlukaRequest();
		request.setZalbaOdluka(zalbaOdluka);

		ExchangeZalbaOdlukaResponse response = (ExchangeZalbaOdlukaResponse) getWebServiceTemplate()
				.marshalSendAndReceive(WSDL_URL, request, new SoapActionCallback(EXCHANGE_REQUEST_CALLBACK));

		return response;
	}

}
