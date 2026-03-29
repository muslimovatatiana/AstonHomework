package ru.aston.hometask3.strategy;

public class BicycleStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("На велосипеде от " + start + " до " + end + ". Время: 30 мин.");
    }
}
