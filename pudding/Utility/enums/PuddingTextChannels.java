package pudding.Utility.enums;

/*
    Below are all the channel IDs.
 */
public enum PuddingTextChannels {
    BOT_COMMANDS("630996665339215884"),
    ROLES ("676708702874763274"),
    RULES ("677085736624848899"),
    VERIFY ("676108509120823326"),
    MALE_SELFIES("627619089766023188"),
    FEMALE_SELFIES("627619138340257795"),
    NBNG_SELFIES("630995990668771328"),
    STAFF_QUEUE("723001448153219114");

    private final String textChannelId;

    PuddingTextChannels(String channelId) {
        this.textChannelId = channelId;
    }

    public String getTextChannelId() {
        return textChannelId;
    }

   public static PuddingTextChannels getTextChannel(String textChannelId) {
        for (PuddingTextChannels channel : PuddingTextChannels.values()) {
            if (channel != null) {
                if (channel.getTextChannelId().equals(textChannelId)) {
                    return channel;
                }
            }
        }
        return null;
   }

}
