package ru.otus.java.homeworks.homework14;

public class Implementation2 {
    public static double[] createArray() {
        double[] array = new double[100_000_000];
        int quarter = array.length / 4;
        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            int start = i * quarter;
            int end = (i + 1) * quarter;
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    array[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return array;
    }
}