package ru.otus.java.homeworks.homework13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println(in.readLine());

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Выберите операцию: ");
            String operation = consoleInput.readLine();
            System.out.print("Введите первое число: ");
            double num1 = Double.parseDouble(consoleInput.readLine());
            System.out.print("Введите второе число: ");
            double num2 = Double.parseDouble(consoleInput.readLine());

            out.println(operation);
            out.println(num1);
            out.println(num2);

            System.out.println("Результат вычислений: " + in.readLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}