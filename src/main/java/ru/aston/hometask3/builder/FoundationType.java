package ru.aston.hometask3.builder;

public enum FoundationType {
    CONCRETE("Бетонный монолит"),
    WOODEN("Деревянные сваи"),
    STONE("Каменный фундамент");

    private final String description;

    FoundationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
