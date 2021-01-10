package rs.ijz.server.service;

public interface ResenjeService {
	
	String getMetadataRDF(String id) throws Exception;
    String getMetadataJSON(String id) throws Exception;

}
