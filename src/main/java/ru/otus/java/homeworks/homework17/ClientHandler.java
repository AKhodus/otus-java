package ru.otus.java.homeworks.homework17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private String clientName;
    private String role;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Получаем имя клиента и роль
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String[] parts = in.readLine().split(" ");
            clientName = parts[0];
            role = parts[1];
            // Проверяем аутентификацию
            if (!User.authenticateUser(clientName, role)) {
                // Если аутентификация не пройдена, закрываем соединение с клиентом
                clientSocket.close();
                return;
            }
            Server.clients.put(clientName, clientSocket);
            Server.roles.put(clientName, role);

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
                    parts = message.split(" ");
                    String recipient = parts[1];
                    String privateMessage = message.substring(3 + recipient.length());

                    // Отправляем личное сообщение получателю
                    Socket recipientSocket = Server.clients.get(recipient);
                    if (recipientSocket != null) {
                        PrintWriter out = new PrintWriter(recipientSocket.getOutputStream(), true);
                        out.println("[" + clientName + " (private)]: " + privateMessage);
                    } else {
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        out.println("Recipient not found");
                    }
                } else if (message.startsWith("/kick ")) {
                    // Проверяем, является ли отправитель администратором
                    if (!role.equals("ADMIN")) {
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        out.println("You are not authorized to kick users");
                    } else {
                        // Извлекаем имя пользователя, которого нужно отключить
                        String username = message.substring(6);
                        Socket userSocket = Server.clients.get(username);

                        // Отключаем пользователя
                        if (userSocket != null) {
                            userSocket.close();
                            Server.clients.remove(username);
                            Server.roles.remove(username);

                            // Отправляем сообщение об отключении другим клиентам
                            broadcastMessage(username + " has been kicked from the chat");
                        } else {
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            out.println("User not found");
                        }
                    }
                } else {
                    // Отправляем сообщение всем клиентам
                    broadcastMessage("[" + clientName + "]: " + message);
                }
            }

            // Удаляем клиента из списка подключенных
            Server.clients.remove(clientName);
            Server.roles.remove(clientName);

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
        for (Socket clientSocket : Server.clients.values()) {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}