package rs.pijz.server.poverenik.fuseki;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.RDFNode;

public class FusekiReader {

	private static final String QUERY_FILEPATH = "src/main/resources/rq/resenje.rq";

	private FusekiReader() {
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	public static ArrayList<String> executeQuery(Map<String, String> params, String dataset) throws IOException {

		AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties(dataset);

		String sparqlQueryTemplate = readFile(QUERY_FILEPATH, StandardCharsets.UTF_8);
		String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate, params, "{{", "}}");

		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);
		ResultSet results = query.execSelect();

		String varName;
		RDFNode varValue;

		ArrayList<String> foundResults = new ArrayList<>();

		while (results.hasNext()) {
			QuerySolution querySolution = results.next();
			Iterator<String> variableBindings = querySolution.varNames();

			while (variableBindings.hasNext()) {
				varName = variableBindings.next();
				varValue = querySolution.get(varName);

				String value = varValue.toString();
				foundResults.add(value);
			}
		}

		ResultSetFormatter.outputAsXML(System.out, results);
		query.close();

		return foundResults;
	}

}
