package ru.otus.java.homeworks.homework23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int serverPort = 8080;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("Подключено к серверу " + serverAddress + ":" + serverPort);

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            String userInput;

            while (true) {
                System.out.print("Введите запрос (или \"exit\" для выхода): ");
                userInput = userInputReader.readLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                outputStream.write(userInput.getBytes());
                System.out.println("Отправлен запрос на сервер: " + userInput);
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String responseData = new String(buffer, 0, bytesRead);
                System.out.println("Получен ответ от сервера: " + responseData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}