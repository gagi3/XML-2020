package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.zalba_odluka.GetZalbaOdlukaRequest;
import rs.pijz.server.poverenik.soap.communication.zalba_odluka.GetZalbaOdlukaResponse;

public class ZalbaOdlukaClient extends WebServiceGatewaySupport {

	public GetZalbaOdlukaResponse getZalbaOdluka(String broj) {

		GetZalbaOdlukaRequest request = new GetZalbaOdlukaRequest();
		request.setBroj(broj);

		System.out.println("Requesting [zalba-odluka] for [broj]: " + broj);

		GetZalbaOdlukaResponse response = (GetZalbaOdlukaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/zalba-odluka-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/zalba-cutanje/GetZalbaOdlukaRequest"));

		return response;
	}

}
