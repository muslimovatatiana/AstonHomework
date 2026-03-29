package ru.aston.hometask3.chain;

public class DebugLogger extends Logger {
    @Override
    protected boolean shouldHandle(LogLevel level) {
        return level == LogLevel.DEBUG || level == LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG]: Подробности: " + message);
    }
}
