package ru.aston.hometask3.decorator;

abstract class HouseDecorator implements Building {
    protected Building house;

    public HouseDecorator(Building house) {
        this.house = house;
    }

    public void describe() {
        house.describe();
    }
}
