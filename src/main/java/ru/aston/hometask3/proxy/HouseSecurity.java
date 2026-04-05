package ru.aston.hometask3.proxy;

public class HouseSecurity implements SecuritySystem {
    public void unlock() {
        System.out.println("Дом открыт.");
    }
}
