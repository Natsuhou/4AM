package Pudding.Accounts;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.bson.Document;

public class PuddingProfiles {
    private final MongoCollection<Document> col;
    private Document doc;
    private final User user;
    private final AccountHandling accountHandling;

    public PuddingProfiles(User u) {
        MongoManager mongoManager = new MongoManager();
        accountHandling = new AccountHandling(u);
        this.col = mongoManager.getCol();
        this.user = u;
    }
    public void addPoints(int amount) {
        accountHandling.createAccount();
        col.updateOne(
                new BasicDBObject("discordId", user.getId()),
                new BasicDBObject("$inc", new BasicDBObject("currency", amount))
        );
    }
    public int getLikes() {
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("likes"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("likes");
    }
    public int getPoints() {
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("currency"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("currency");
    }
    public void addLikes(int amount) {
        accountHandling.createAccount();
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        BasicDBObject updateQuery = new BasicDBObject("$inc", new BasicDBObject("likes", amount));
        col.updateOne(searchQuery, updateQuery);
    }
    public void removeLikes(int amount) {
        accountHandling.createAccount();
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        BasicDBObject updateQuery = new BasicDBObject("$min", new BasicDBObject("likes", amount));
        col.updateOne(searchQuery, updateQuery);
    }
    public void setDescription(String newDescription) {
        BasicDBObject updateQuery = new BasicDBObject("$set", new BasicDBObject("description", newDescription));
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        col.updateOne(searchQuery, updateQuery);
    }
    public int getFarmValue(User user, MessageChannel channel) {
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("farmValue"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("farmValue");
    }
    public int getTokens() {
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("tokens"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("tokens");
    }
    public String getDescription() {
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("description"),
                        Projections.excludeId()
                )
        ).first();
        assert doc != null;
        return doc.getString("description");
    }
}
