package ru.otus.java.homeworks.homework4;

public class MainApp {
    public static void main(String[] args) {
        //User user1 = new User("Alexander", "Khodus", "Sergeevich", 1996, "khas@arenadata.io");
        //user1.userInfo();
        //printUsersInfo();
        Box box1 = new Box(3, "Green");
        box1.open();
        box1.putInBox("Ball");
        box1.print();
        box1.putInBox("Pen");
        box1.print();
        box1.putInBox("Book");
        box1.print();
        box1.putInBox("Pencil");
        box1.print();
        box1.putInBox("Banana");
        box1.print();
        box1.count();
        box1.getFromBox("Ball");
        box1.print();
        box1.count();
    }

    public static void printUsersInfo() {
        int currentYear = 2024;
        int age = 0;
        User[] users = {
                new User("Alexander", "Khodus", "Sergeevich", 1996, "khas@arenadata.io"),
                new User("Petr", "Petrov", "Sergeevich", 1978, "otus@java.ru"),
                new User("Sidor", "Sidorov", "Sergeevich", 1991, "otus@java.ru"),
                new User("Ivan", "Ivanov", "Sergeevich", 1967, "otus@java.ru"),
                new User("Roman", "Zhuchkov", "Sergeevich", 1989, "otus@java.ru"),
                new User("Vasilii", "Vasichkin", "Sergeevich", 1984, "otus@java.ru"),
                new User("Dmitry", "Petichkin", "Sergeevich", 1987, "otus@java.ru"),
                new User("Vladimir", "Sharikov", "Sergeevich", 1992, "otus@java.ru"),
                new User("Pavel", "Ruchkin", "Sergeevich", 1969, "otus@java.ru"),
                new User("Konstantin", "Medvedev", "Sergeevich", 1964, "otus@java.ru")
        };
        for (int i = 0; i < users.length; i++) {
            if ((currentYear - users[i].getYearOfBirth()) > 40) {
                age = (currentYear - users[i].getYearOfBirth());
                users[i].userInfo();
                System.out.println("Возраст: " + age + " лет\n");
            }
        }
    }

}
