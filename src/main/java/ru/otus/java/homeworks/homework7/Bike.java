package ru.otus.java.homeworks.homework7;

public class Bike implements Mover {
    @Override
    public void move(int distance, TerrainType terrainType) {
        if (terrainType.equals(TerrainType.SWAMP)) {
            System.out.println("Велосипед не пожет ехать по указанной местности!");
            return;
        }
        System.out.println("Велосипед поехал");
    }
}