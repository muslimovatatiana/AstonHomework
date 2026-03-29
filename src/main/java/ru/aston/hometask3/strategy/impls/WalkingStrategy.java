package ru.aston.hometask3.strategy.impls;

import ru.aston.hometask3.strategy.RouteStrategy;

public class WalkingStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Пешком от " + start + " до " + end + ". Время: 60 мин.");
    }
}
