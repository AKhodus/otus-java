package ru.otus.java.homeworks.homework8;

public class AppArraySizeException extends Exception {
    public AppArraySizeException(String message) {
        super("Некорректный размер массива!");
    }
}

