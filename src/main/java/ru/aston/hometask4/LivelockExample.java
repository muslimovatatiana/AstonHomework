package ru.aston.hometask4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LivelockExample livelockExample = new LivelockExample();

        new Thread(livelockExample::operation1, "Поток 1").start();
        new Thread(livelockExample::operation2, "Поток 2").start();
    }

    public void operation1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Поток 1: Захватил lock1, пытаюсь захватить lock2.");

                Thread.sleep(100);

                if (lock2.tryLock()) {
                    System.out.println("Поток 1: Захватил lock2.");
                } else {
                    System.out.println("Поток 1: Не могу захватить lock2, освобождаю lock1.");
                    lock1.unlock();
                    continue;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Поток 1: Выполняю операцию.");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Поток 2: Захватил lock2, пытаюсь захватить lock1.");

                Thread.sleep(100);

                if (lock1.tryLock()) {
                    System.out.println("Поток 2: Захватил lock1.");
                } else {
                    System.out.println("Поток 2: Не могу захватить lock1, освобождаю lock2.");
                    lock2.unlock();
                    continue;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Поток 2: Выполняю операцию.");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
