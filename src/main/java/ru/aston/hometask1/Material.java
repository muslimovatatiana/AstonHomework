package ru.aston.hometask1;

/**
 * Класс Хранимый материал
 */
public class Material {
    /**
    * Наименование материала, хранимого в бочке
    */
    private final String name;
    /**
     * Агрегатное состояние (жидкое, сыпучее)
     */
    private final String stateOfAggregation;

    public Material(String name, String stateOfAggregation) {
        this.name = name;
        this.stateOfAggregation = stateOfAggregation;
    }

    public Material(Material other) {
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
