package ru.otus.java.homeworks.homework20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        List<Character> characters = new ArrayList<>();
        characters.add('A');
        characters.add('B');
        characters.add('C');

        Object monitor = new Object();

        for (int i = 0; i < characters.size(); i++) {
            threadPool.submit(new PrintTask(characters.get(i), monitor));
        }

        threadPool.shutdown();
    }
}