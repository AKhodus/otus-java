package ru.otus.java.homeworks.homework9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Emloyee {
    public String name;
    public int age;

    public Emloyee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void employeeList(List<Emloyee> emloyeeList) {
        List<String> list = new ArrayList<>();
        for (Emloyee elem : emloyeeList) {
            list.add(elem.name);
        }
        System.out.println(list);
    }

    public static List<String> employeeListAge(List<Emloyee> emloyeeList, int minAge) {
        List<String> list = new ArrayList<>();
        for (Emloyee elem : emloyeeList) {
            if (elem.age >= minAge) {
                list.add(elem.name);
            }
        }
        return list;
    }

    public static boolean employeeListAverageAge(List<Emloyee> emloyeeList, int age) {
        int sumAge = 0;
        int averageAge;
        for (Emloyee elem : emloyeeList) {
            sumAge += elem.age;
        }
        averageAge = sumAge / emloyeeList.size();
        return averageAge >= age;
    }

    @Override
    public String toString() {
        return
                "name:" + name +
                        ", age:" + age;
    }

    public static Emloyee employeeListLink(List<Emloyee> emloyeeList) {
        List<Integer> arrayList = new ArrayList<>();
        for (Emloyee elem : emloyeeList) {
            arrayList.add(elem.age);
        }
        int minAge = Collections.min(arrayList);
        for (Emloyee elem : emloyeeList) {
            if (elem.age == minAge) {
                return elem;
            }
        }
        return null;
    }
}