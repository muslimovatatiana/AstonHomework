package ru.aston.hometask3.strategy;

import ru.aston.hometask3.strategy.impls.BicycleStrategy;
import ru.aston.hometask3.strategy.impls.BusStrategy;
import ru.aston.hometask3.strategy.impls.TaxiStrategy;
import ru.aston.hometask3.strategy.impls.WalkingStrategy;

import java.util.EnumMap;
import java.util.Map;

public class Navigator {
    private final Map<TransportType, RouteStrategy> strategies = new EnumMap<>(TransportType.class);

    public Navigator() {
        strategies.put(TransportType.WALKING, new WalkingStrategy());
        strategies.put(TransportType.BUS, new BusStrategy());
        strategies.put(TransportType.TAXI, new TaxiStrategy());
        strategies.put(TransportType.BICYCLE, new BicycleStrategy());
    }

    public void executeRoute(TransportType type, String start, String end) {
        RouteStrategy strategy = strategies.get(type);
        if (strategy != null) {
            strategy.buildRoute(start, end);
        } else {
            System.out.println("Стратегия для " + type + " не найдена.");
        }
    }
}
