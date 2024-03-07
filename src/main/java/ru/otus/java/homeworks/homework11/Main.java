package ru.otus.java.homeworks.homework11;

public class Main {
    public static void main(String[] args) {
       /* PersonDataBase personDataBase = new PersonDataBase();
        personDataBase.add(new Person("Ivan",Position.MANAGER, 1L));
        personDataBase.add(new Person("Petr",Position.DIRECTOR, 2L));
        personDataBase.add(new Person("Sidor",Position.SENIOR_MANAGER, 3L));
        personDataBase.add(new Person("Vasiliy",Position.DRIVER, 4L));
        personDataBase.add(new Person("Sergei",Position.ENGINEER, 5L));
        System.out.println(personDataBase.findById(2L));
        System.out.println(personDataBase.isManager(new Person("Vasiliy",Position.DRIVER, 4L)));
        System.out.println(personDataBase.isEmployee(4L));*/
        int[] array = {64, 32, 16, 8, 4, 2, 1};
        Sort.bubbleSort(array);
    }
}