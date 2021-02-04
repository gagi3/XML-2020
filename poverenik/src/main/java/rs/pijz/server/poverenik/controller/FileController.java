package rs.pijz.server.poverenik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.pijz.server.poverenik.service.FileService;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping(value = "/download")
    private ResponseEntity<InputStreamResource> getOne(@RequestParam String filename) {
        try {
            InputStreamResource resource = fileService.getFile(filename);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            if (filename.endsWith("pdf")) {
                headers.setContentType(MediaType.parseMediaType("application/pdf"));
            } else if (filename.endsWith("html")) {
                headers.setContentType(MediaType.parseMediaType("application/html"));
            } else {
                throw new Exception("Pogresna ekstenzija!");
            }
//            headers.setContentLength(resource.getFile().getAbsoluteFile().length());
            headers.setContentDispositionFormData("attachment", filename);
            return ResponseEntity.ok().headers(headers).body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}
