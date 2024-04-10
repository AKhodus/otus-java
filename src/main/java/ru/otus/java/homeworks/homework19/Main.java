package ru.otus.java.homeworks.homework19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос имени файла у пользователя
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        // Запрос искомой последовательности у пользователя
        System.out.print("Введите искомую последовательность символов: ");
        String sequence = scanner.nextLine();

        // Подсчет количества вхождений и вывод результата
        try {
            int occurrences = countOccurrences(fileName, sequence);
            System.out.println("Количество вхождений: " + occurrences);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для подсчета вхождений указанной последовательности символов в файле
    private static int countOccurrences(String fileName, String sequence) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int count = 0;
            String line;
            // Считываем каждую строку из файла
            while ((line = reader.readLine()) != null) {
                // Подсчитываем вхождения искомой последовательности в строке
                int index = line.indexOf(sequence);
                while (index != -1) {
                    count++;
                    index = line.indexOf(sequence, index + 1);
                }
            }
            return count;
        }
    }
}