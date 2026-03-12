package homework1;

/**
 * Класс Хранимый материал
 * Наименование, агрегатное состояние (жидкое, сыпучее)
 * */
public class Material {
    private final String name;
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
