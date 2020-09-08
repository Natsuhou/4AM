package pudding.Utility.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import net.dv8tion.jda.api.entities.User;
import org.bson.Document;

public class AccountHandling {
    private final MongoCollection<Document> col;
    private Document doc;
    private final User user;

    public AccountHandling(User u) {
        MongoManager mongoManager = new MongoManager();
        this.col = mongoManager.getCol();
        this.user = u;
    }
    public void createAccount() {
        if (!hasAccount()) {
            doc = new Document()
                    .append("discordId", user.getId())
                    .append("description", "Change this with $cd (description)!")
                    .append("profileImg", user.getAvatarUrl())
                    .append("currency", 0)
                    .append("likes", 0)
                    .append("verifiedStatus", 0);
            col.insertOne(doc);
        }
    }
    private boolean hasAccount() {
        BasicDBObject query = new BasicDBObject("discordId", user.getId());
        doc = col.find(query).first();
        return doc != null;
    }
    public void deleteAccount() {
        BasicDBObject query = new BasicDBObject("discordId", user.getId());
        doc = col.find(query).first();
        if (doc != null) {
            doc = col.findOneAndDelete(query);
        }
    }
    public void updateAccount() {

    }
}
