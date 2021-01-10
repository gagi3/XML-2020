package rs.ijz.server.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DomParserService {

	public String readMultipartXMLFile(MultipartFile file) {
		String data = "";
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				bytes = file.getBytes();
				data = new String(bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return data;
	}

}
