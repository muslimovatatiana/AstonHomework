package ru.aston.hometask4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(() -> example.doOperation(example.lock1, example.lock2, "Первая операция"), "Поток 1");
        Thread t2 = new Thread(() -> example.doOperation(example.lock2, example.lock1, "Вторая операция"), "Поток 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private void doOperation(Lock firstLock, Lock secondLock, String opName) {
        firstLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": первый замок захвачен, жду второй...");
            Thread.sleep(100);
            secondLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": второй замок захвачен. Выполняю " + opName + " операцию.");
            } finally {
                secondLock.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            firstLock.unlock();
        }
    }
}
