package ru.aston.hometask3.strategy;

public class NavigatorDemo {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.setStrategy((start, end) ->
                System.out.println("Пешком от " + start + " до " + end + ". Время в пути: 60 мин."));
        navigator.executeRoute("Дом", "Работа");

        navigator.setStrategy((start, end) ->
                System.out.println("На автобусе от " + start + " до " + end + ". Ожидание: 5 мин. Время в пути: 20 мин."));
        navigator.executeRoute("Дом", "Работа");

        navigator.setStrategy((start, end) -> System.out.println("На велосипеде от " + start + " до " + end + ". Время в пути: 30 мин."));
        navigator.executeRoute("Дом", "Работа");

        navigator.setStrategy((start, end) -> {
            int price = 800;
            System.out.println("Такси от " + start + " до " + end + ". Ожидание: 5 мин. Стоимость: " + price + " руб." + " Время в пути: 15 мин.");
        });
        navigator.executeRoute("Дом", "Работа");
    }

}
