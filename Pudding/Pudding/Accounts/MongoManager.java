package Pudding.Accounts;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientException;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoManager {
    private MongoCollection<Document> col;
    //Fix requests, open and close mongoDB
    public MongoManager() {
        try {
            final ConnectionString connString = new ConnectionString(
                    "mongodb+srv://Me:Thewonderwaffledg2@cluster0-gbadq.mongodb.net/test?retryWeerites=true&w=majority"
            );
            final MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .retryWrites(true)
                    .retryReads(true)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            MongoDatabase database = mongoClient.getDatabase("Pudding");
            this.col = database.getCollection("Profiles");
        } catch (MongoClientException exception) {
            exception.printStackTrace();
        }
    }
    public MongoCollection<Document> getCol() {
        return col;
    }
}
