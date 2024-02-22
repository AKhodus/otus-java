package ru.otus.java.homeworks.homework1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int number = 10;
        //  greetings();
        //   checkSign((int) (Math.random() * number), (int) (Math.random() * number), (int) (Math.random() * number));
        //   selectColor();
        //   compareNumbers();
        //  addOrSubtractAndPrint((int) (Math.random() * number), (int) (Math.random() * number),false);
        additionalTask();
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 21;
        if (data <= 10) {
            System.out.println("Красный");
        }
        if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        }
        if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 3;
        int b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

    public static void additionalTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число от 1 до 5");
        int result = scanner.nextInt();
        if (result == 1) {
            greetings();
        }
        if (result == 2) {
            checkSign(5, 6, 7);
        }
        if (result == 3) {
            selectColor();
        }
        if (result == 4) {
            compareNumbers();
        }
        if (result == 5) {
            addOrSubtractAndPrint(1, 2, false);
        }
    }
}