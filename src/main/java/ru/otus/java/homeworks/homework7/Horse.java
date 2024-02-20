package ru.otus.java.homeworks.homework7;

public class Horse implements Mover {
    private int stamina = 10;

    @Override
    public void move(int distance, TerrainType terrainType) {
        if (terrainType.equals(TerrainType.SWAMP)) {
            System.out.println("Лошадь не пожет бежать по указанной местности!");
            return;
        }
        stamina--;
        System.out.println("Лошадь побежала. Выносливость: " + stamina);
    }
}