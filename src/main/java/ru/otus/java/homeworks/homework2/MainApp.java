package ru.otus.java.homeworks.homework2;

import java.util.Arrays;

import static java.lang.Integer.max;

public class MainApp {
    public static void main(String[] args) {
        textOutput(10, "Hello");
        sumArray(new int[]{1, 2, 6, 7, 8});
        int[] arr = {1, 3, 5, 6, 7, 8, 9};
        fillArray(4, arr);
        int[] arr1 = {1, 3, 5, 6, 2, 1, 9};
        incrementArray(5, arr1);
        halfSumArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static void textOutput(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }

    public static void fillArray(int number, int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = number;
        }
        System.out.println(Arrays.toString(arr1));

    }

    public static void incrementArray(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += number;
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void halfSumArray(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sum1 += arr[i];
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            sum2 += arr[i];
        }
        System.out.println(max(sum1, sum2));
    }
}