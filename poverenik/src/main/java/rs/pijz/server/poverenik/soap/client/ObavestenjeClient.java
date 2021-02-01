package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.obavestenje.GetObavestenjeRequest;
import rs.pijz.server.poverenik.soap.communication.obavestenje.GetObavestenjeResponse;

public class ObavestenjeClient extends WebServiceGatewaySupport {

	public GetObavestenjeResponse getObavestenje(String broj) {

		GetObavestenjeRequest request = new GetObavestenjeRequest();
		request.setBroj(broj);

		System.out.println("Requesting [obavestenje] for [broj]: " + broj);

		GetObavestenjeResponse response = (GetObavestenjeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/obavestenje-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/obavestenje/GetObavestenjeRequest"));

		return response;
	}

}
