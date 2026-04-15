package ru.aston.hometask4;

import java.util.concurrent.Semaphore;

public class SemaphoreSequence {

    private final Semaphore sem1 = new Semaphore(1);
    private final Semaphore sem2 = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        SemaphoreSequence example = new SemaphoreSequence();

        Thread t1 = new Thread(() -> example.runSequence(example.sem1, example.sem2, "1 "), "Поток 1");
        Thread t2 = new Thread(() -> example.runSequence(example.sem2, example.sem1, "2 "), "Поток 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private void runSequence(Semaphore currentSem, Semaphore nextSem, String textToPrint) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                currentSem.acquire();

                System.out.print(textToPrint);
                Thread.sleep(300);

                nextSem.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
