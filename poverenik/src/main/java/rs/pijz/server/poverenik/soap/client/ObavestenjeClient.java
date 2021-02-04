package rs.pijz.server.poverenik.soap.client;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.poverenik.soap.communication.obavestenje.SendObavestenjePoverenikRequest;
import rs.pijz.server.poverenik.soap.communication.obavestenje.SendObavestenjePoverenikResponse;

public class ObavestenjeClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8081/ws/obavestenje-soap.wsdl";

	private static String SEND_REQUEST_CALLBACK = "http://www.pijz.rs/obavestenje/SendObavestenjePoverenikRequest";

	public SendObavestenjePoverenikResponse sendObavestenjePoverenik(String username, XMLGregorianCalendar date, String sluzbenik, String xhtmlURL, String pdfURL) {

		SendObavestenjePoverenikRequest request = new SendObavestenjePoverenikRequest();
		request.setUsername(username);
		request.setDate(date);
		request.setSluzbenik(sluzbenik);
		request.setXhtmlURL(xhtmlURL);
		request.setPdfURL(pdfURL);

		SendObavestenjePoverenikResponse response = (SendObavestenjePoverenikResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(SEND_REQUEST_CALLBACK));

		return response;
	}

}
