package ru.otus.java.homeworks.homework20;

public class PrintTask implements Runnable {
    private Character character;
    private Object monitor;

    public PrintTask(Character character, Object monitor) {
        this.character = character;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                try {
                    while (!character.equals('A') && !character.equals('B') && !character.equals('C')) {
                        monitor.wait();
                    }

                    System.out.print(character);

                    if (character.equals('A')) {
                        character = 'B';
                    } else if (character.equals('B')) {
                        character = 'C';
                    } else {
                        character = 'A';
                    }

                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}