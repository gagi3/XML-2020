package rs.pijz.server.sluzbenik.soap.client;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import rs.pijz.server.sluzbenik.soap.communication.zalba.SendZalbaSluzbenikRequest;
import rs.pijz.server.sluzbenik.soap.communication.zalba.SendZalbaSluzbenikResponse;

public class ZalbaClient extends WebServiceGatewaySupport {

	private static String WSDL_URL = "http://localhost:8082/ws/zalba-soap.wsdl";

	private static String SEND_REQUEST_CALLBACK = "http://www.pijz.rs/zalba/SendZalbaSluzbenikRequest";

	public SendZalbaSluzbenikResponse sendZalbaSluzbenik(String username, String zalbaID, XMLGregorianCalendar date, String poverenik, String xhtmlURL, String pdfURL) {

		SendZalbaSluzbenikRequest request = new SendZalbaSluzbenikRequest();
		request.setUsername(username);
		request.setZalbaID(zalbaID);
		request.setDate(date);
		request.setPoverenik(poverenik);
		request.setXhtmlURL(xhtmlURL);
		request.setPdfURL(pdfURL);

		SendZalbaSluzbenikResponse response = (SendZalbaSluzbenikResponse) getWebServiceTemplate().marshalSendAndReceive(WSDL_URL,
				request, new SoapActionCallback(SEND_REQUEST_CALLBACK));

		return response;
	}


}
