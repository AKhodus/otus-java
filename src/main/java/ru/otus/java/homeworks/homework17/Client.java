package ru.otus.java.homeworks.homework17;

import java.io.*;
import java.net.*;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket(HOST, PORT);
        System.out.println("Connected to server on port " + PORT);

        // Получаем имя клиента и роль
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String clientName = in.readLine();
        System.out.print("Enter your role (USER/ADMIN): ");
        String role = in.readLine();

        // Отправляем имя клиента и роль на сервер
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(clientName + " " + role);

        // Создаем новый поток для обработки сообщений с сервера
        ClientReceiver receiver = new ClientReceiver(clientSocket);
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();

        // Цикл отправки сообщений
        while (true) {
            String message = in.readLine();
            if (message == null) {
                break;
            }

            // Проверяем, является ли сообщение личным сообщением
            if (message.startsWith("/w ")) {
                String[] parts = message.split(" ");
                String recipient = parts[1];
                String privateMessage = message.substring(3 + recipient.length());

                // Отправляем личное сообщение на сервер
                out.println("/w " + recipient + " " + privateMessage);
            } else {
                // Отправляем сообщение на сервер
                out.println(message);
            }
        }

        // Закрываем соединение
        clientSocket.close();
    }

    private static class ClientReceiver implements Runnable {

        private Socket clientSocket;

        public ClientReceiver(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Получаем сообщения с сервера
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}