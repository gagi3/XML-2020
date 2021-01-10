package rs.ijz.server.service.impl;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import rs.ijz.server.repository.ResenjeRepository;
import rs.ijz.server.service.MetadataExtractorService;
import rs.ijz.server.service.ResenjeService;
import rs.ijz.server.util.FileReader;

@Service
public class ResenjeServiceImpl implements ResenjeService {
	
	@Value("${xslt.path.output-folder.resenje}")
    private String resenjeRDFXsltOutputFolderPath;
	
	@Autowired
	private ResenjeRepository resenjeRepository;
	
	@Autowired
    private MetadataExtractorService metadataExtractorService;

	@Override
	public String getMetadataRDF(String id) throws Exception {
		String xmlPublication = resenjeRepository.findById(id);

        if (xmlPublication == null) {
            throw new Exception("Resenje with ID " + id + " doesn't exist.");
        }

        String rdfFilePath = resenjeRDFXsltOutputFolderPath + id + ".rdf";
        String resultMetaFilePath = metadataExtractorService.extractMetadataToRdf(new FileInputStream(new File(rdfFilePath)), id);
        String result = FileReader.readFromFile(resultMetaFilePath);

        return result;

	}

	@Override
	public String getMetadataJSON(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
