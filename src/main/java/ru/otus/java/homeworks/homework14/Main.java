package ru.otus.java.homeworks.homework14;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        double[] array = Implementation1.createArray();
        long endTime = System.currentTimeMillis();
        int result = (int) (endTime - startTime);
        System.out.println("Execution time: " + result / 1000 + " sec");
        long startTime1 = System.currentTimeMillis();
        double[] array1 = Implementation2.createArray();
        long endTime1 = System.currentTimeMillis();
        int result1 = (int) (endTime1 - startTime1);
        System.out.println("Execution time: " + result1 / 1000 + " sec");
        System.out.println("Execution time difference: " + (result - result1) / 1000 + " sec");
    }
}