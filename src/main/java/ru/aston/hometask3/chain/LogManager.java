package ru.aston.hometask3.chain;

import java.util.Arrays;
import java.util.List;

public class LogManager {
    private final List<Logger> handlers = Arrays.asList(
            new InfoLogger(),
            new DebugLogger(),
            new ErrorLogger()
    );

    public void process(LogLevel level, String message) {
        handlers.stream()
                .filter(h -> h.shouldHandle(level))
                .forEach(h -> h.write(message));
    }
}