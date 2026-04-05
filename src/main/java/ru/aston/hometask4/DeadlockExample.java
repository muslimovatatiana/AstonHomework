package ru.aston.hometask4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();

        new Thread(deadlockExample::operation1, "Поток 1").start();
        new Thread(deadlockExample::operation2, "Поток 2").start();
    }

    public void operation1() {
        lock1.lock();
        System.out.println("Поток 1: lock1 захвачен, ожидаю захвата lock2...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("Поток 1: lock2 захвачен.");
        System.out.println("Поток 1: Выполняю первую операцию.");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("Поток 2: lock2 захвачен, ожидаю захвата lock1...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        System.out.println("Поток 2: lock1 захвачен.");
        System.out.println("Поток 2: Выполняю вторую операцию.");

        lock1.unlock();
        lock2.unlock();
    }
}
