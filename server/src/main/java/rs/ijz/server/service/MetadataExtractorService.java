package rs.ijz.server.service;

import java.io.InputStream;

public interface MetadataExtractorService {

	String extractMetadataToRdf(InputStream in, String id) throws Exception;
    String extractMetadataToRdf(String xmlData) throws Exception;
    
    String extractMetadataToJson(String xmlData) throws Exception;
    
}
