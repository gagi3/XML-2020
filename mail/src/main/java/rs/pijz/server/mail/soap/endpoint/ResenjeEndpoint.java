package rs.pijz.server.mail.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.mail.soap.communication.resenje.SendResenjeGradjaninRequest;
import rs.pijz.server.mail.soap.communication.resenje.SendResenjeGradjaninResponse;
import rs.pijz.server.mail.soap.communication.resenje.SendResenjeSluzbenikRequest;
import rs.pijz.server.mail.soap.communication.resenje.SendResenjeSluzbenikResponse;
import rs.pijz.server.mail.soap.repository.ResenjeRepositorySOAP;

@Endpoint
public class ResenjeEndpoint {

	private static final String NAMESPACE_URI = "http://www.pijz.rs/resenje";

	@Autowired
	private ResenjeRepositorySOAP resenjeRepositorySOAP;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendResenjeGradjaninRequest")
	@ResponsePayload
	public SendResenjeGradjaninResponse sendResenjeGradjanin(@RequestPayload SendResenjeGradjaninRequest request)
			throws Exception {
		SendResenjeGradjaninResponse response = new SendResenjeGradjaninResponse();

		resenjeRepositorySOAP.sendResenjeGradjanin(request.getUsername(), request.getZalbaID(),
				request.getDate().toGregorianCalendar().getTime(), request.getPoverenik(), request.getXhtmlURL(),
				request.getPdfURL());

		response.setStatus(true);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendResenjeSluzbenikRequest")
	@ResponsePayload
	public SendResenjeSluzbenikResponse sendResenjeSluzbenik(@RequestPayload SendResenjeSluzbenikRequest request)
			throws Exception {
		SendResenjeSluzbenikResponse response = new SendResenjeSluzbenikResponse();

		resenjeRepositorySOAP.sendResenjeSluzbenik(request.getUsername(), request.getZalbaID(),
				request.getDate().toGregorianCalendar().getTime(), request.getPoverenik(), request.getXhtmlURL(),
				request.getPdfURL());

		response.setStatus(true);

		return response;
	}

}
