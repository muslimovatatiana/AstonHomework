package ru.aston.hometask3.chain;

import ru.aston.hometask3.builder.House;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InspectionChain {
    private final List<Consumer<House>> checks = new ArrayList<>();

    public InspectionChain addStep(Consumer<House> check) {
        checks.add(check);
        return this;
    }

    public void process(House house) {
        System.out.println("--- Начинаем проверку дома: " + house.getAddress() + " ---");

        for (Consumer<House> check : checks) {
            if (!house.isSafe()) {
                System.out.println("Проверка прервана: дом признан небезопасным!");
                break;
            }
            check.accept(house);
        }

        if (house.isSafe()) {
            System.out.println("Дом успешно прошел все проверки.");
        }
    }
}
