package ru.otus.java.homeworks.homework8;

public class AppArrayDataException extends Exception {
    public int i;
    public int j;

    public AppArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
