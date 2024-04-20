package ru.otus.java.homeworks.homework20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // Создаем объект-монитор для синхронизации потоков
        Object monitor = new Object();

        threadPool.submit(new PrintTask('A', monitor, 5));
        threadPool.submit(new PrintTask('B', monitor, 5));
        threadPool.submit(new PrintTask('C', monitor, 5));

        threadPool.shutdown();
    }

    static class PrintTask implements Runnable {
        private char charToPrint;
        private Object monitor;
        private int times;

        public PrintTask(char charToPrint, Object monitor, int times) {
            this.charToPrint = charToPrint;
            this.monitor = monitor;
            this.times = times;
        }

        @Override
        public void run() {
            for (int i = 0; i < times; i++) {
                synchronized (monitor) {
                    try {
                        // Проверяем, если необходимо печатать текущий символ
                        while (charToPrint != 'A' && charToPrint != 'B' && charToPrint != 'C') {
                            monitor.wait();
                        }

                        // Печатаем символ и оповещаем другие потоки
                        System.out.print(charToPrint);
                        if (charToPrint == 'A') {
                            charToPrint = 'B';
                        } else if (charToPrint == 'B') {
                            charToPrint = 'C';
                        } else {
                            charToPrint = 'A';
                        }
                        monitor.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}