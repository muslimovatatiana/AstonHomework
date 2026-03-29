package ru.aston.hometask3.builder;

public enum WallMaterial {
    BRICK("Кирпич"),
    WOOD("Дерево"),
    CONCRETE("Бетон");

    private final String name;

    WallMaterial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
