package ru.otus.java.homeworks.homework9;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        displayArrayElements(4, 7);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 7, 8, 9));
        sumArrayElements(arrayList);
        //rewriteArrayElements(1, arrayList);
        //incrementArrayElements(5, arrayList);
        ArrayList<Emloyee> emloyees = new ArrayList<>(Arrays.asList(new Emloyee("Ivan", 25), (new Emloyee("Petr", 30)), (new Emloyee("Sidor", 35)), (new Emloyee("Igor", 31))));
        Emloyee.employeeList(emloyees);
        Emloyee.employeeListAge(emloyees, 31);
        Emloyee.employeeListAverageAge(emloyees, 30);
        Emloyee.employeeListLink(emloyees);
    }

    public static void displayArrayElements(int min, int max) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
    }

    public static void sumArrayElements(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            if (integer > 5) {
                sum += integer;
            }
        }
        System.out.println(sum);
    }

    public static void rewriteArrayElements(int a, ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null) {
                arrayList.set(i, a);
            }
        }
        System.out.println(arrayList);
    }

    public static void incrementArrayElements(int a, ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int incr = arrayList.get(i);
            incr += a;
            arrayList.set(i, incr);
        }
        System.out.println(arrayList);
    }
}
