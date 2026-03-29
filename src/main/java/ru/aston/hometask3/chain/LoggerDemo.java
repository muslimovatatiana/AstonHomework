package ru.aston.hometask3.chain;

public class LoggerDemo {
    public static void main(String[] args) {
        LogManager manager = new LogManager();

        System.out.println("\n--- Log: INFO ---");
        manager.process(LogLevel.INFO, "Система работает");

        System.out.println("\n--- Log: DEBUG ---");
        manager.process(LogLevel.DEBUG, "Переменная x = 10");

        System.out.println("\n--- Log: ERROR ---");
        manager.process(LogLevel.ERROR, "Критическая ошибка!");
    }
}
