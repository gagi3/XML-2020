package rs.ijz.server.util;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;

import java.util.Arrays;

@Component
public class DatabaseConnection {
    public final String username = "admin";
    public final String password = "admin";
    public final String URI = "xmldb:exist://localhost:8899/exist/xmlrpc";
    public final String jenaURI = "http://localhost:3030";
    public Database database;

    public Collection getOrCreateCollection(String collectionURI) throws XMLDBException {
        return getOrCreateCollection(collectionURI, 0);
    }

    @SneakyThrows
    private Collection getOrCreateCollection(String collectionURI, Integer pathSegmentOffset) throws XMLDBException {
        System.out.println(Arrays.toString(DatabaseManager.getDatabases()));
        if (DatabaseManager.getDatabases().length == 0) {
            final String driver = "org.exist.xmldb.DatabaseImpl";

            // initialize database driver
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
        }
        System.out.println(Arrays.toString(DatabaseManager.getDatabases()));
        Collection collection = DatabaseManager.getCollection(URI + collectionURI, username, password);

        if (collection == null) {
            if (collectionURI.startsWith("/")) {
                collectionURI = collectionURI.substring(1);
            }
            String[] pathSegments = collectionURI.split("/");
            if (pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();
                for (int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/").append(pathSegments[i]);
                }
                Collection child = DatabaseManager.getCollection(URI + path, username, password);
                if (child == null) {
                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parent = DatabaseManager.getCollection(URI + parentPath, username, password);
                    CollectionManagementService collectionManagementService = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
                    collection = collectionManagementService.createCollection(pathSegments[pathSegmentOffset]);
                    collection.close();
                    parent.close();
                } else {
                    child.close();
                }
            }
            return getOrCreateCollection(collectionURI, ++pathSegmentOffset);
        } else {
            return collection;
        }
    }
}
