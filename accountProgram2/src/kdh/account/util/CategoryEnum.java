package kdh.account.util;

public enum CategoryEnum {
    FOOD("식사"),
    UTILITY("공과금"),
    TRANSPORT("교통비"),
    SALARY("월급"),
    BONUS("상여금");

    private final String label;

    CategoryEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
