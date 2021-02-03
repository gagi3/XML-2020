package rs.pijz.server.sluzbenik.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.sluzbenik.model.obavestenje.Obavestenje;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.ExchangeObavestenjeRequest;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.ExchangeObavestenjeResponse;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.GetObavestenjeRequest;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.GetObavestenjeResponse;

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
	
	public ExchangeObavestenjeResponse exchangeObavestenje(Obavestenje obavestenje) {

		ExchangeObavestenjeRequest request = new ExchangeObavestenjeRequest();
		request.setObavestenje(obavestenje);

		System.out.println("Sending [obavestenje]: " + obavestenje.getBroj());

		ExchangeObavestenjeResponse response = (ExchangeObavestenjeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/obavestenje-soap.wsdl", request,
				new SoapActionCallback("http://www.pijz.rs/obavestenje/ExchangeObavestenjeRequest"));

		return response;
	}

}
