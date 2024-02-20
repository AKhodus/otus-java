package ru.otus.java.homeworks.homework7;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Ivan", "");
        Car car = new Car();
        Horse horse = new Horse();
        Bike bike = new Bike();
        Truck truck = new Truck();
        car.move(1000, TerrainType.PLAIN);
        horse.move(1000, TerrainType.FOREST);
        bike.move(1000, TerrainType.FOREST);
        truck.move(1000, TerrainType.FOREST);
        human.getTransport(Transport.BIKE);
        human.leaveTransport();
        human.move(1000);
    }
}