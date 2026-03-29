package ru.aston.hometask3.chain;

public class ErrorLogger extends Logger {
    @Override
    protected boolean shouldHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.err.println("|Error|: " + message);
    }
}
