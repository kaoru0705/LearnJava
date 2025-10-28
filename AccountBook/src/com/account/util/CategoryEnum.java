package com.account.util;

public enum CategoryEnum {
    FOOD(1, "식사"),
    UTILITY(2, "공과금"),
    TRANSPORT(3, "교통비"),
    SALARY(4, "월급"),
    BONUS(5, "상여금");
    
    private final int code;
    private final String label;

    CategoryEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static CategoryEnum fromCode(int code) {
        for (CategoryEnum c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
}
