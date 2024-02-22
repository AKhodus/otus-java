package ru.otus.java.homeworks.homework7;

public class Human {
    private String name;
    private String currentTransport;

    public Human(String name, String currentTransport) {
        this.name = name;
        this.currentTransport = currentTransport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(String currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void getTransport(Transport transport) {
        currentTransport = String.valueOf(transport);
        System.out.println(name + " сел на " + transport + ". Текущий транспорт: " + currentTransport);
    }

    public void leaveTransport() {
        System.out.print(name + " встал с " + currentTransport);
        currentTransport = null;
        System.out.println(". Текущий транспорт: " + currentTransport);
    }

    public void move(int distance) {
        if (currentTransport != null) {
            System.out.println(name + " переместился на " + distance + "м используя " + currentTransport);
        } else {
            System.out.println(name + " переместился на " + distance + "м пешком");
        }
    }
}
