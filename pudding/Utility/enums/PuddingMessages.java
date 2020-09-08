package pudding.Utility.enums;

public enum PuddingMessages {
    //Rules channel
    RULES(""),
    //Role selection channel
    GENDER(""),
    LOCATION(""),
    AGE(""),
    ETHNICITY(""),
    DATING_STATUS(""),
    DM("");


    private final String messageId;

    PuddingMessages(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public static PuddingMessages getMessage(String messageId) {
        for (PuddingMessages puddingMessages : PuddingMessages.values()) {
            if (puddingMessages != null) {
                if (puddingMessages.getMessageId().equals(messageId)) {
                    return puddingMessages;
                }
            }
        }
        return null;
    }
}
