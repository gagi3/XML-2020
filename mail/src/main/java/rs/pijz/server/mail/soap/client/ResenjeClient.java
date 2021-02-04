package rs.pijz.server.mail.soap.client;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.mail.soap.communication.resenje.SendResenjeGradjaninRequest;
import rs.pijz.server.mail.soap.communication.resenje.SendResenjeGradjaninResponse;
import rs.pijz.server.mail.soap.communication.resenje.SendResenjeSluzbenikRequest;
import rs.pijz.server.mail.soap.communication.resenje.SendResenjeSluzbenikResponse;

public class ResenjeClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8083/ws/resenje-soap.wsdl";

	private static String SEND_GRADJANIN_REQUEST_CALLBACK = "http://www.pijz.rs/resenje/SendResenjeGradjaninRequest";
	private static String SEND_SLUZBENIK_REQUEST_CALLBACK = "http://www.pijz.rs/resenje/SendResenjeSluzbenikRequest";

	public SendResenjeGradjaninResponse sendResenjeGradjaninResponse(String username, String zalbaID, XMLGregorianCalendar date, String poverenik, String xhtmlURL, String pdfURL) {

		SendResenjeGradjaninRequest request = new SendResenjeGradjaninRequest();
		request.setUsername(username);
		request.setZalbaID(zalbaID);
		request.setDate(date);
		request.setPoverenik(poverenik);
		request.setXhtmlURL(xhtmlURL);
		request.setPdfURL(pdfURL);

		SendResenjeGradjaninResponse response = (SendResenjeGradjaninResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(SEND_GRADJANIN_REQUEST_CALLBACK));

		return response;
	}
	
	public SendResenjeSluzbenikResponse sendResenjeSluzbenikResponse(String username, String zalbaID, XMLGregorianCalendar date, String poverenik, String xhtmlURL, String pdfURL) {

		SendResenjeSluzbenikRequest request = new SendResenjeSluzbenikRequest();
		request.setUsername(username);
		request.setZalbaID(zalbaID);
		request.setDate(date);
		request.setPoverenik(poverenik);
		request.setXhtmlURL(xhtmlURL);
		request.setPdfURL(pdfURL);

		SendResenjeSluzbenikResponse response = (SendResenjeSluzbenikResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(SEND_SLUZBENIK_REQUEST_CALLBACK));

		return response;
	}

}
