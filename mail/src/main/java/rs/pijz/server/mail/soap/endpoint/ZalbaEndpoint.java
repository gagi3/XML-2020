package rs.pijz.server.mail.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rs.pijz.server.mail.soap.communication.zalba.SendZalbaSluzbenikRequest;
import rs.pijz.server.mail.soap.communication.zalba.SendZalbaSluzbenikResponse;
import rs.pijz.server.mail.soap.repository.ZalbaRepositorySOAP;

@Endpoint
public class ZalbaEndpoint {

	private static final String NAMESPACE_URI = "http://www.pijz.rs/zalba";

	@Autowired
	private ZalbaRepositorySOAP zalbaRepositorySOAP;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendZalbaSluzbenikRequest")
	@ResponsePayload
	public SendZalbaSluzbenikResponse sendZalbaSluzbenik(@RequestPayload SendZalbaSluzbenikRequest request)
			throws Exception {
		SendZalbaSluzbenikResponse response = new SendZalbaSluzbenikResponse();

		zalbaRepositorySOAP.sendZalbaSluzbenik(request.getUsername(), request.getZalbaID(),
				request.getDate().toGregorianCalendar().getTime(), request.getPoverenik(), request.getXhtmlURL(),
				request.getPdfURL());

		response.setStatus(true);

		return response;
	}

}
