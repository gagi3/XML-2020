package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_cutanje.GetZalbaCutanjeResponse;

public class ZalbaCutanjeClient extends WebServiceGatewaySupport {
	
	public GetZalbaCutanjeResponse getZalbaCutanje(String broj) {

		GetZalbaCutanjeRequest request = new GetZalbaCutanjeRequest();
		request.setBroj(broj);

		System.out.println("Requesting [zalba-cutanje] for [broj]: " + broj);

		GetZalbaCutanjeResponse response = (GetZalbaCutanjeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/zalba-cutanje-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/zalba-cutanje/GetZalbaCutanjeRequest"));

		return response;
	}

}
