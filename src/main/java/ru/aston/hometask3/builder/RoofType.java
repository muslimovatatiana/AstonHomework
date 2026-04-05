package ru.aston.hometask3.builder;

public enum RoofType {
    FLAT("Плоская"),
    GABLE("Двускатная"),
    MANSARD("Мансардная");

    private final String description;

    RoofType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
