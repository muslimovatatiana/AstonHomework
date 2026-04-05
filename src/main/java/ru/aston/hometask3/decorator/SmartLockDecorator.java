package ru.aston.hometask3.decorator;

public class SmartLockDecorator extends HouseDecorator {
    public SmartLockDecorator(Building h) { super(h); }
    public void describe() { super.describe(); System.out.print(" + Умный замок"); }
}
