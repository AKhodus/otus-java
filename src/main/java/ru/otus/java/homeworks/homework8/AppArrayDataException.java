package ru.otus.java.homeworks.homework8;

public class AppArrayDataException extends Exception {
    public int i;
    public int j;

    public AppArrayDataException(String message, int i, int j) {
        super("Некорректное значение массива в ячейке " + i + ":" + j);
        this.i = i;
        this.j = j;
    }
}
