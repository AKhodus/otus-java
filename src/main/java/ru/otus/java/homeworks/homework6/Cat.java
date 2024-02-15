package ru.otus.java.homeworks.homework6;

public class Cat {
    private String name;
    private boolean fulness = false;

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

    public void eat(Plate plate1, int count) {
        if ((plate1.getCurrentFood() - count) >= 0) {
            plate1.setCurrentFood(plate1.getCurrentFood() - count);
            fulness = true;
            System.out.println(name + " поел");
        } else {
            System.out.println(name + " не будет есть, мало еды!");
        }
    }
}
