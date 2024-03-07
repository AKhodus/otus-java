package ru.otus.java.homeworks.homework10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "123456789");
        phoneBook.add("Петров", "987654321");
        phoneBook.add("Иванов", "567891234");

        List<String> list = phoneBook.find("Иванов");
        System.out.println(list);

        boolean result = phoneBook.containsPhoneNumber("987654321");
        System.out.println("Наличие номера телефона: " + result);
    }
}
