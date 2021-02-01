package rs.pijz.server.poverenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.izjasnjenje_na_zalbu.GetIzjasnjenjeNaZalbuRequest;
import rs.pijz.server.poverenik.soap.communication.izjasnjenje_na_zalbu.GetIzjasnjenjeNaZalbuResponse;

public class IzjasnjenjeNaZalbuClient extends WebServiceGatewaySupport {

	public GetIzjasnjenjeNaZalbuResponse getIzjasnjenjeNaZalbu(String broj) {

		GetIzjasnjenjeNaZalbuRequest request = new GetIzjasnjenjeNaZalbuRequest();
		request.setBroj(broj);

		System.out.println("Requesting [izjasnjenje-na-zalbu] for [broj]: " + broj);

		GetIzjasnjenjeNaZalbuResponse response = (GetIzjasnjenjeNaZalbuResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/izjasnjenje-na-zalby-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/izjasnjenje-na-zalbu/GetIzjasnjenjeNaZalbuRequest"));

		return response;
	}

}
