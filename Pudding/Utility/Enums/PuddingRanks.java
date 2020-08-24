package Pudding.Utility.Enums;

public enum PuddingRanks {
    FOUNDER ("679056812229787699", 10),
    ADMIN ("626855987046776841", 9),
    VIP ("670375280686137373", 8),
    MODERATOR ("627639688592883733", 7),
    HELPER ("627639889432936459", 6),
    PUDDING ("741203611433959456", 5),
    PREMIUM_III ("741205623819206728", 4),
    PREMIUM_II ("630838747222638646", 3),
    PREMIUM_I ("741203629951942737", 2),
    MEMBER ("627639516303327242", 1),
    VERIFIED ("627606457030017026", 1),
    TEMP_MEMBER ("677086321780588554", 0),
    WARNING("745421603319447583", 0);

    private final String rankId;
    private final int rankWeight;

    PuddingRanks(String id, int weight) {
        this.rankId = id;
        this.rankWeight = weight;
    }

    public String getRankId() {
        return rankId;
    }

    public int getRankWeight() {
        return rankWeight;
    }

    public static PuddingRanks getRank(String rankId) {
        for (PuddingRanks roles : PuddingRanks.values()) {
            if (roles.getRankId().equals(rankId)) {
                return roles;
            }
        }
        return null;
    }
}
