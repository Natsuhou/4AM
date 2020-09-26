package org.pudding.utility.enums;

public enum PuddingMessages {
    //Rules channel
    RULES(""),
    //Role selection channel
    GENDER(""),
    LOCATION(""),
    AGE(""),
    ETHNICITY(""),
    DATING_STATUS(""),
    DM("753443849216458762");


    private final String messageId;

    PuddingMessages(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public static PuddingMessages getMessage(String messageId) {
        for (PuddingMessages PM : PuddingMessages.values()) {
            if (PM != null) {
                if (PM.getMessageId().equals(messageId)) {
                    return PM;
                }
            }
        }
        return null;
    }
}
