package ru.otus.java.homeworks.homework7;

public class Car implements Mover {
    private int amountPetrol = 10;

    public int getAmountPetrol() {
        return amountPetrol;
    }

    @Override
    public void move(int distance, TerrainType terrainType) {
        if (terrainType.equals(TerrainType.FOREST) || terrainType.equals(TerrainType.SWAMP)) {
            System.out.println("Машина не может ехать по указанной местности!");
            return;
        }
        amountPetrol--;
        System.out.println("Машина поехала. Количество топлива: " + amountPetrol);
    }
}