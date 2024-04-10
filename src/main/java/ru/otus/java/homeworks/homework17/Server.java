package ru.otus.java.homeworks.homework17;

import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;

public class Server {

    public static final int PORT = 1234;
    public static Map<String, Socket> clients = new HashMap<>();
    public static Map<String, String> roles = new HashMap<>();

    public static void main(String[] args) throws IOException, SQLException {
        // Учетные данные для подключения к базе данных
        try {
            String username = "adcm";
            String password = "adcm";
            String url = "jdbc:postgresql://localhost:5432/adcm_khodus";
            User.connection = DriverManager.getConnection(url, username, password);
            User.createUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                // Создаем новый поток для обработки каждого клиента
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}