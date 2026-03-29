package ru.aston.hometask3.strategy;

public class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeRoute(String start, String end) {
        strategy.buildRoute(start, end);
    }
}

