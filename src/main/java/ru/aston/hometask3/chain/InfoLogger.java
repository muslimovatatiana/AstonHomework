package ru.aston.hometask3.chain;

public class InfoLogger extends Logger {
    @Override
    protected boolean shouldHandle(LogLevel level) {
        return level.getPriority() >= LogLevel.INFO.getPriority();
    }

    @Override
    protected void write(String message) {
        System.out.println("|Information|: " + message);
    }
}