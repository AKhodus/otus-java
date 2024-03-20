package ru.otus.java.homeworks.homework14;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //double[] array = Implementation1.createArray();
        double[] array = Implementation2.createArray();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) / 1000 + " sec");
    }
}