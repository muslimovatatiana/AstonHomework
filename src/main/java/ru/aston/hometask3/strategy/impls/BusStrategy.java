package ru.aston.hometask3.strategy.impls;

import ru.aston.hometask3.strategy.RouteStrategy;

public class BusStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("На автобусе от " + start + " до " + end + ". Время: 30 мин. Ожидание: 5 мин.");
    }
}
