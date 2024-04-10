package ru.otus.java.homeworks.homework18;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем коробку для яблок
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple(0.2));
        appleBox.addFruit(new Apple(0.3));
        appleBox.addFruit(new Apple(0.25));

        // Создаем коробку для апельсинов
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(0.4));
        orangeBox.addFruit(new Orange(0.35));

        // Создаем еще одну коробку для яблок
        Box<Apple> anotherAppleBox = new Box<>();
        anotherAppleBox.addFruit(new Apple(0.28));
        anotherAppleBox.addFruit(new Apple(0.31));

        // Выводим вес коробок
        System.out.println("Weight of appleBox: " + appleBox.getWeight());
        System.out.println("Weight of orangeBox: " + orangeBox.getWeight());
        System.out.println("Weight of anotherAppleBox: " + anotherAppleBox.getWeight());

        // Сравниваем коробку для яблок с коробкой для апельсинов
        System.out.println("Are appleBox and orangeBox equal in weight? " + appleBox.compare(orangeBox));

        // Пересыпаем фрукты из одной коробки в другую
        appleBox.transferFruitsToAnotherBox(anotherAppleBox);

        // Выводим вес коробок после пересыпания
        System.out.println("Weight of appleBox after transfer: " + appleBox.getWeight());
        System.out.println("Weight of anotherAppleBox after transfer: " + anotherAppleBox.getWeight());
    }
}