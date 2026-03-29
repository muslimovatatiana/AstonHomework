package ru.aston.hometask3.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.executeRoute(TransportType.WALKING, "Дом", "Работа");
        navigator.executeRoute(TransportType.TAXI, "Дом", "Работа");
        navigator.executeRoute(TransportType.BUS, "Работа", "Работа");
        navigator.executeRoute(TransportType.BICYCLE, "Дом", "Работа");
    }
}
