package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.resenje.GetResenjeRequest;
import rs.pijz.server.poverenik.soap.communication.resenje.GetResenjeResponse;

public class ResenjeClient extends WebServiceGatewaySupport {

	public GetResenjeResponse getResenje(String broj) {

		GetResenjeRequest request = new GetResenjeRequest();
		request.setBroj(broj);

		System.out.println("Requesting [resenje] for [broj]: " + broj);

		GetResenjeResponse response = (GetResenjeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/resenje-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/obavestenje/GetResenjeRequest"));

		return response;
	}

}
