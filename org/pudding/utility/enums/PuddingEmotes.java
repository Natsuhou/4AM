package org.pudding.utility.enums;

/*
    All emotes should be in UTF-8
 */

import org.jetbrains.annotations.Nullable;

public enum PuddingEmotes {
    //Rules Menu
    RULES("✅"),
    //Genders
    MENU_GENDER("\uD83D\uDC64"), //Bust in Silhoutte
    MALE("\uD83C\uDF48"), //Banana
    FEMALE("\uD83C\uDF51"), //Peach
    NON_BINARY("\uD83C\uDF48"), //Melon
    GENDERFLUID("\uD83C\uDF4D"), //Pineapple
    TRANSGENDER("\uD83C\uDF52"), //Cherries
    OTHER_GENDER("\uD83C\uDF45"), //Tomato
    //Location
    MENU_LOCATION("\uD83C\uDF0E"), //Globe showing Americas
    //Age
    MENU_AGE("\uD83D\uDD1E"), //18 x sign
    AGE_18_21("\uD83D\uDC07"), //Rabbit
    AGE_22_26("\uD83D\uDC01"), //Mouse
    AGE_27_31("\uD83D\uDC10"), //Goat
    AGE_32_PLUS("\uD83D\uDC3F"), //Squirrel
    //DM Menu
    OPEN_DM("✔"), //Checkmark
    CLOSED_DM("❌"), //Cross mark
    ASK_TO_DM("❓"), //Question mark

    CHECKMARK("✅"),
    HEART_SPARKLE("\uD83D\uDC96");
    private final String emoteId;

    PuddingEmotes(String emoteId) {
        this.emoteId = emoteId;
    }

    public String getEmoteId() {
        return emoteId;
    }

    public static @Nullable PuddingEmotes getEmote(String emoteId) {
        for (PuddingEmotes puddingEmote : PuddingEmotes.values()) {
            if (puddingEmote != null) {
                if (puddingEmote.getEmoteId().equals(emoteId)) {
                    return puddingEmote;
                }
            }
        }
        return null;
    }
}
