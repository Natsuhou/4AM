package pudding.Utility.enums;

public enum PuddingCategories {
    MAIN("626853630112432132"),
    PICS("627588486496780338"),
    LEADERBOARDS("745603474653315083");

    private final String categoryId;

    PuddingCategories(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public PuddingCategories getCategory(String categoryId) {
        for (PuddingCategories puddingCategories : PuddingCategories.values()) {
            if (puddingCategories.getCategoryId().equals(categoryId)) {
                return puddingCategories;
            }
        }
        return null;
    }
}
