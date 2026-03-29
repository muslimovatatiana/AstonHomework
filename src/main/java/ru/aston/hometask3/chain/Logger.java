package ru.aston.hometask3.chain;

public abstract class Logger {
    protected abstract boolean shouldHandle(LogLevel level);

    protected abstract void write(String message);
}


