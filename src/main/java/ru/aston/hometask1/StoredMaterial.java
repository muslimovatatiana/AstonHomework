package ru.aston.hometask1;

public class StoredMaterial {
    private final String name;
    private final String stateOfAggregation;

    public StoredMaterial(String name, String stateOfAggregation) {
        this.name = name;
        this.stateOfAggregation = stateOfAggregation;
    }

    public StoredMaterial(StoredMaterial other) {
        this.name = other.name;
        this.stateOfAggregation = other.getStateOfAggregation();
    }

    public String getName() {
        return name;
    }

    public String getStateOfAggregation() {
        return stateOfAggregation;
    }
}
