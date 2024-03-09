package ru.otus.java.homeworks.homework12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileEditor {
    public static void textFile() {
        String rootPath = System.getProperty("user.dir");
        File rootDir = new File(rootPath);
        File[] files = rootDir.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            System.out.println("Список текстовых файлов в корневом каталоге проекта:");
            for (File file : files) {
                System.out.println(file.getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя файла, с которым хотите работать: ");
            String fileName = scanner.nextLine();

            File selectedFile = new File(rootPath, fileName);

            if (!selectedFile.exists()) {
                System.out.println("Файл не найден.");
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    System.out.println("Содержимое файла:");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    System.out.print("Введите строку для записи в файл: ");
                    String content = scanner.nextLine();

                    try (FileWriter writer = new FileWriter(selectedFile, true)) {
                        content += "\n";
                        writer.write(content);
                        System.out.println("Строка успешно записана в файл.");
                    } catch (IOException e) {
                        System.out.println("Ошибка записи в файл: " + e.getMessage());
                    }

                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                }
            }
        } else {
            System.out.println("В корневом каталоге проекта нет текстовых файлов.");
        }
    }
}