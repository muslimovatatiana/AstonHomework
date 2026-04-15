package ru.aston.hometask4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        LivelockExample example = new LivelockExample();

        Thread t1 = new Thread(() -> example.doOperation(example.lock1, example.lock2), "Поток 1");
        Thread t2 = new Thread(() -> example.doOperation(example.lock2, example.lock1), "Поток 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private void doOperation(Lock primaryLock, Lock secondaryLock) {
        String threadName = Thread.currentThread().getName();

        while (true) {
            try {
                if (primaryLock.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println(threadName + ": Захватил основной замок, пытаюсь захватить второй.");
                    Thread.sleep(100);
                    if (secondaryLock.tryLock()) {
                        try {
                            System.out.println(threadName + ": Оба замка захвачены. Выполняю операцию.");
                            break;
                        } finally {
                            secondaryLock.unlock();
                        }
                    } else {
                        System.out.println(threadName + ": Не могу захватить второй замок, освобождаю основной.");
                        primaryLock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        primaryLock.unlock();
    }
}
