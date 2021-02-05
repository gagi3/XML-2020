package rs.pijz.server.sluzbenik.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    public String readXMLFile(InputStreamResource file) {
        String data = "";
        if (file.exists()) {
            byte[] bytes;
            try {
                bytes = file.getInputStream().readAllBytes();
                data = new String(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return data;
    }

}
