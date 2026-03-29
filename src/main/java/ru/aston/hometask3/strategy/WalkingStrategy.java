package ru.aston.hometask3.strategy;

public class WalkingStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Пешком от " + start + " до " + end + ". Время: 60 мин.");
    }
}
