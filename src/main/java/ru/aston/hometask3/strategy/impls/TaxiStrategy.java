package ru.aston.hometask3.strategy.impls;

import ru.aston.hometask3.strategy.RouteStrategy;

public class TaxiStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("На такси от " + start + " до " + end + ". Цена: 800 руб. Время: 20 мин. Ожидание: 5 мин.");
    }
}
