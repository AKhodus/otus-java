package ru.otus.java.homeworks.homework6;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100, 100);
        Cat[] cats = {
                new Cat("Barsik"),
                new Cat("Rizhik"),
                new Cat("Murzik")
        };
        //Cat cat = new Cat("Barsik");
        //plate.fillPlate();
        //plate.addFood(50);
        //plate.info();
        //plate.decreaseFood(50);
        //plate.info();
        //cat.eat(plate1,50);
        //cat.info();
        //plate.info();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate, 50);
            cats[i].info();
            plate.info();
        }
    }

}
