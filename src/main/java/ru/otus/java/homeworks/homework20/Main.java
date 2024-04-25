package ru.otus.java.homeworks.homework20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Object monitor = new Object();
        final int[] currentLetter = {0};
        Runnable taskA = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (currentLetter[0] != 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    currentLetter[0] = 1;
                    monitor.notifyAll();
                }
            }
        };

        Runnable taskB = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (currentLetter[0] != 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    currentLetter[0] = 2;
                    monitor.notifyAll();
                }
            }
        };

        Runnable taskC = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (currentLetter[0] != 2) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    currentLetter[0] = 0;
                    monitor.notifyAll();
                }
            }
        };

        executor.submit(taskA);
        executor.submit(taskB);
        executor.submit(taskC);
        executor.shutdown();
    }
}