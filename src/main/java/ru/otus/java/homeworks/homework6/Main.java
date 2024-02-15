package ru.otus.java.homeworks.homework6;

public class Main {
    public static void main(String[] args) {
        Plate plate1 = new Plate(100, 100);
        Cat[] cats = {
                new Cat("Barsik"),
                new Cat("Rizhik"),
                new Cat("Murzik")
        };
        //Cat cat1 = new Cat("Barsik");
        //plate1.fillPlate();
        //plate1.addFood(50);
        //plate1.info();
        //plate1.decreaseFood(50);
        //plate1.info();
        //cat1.eat(plate1,50);
        //cat1.info();
        //plate1.info();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate1, 50);
            cats[i].info();
            plate1.info();
        }
    }

}
