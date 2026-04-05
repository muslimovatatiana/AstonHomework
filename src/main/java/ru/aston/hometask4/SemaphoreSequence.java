package ru.aston.hometask4;

import java.util.concurrent.Semaphore;

public class SemaphoreSequence {

    private final Semaphore sem1 = new Semaphore(1);
    private final Semaphore sem2 = new Semaphore(0);

    public static void main(String[] args) {
        SemaphoreSequence example = new SemaphoreSequence();

        new Thread(example::printOne, "Поток 1").start();
        new Thread(example::printTwo, "Поток 2").start();
    }

    public void printOne() {
        while (true) {
            try {
                sem1.acquire();

                System.out.print("1 ");
                Thread.sleep(300);

                sem2.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void printTwo() {
        while (true) {
            try {
                sem2.acquire();

                System.out.print("2 ");
                Thread.sleep(300);

                sem1.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
