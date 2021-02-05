package rs.pijz.server.sluzbenik.soap.client;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.sluzbenik.soap.communication.obavestenje.SendObavestenjePoverenikRequest;
import rs.pijz.server.sluzbenik.soap.communication.obavestenje.SendObavestenjePoverenikResponse;

public class ObavestenjeClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8083/ws/obavestenje-soap.wsdl";

	private static String SEND_REQUEST_CALLBACK = "http://www.pijz.rs/obavestenje/SendObavestenjePoverenikRequest";

	public SendObavestenjePoverenikResponse sendObavestenjePoverenik(String username, XMLGregorianCalendar date, String sluzbenik, String xhtmlURL, String pdfURL) {

		SendObavestenjePoverenikRequest request = new SendObavestenjePoverenikRequest();
		request.setUsername(username);
		request.setDate(date);
		request.setSluzbenik(sluzbenik);
		request.setXhtmlURL(xhtmlURL);
		request.setPdfURL(pdfURL);
		
		System.out.println(username);
		System.out.println(date);
		System.out.println(sluzbenik);
		System.out.println(xhtmlURL);
		System.out.println(pdfURL);

		SendObavestenjePoverenikResponse response = (SendObavestenjePoverenikResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(SEND_REQUEST_CALLBACK));
		
		System.out.println(response);

		return response;
	}

}
