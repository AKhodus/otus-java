package ru.otus.java.homeworks.homework9;

import java.util.ArrayList;
import java.util.Collections;

public class Emloyee {
    public String name;
    public int age;

    public Emloyee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void employeeList(ArrayList<Emloyee> emloyeeArrayList) {
        for (Emloyee elem : emloyeeArrayList) {
            System.out.println(elem.name);
        }
    }

    public static void employeeListAge(ArrayList<Emloyee> emloyeeArrayList, int minAge) {
        for (Emloyee elem : emloyeeArrayList) {
            if (elem.age >= minAge) {
                System.out.println(elem.name + " " + elem.age);
            }
        }
    }

    public static void employeeListAverageAge(ArrayList<Emloyee> emloyeeArrayList, int age) {
        int sumAge = 0;
        int averageAge;
        for (Emloyee elem : emloyeeArrayList) {
            sumAge += elem.age;
        }
        averageAge = sumAge / emloyeeArrayList.size();
        System.out.println(averageAge >= age);
    }

    public static void employeeListLink(ArrayList<Emloyee> emloyeeArrayList) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Emloyee elem : emloyeeArrayList) {
            arrayList.add(elem.age);
        }
        int minAge = Collections.min(arrayList);
        for (Emloyee elem : emloyeeArrayList) {
            if (elem.age == minAge) {
                System.out.println(elem.name);
            }
        }
    }
}
