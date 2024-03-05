package ru.otus.java.homeworks.homework8;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "8", "7", "6"},
                {"9", "8", "7", "a"}
        };
        try {
            int count = checkArray(arr);
            System.out.println(count);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int checkArray(String[][] arr) throws AppArraySizeException, AppArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new AppArraySizeException("Некорректный размер массива!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new AppArraySizeException("Некорректный размер массива!");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Некорректное значение массива в ячейке ", i, j);
                }
            }
        }
        return count;
    }
}