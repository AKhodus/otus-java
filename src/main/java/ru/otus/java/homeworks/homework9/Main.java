package ru.otus.java.homeworks.homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //displayArrayElements(4, 7);
        //List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 7, 8, 9));
        //System.out.println(sumArrayElements(list));
        //rewriteArrayElements(1, list);
        //incrementArrayElements(5, list);
        List<Emloyee> emloyees = new ArrayList<>(Arrays.asList(new Emloyee("Ivan", 26), (new Emloyee("Petr", 30)), (new Emloyee("Sidor", 35)), (new Emloyee("Igor", 31))));
        //Emloyee.employeeList(emloyees);
        //System.out.println(Emloyee.employeeListAge(emloyees, 31));
        //System.out.println(Emloyee.employeeListAverageAge(emloyees,31));
        System.out.println(Emloyee.employeeListLink(emloyees));
    }

    public static void displayArrayElements(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        System.out.println(list);
    }

    public static int sumArrayElements(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            if (integer > 5) {
                sum += integer;
            }
        }
        return sum;
    }

    public static void rewriteArrayElements(int a, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.set(i, a);
            }
        }
        System.out.println(list);
    }

    public static void incrementArrayElements(int a, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int incr = list.get(i);
            incr += a;
            list.set(i, incr);
        }
        System.out.println(list);
    }
}
