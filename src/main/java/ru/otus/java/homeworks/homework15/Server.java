package ru.otus.java.homeworks.homework15;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int PORT = 1234;
    private static Map<String, Socket> clients = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Создаем новый поток для обработки каждого клиента
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private String clientName;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Получаем имя клиента
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                clientName = in.readLine();
                clients.put(clientName, clientSocket);

                // Отправляем сообщение о подключении другим клиентам
                broadcastMessage(clientName + " has joined the chat");

                // Цикл обработки сообщений
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

                        // Отправляем личное сообщение получателю
                        Socket recipientSocket = clients.get(recipient);
                        if (recipientSocket != null) {
                            PrintWriter out = new PrintWriter(recipientSocket.getOutputStream(), true);
                            out.println("[" + clientName + " (private)]: " + privateMessage);
                        } else {
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            out.println("Recipient not found");
                        }
                    } else {
                        // Отправляем сообщение всем клиентам
                        broadcastMessage("[" + clientName + "]: " + message);
                    }
                }

                // Удаляем клиента из списка подключенных
                clients.remove(clientName);

                // Отправляем сообщение об отключении другим клиентам
                broadcastMessage(clientName + " has left the chat");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message) {
            for (Socket clientSocket : clients.values()) {
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}