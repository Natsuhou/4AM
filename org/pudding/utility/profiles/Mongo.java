package org.pudding.utility.profiles;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientException;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.api.entities.User;
import org.bson.Document;

public class Mongo {
    private MongoCollection<Document> mongoCollection;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private final User user;
    private final String keyIdentifier;
    private final String currencyIdentifier;
    private final String bioIdentifier;
    private final String profileImageIdentifier;
    private Document doc;

    public Mongo(User user) {
        this.user = user;
        keyIdentifier = "discordId";
        currencyIdentifier = "currency";
        bioIdentifier = "description";
        profileImageIdentifier = "";
        try {
            final ConnectionString connString = new ConnectionString(
                    "mongodb+srv://Me:Thewonderwaffledg2@cluster0-gbadq.mongodb.net/test?retryWeerites=true&w=majority"
            );
            final MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .retryWrites(true)
                    .retryReads(true)
                    .build();
            mongoDatabase = mongoClient.getDatabase("Pudding");
            mongoCollection = mongoDatabase.getCollection("Profiles");
            mongoClient = MongoClients.create(settings);
        } catch (MongoClientException exception) {
            exception.printStackTrace();
        }
    }
    private boolean hasAccount() {
        BasicDBObject query = new BasicDBObject(keyIdentifier, user.getId());
        return mongoCollection.find(query).first() != null;
    }
    public void createAccount() {
        if (!hasAccount()) {
            doc = new Document()
                    .append(keyIdentifier, user.getId())
                    .append(bioIdentifier, "Change this with $cd (description)!")
                    .append(profileImageIdentifier, user.getAvatarUrl())
                    .append(currencyIdentifier, 0)
                    .append("likes", 0)
                    .append("verifiedStatus", 0);
            mongoCollection.insertOne(doc);
        }
        mongoClient.close();
    }
    public void deleteAccount() {
        if (hasAccount()) {
            BasicDBObject query = new BasicDBObject("discordId", user.getId());
            doc = mongoCollection.find(query).first();
            if (doc != null) {
                doc = mongoCollection.findOneAndDelete(query);
            }
        }
        mongoClient.close();
    }
    public void updateAccount() {
        if (hasAccount()) {

        }
    }
    public User getUser() {
        return user;
    }
    public void addCurrency(int amount) {

    }
    public void removeCurrency(int amount) {

    }
    public String getCurrency() {
        return getCurrency();
    }
    public void setBio() {

    }
    public String getBio() {
        return bioIdentifier;
    }
    public void setProfileImage() {

    }
    public String getprofileImage() {
        return profileImageIdentifier;
    }
}
