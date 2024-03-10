package ru.otus.java.homeworks.homework12;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        TextFileEditor.listTextFiles();
        File selectedFile = TextFileEditor.selectFile();
        if (selectedFile != null) {
            TextFileEditor.readFile(selectedFile);
            TextFileEditor.appendToFile(selectedFile);
        }
    }
}