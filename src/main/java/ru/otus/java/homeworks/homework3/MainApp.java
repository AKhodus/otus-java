package ru.otus.java.homeworks.homework3;


public class MainApp {
    public static void main(String[] args) {

        sumOfPositiveElements(new int[][]{{0, 2, 6}, {7, 8}});
        square(10);
        nullArray((new int[10][10]));
        findMax((new int[5][5]));
        sumArray((new int[3][3]));
    }


    public static void sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static void square(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void nullArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                if (i == j) {
                    array[i][j] = 0;
                }
                if (i + j == array.length - 1) {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findMax(int[][] array) {
        int maxValue = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
                if (maxValue < array[i][j]) {
                    maxValue = array[i][j];
                }
            }
            System.out.println();
        }
        System.out.println(maxValue);
    }

    public static void sumArray(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
                if (i == 1) {
                    sum += array[i][j];
                }
                if (array[i].length < 2) {
                    sum += -1;
                }
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}