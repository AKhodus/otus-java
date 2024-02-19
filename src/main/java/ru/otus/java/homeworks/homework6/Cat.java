package ru.otus.java.homeworks.homework6;

public class Cat {
    private String name;
    private boolean fulness;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getFulness() {
        return fulness;
    }

    public void info() {
        System.out.println("Сытость " + name + ": " + fulness);
    }

    public void eat(Plate plate, int count) {
        if ((plate.getCurrentFood() - count) >= 0) {
            plate.setCurrentFood(plate.getCurrentFood() - count);
            fulness = true;
            System.out.println(name + " поел");
        } else {
            System.out.println(name + " не будет есть, мало еды!");
        }
    }
}
