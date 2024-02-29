package ru.otus.java.homeworks.homework8;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "8", "7", "6"},
                {"2", "4", "3", "2"}
        };
        try {
            try {
                int count = checkArray(arr);
                System.out.println(count);
            } catch (AppArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        } catch (AppArrayDataException e) {
            System.out.println("Некорректное значение массива в ячейке " + e.i + ":" + e.j);
        }
    }

    public static int checkArray(String[][] arr) throws AppArraySizeException, AppArrayDataException {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new AppArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}