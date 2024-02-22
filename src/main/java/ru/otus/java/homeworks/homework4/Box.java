package ru.otus.java.homeworks.homework4;

/*Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
Коробку можно открывать и закрывать. Коробку можно перекрашивать. Изменить размер коробки после создания нельзя.
У коробки должен быть метод, печатающий информацию о ней в консоль.
В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть), только при условии что коробка открыта (предметом читаем просто строку).
Выполнение методов должно сопровождаться выводом сообщений в консоль.
 */

public class Box {
    private int size;
    private String color;
    String[] subjects = new String[5];
    String state = "Закрыто";

    public Box(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open() {
        state = "Открыто";
        System.out.println("Коробка открыта");
    }

    public void close() {
        state = "Закрыто";
        System.out.println("Коробка закрыта");
    }

    public void boxInfo() {

        System.out.println("Размер коробки: " + size + "\n" + "Цвет коробки: " + color);
    }

    public void putInBox(String item) {
        if (state.equals("Открыто")) {
            for (int i = 0; i < subjects.length; i++) {
                if (subjects[i] == null) {
                    subjects[i] = item;
                    System.out.println("В коробку добавлен предмет: " + item);
                    return;
                }
            }
        } else System.out.println("Нельзя положить предмет в закрытую коробку!");
    }

    public void count() {
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                count++;
            }
        }
        System.out.println("Количество предметов в коробке: " + count);
        return;
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                System.out.print(subjects[i] + " ");
            }
        }
        System.out.println("]");
    }

    public void getFromBox(String item) {
        if (state.equals("Открыто")) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == item) {
                subjects[i] = null;
                System.out.println("Из коробки взяли предмет: " + item);
            }
        }
    }
}
