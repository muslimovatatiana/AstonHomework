package ru.aston.hometask3.builder;

public enum WallMaterial {
    BRICK("Кирпич"),
    WOOD("Дерево"),
    CONCRETE("Бетон"),
    GLASS("Стекло");

    private final String name;

    WallMaterial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
