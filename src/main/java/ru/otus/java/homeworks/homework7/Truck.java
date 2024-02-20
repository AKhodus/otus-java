package ru.otus.java.homeworks.homework7;

public class Truck implements Mover {
    private int amountPetrol = 10;

    @Override
    public void move(int distance, TerrainType terrainType) {
        amountPetrol--;
        System.out.println("Вездеход поехал. Количество топлива: " + amountPetrol);
    }
}