package ru.otus.java.homeworks.homework6;

public class Plate {
    private int maxFood;
    private int currentFood;

    public Plate(int maxFood, int currentFood) {
        this.maxFood = maxFood;
        this.currentFood = currentFood;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    public void info() {
        System.out.println("Объем тарелки: " + maxFood + ". Текущее количество еды в тарелке: " + currentFood);
    }

    public void fillPlate() {
        currentFood = maxFood;
        System.out.println("Тарелка заполнена едой. Количество: " + currentFood);
    }

    public void addFood(int count) {
        if ((currentFood + count) > maxFood) {
            System.out.println("Еда не поместится в тарелку!");
            return;
        } else {
            currentFood += count;
            System.out.println("Еда добавлена в тарелку");
        }
    }

    public void decreaseFood(int count) {
        boolean result;
        if ((currentFood - count) >= 0) {
            currentFood -= count;
            result = true;
            System.out.println(result);
        } else {
            result = false;
            System.out.println(result);
        }
    }
}

