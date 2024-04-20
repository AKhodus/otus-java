package ru.otus.java.homeworks.homework18;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transferFruitsToAnotherBox(Box<? super T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}