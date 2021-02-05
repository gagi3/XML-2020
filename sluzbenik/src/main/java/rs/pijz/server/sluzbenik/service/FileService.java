package rs.pijz.server.sluzbenik.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

@Service
public class FileService {
    private final String DIRECTORY = "src/main/resources/output/";
    public InputStreamResource getFile(String filename) throws Exception {
        String path = DIRECTORY + filename;
        File file = new File(path);
        if (!file.exists()) throw new Exception("Fajl ne postoji!");
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamResource resource = new InputStreamResource(inputStream);
        return resource;
    }
}
