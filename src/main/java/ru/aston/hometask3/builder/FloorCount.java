package ru.aston.hometask3.builder;

public enum FloorCount {
    BUNGALOW(1, "Одноэтажный домик"),
    DUPLEX(2, "Двухэтажный дом"),
    MANSION(3, "Трехэтажный особняк");

    private final int value;
    private final String description;

    FloorCount(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
