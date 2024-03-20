package ru.otus.java.homeworks.homework13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Сервер запущен");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое подключение");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Доступные операции: +, -, *, /");

                String operation = in.readLine();
                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());
                double result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        out.println("Некорректная операция");
                        continue;
                }

                out.println("Результат: " + result);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}