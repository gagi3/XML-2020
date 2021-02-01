package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.zahtev.GetZahtevRequest;
import rs.pijz.server.poverenik.soap.communication.zahtev.GetZahtevResponse;

public class ZahtevClient extends WebServiceGatewaySupport {
	
	public GetZahtevResponse getZahtev(String id) {

		GetZahtevRequest request = new GetZahtevRequest();
		request.setId(id);

		System.out.println("Requesting [zahtev] for [id]: " + id);

		GetZahtevResponse response = (GetZahtevResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/zahtev-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/zahtev/GetZahtevRequest"));

		return response;
	}

}
