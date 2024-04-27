package ru.otus.java.homeworks.homework22;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedServer {

    public static void main(String[] args) {
        final int portNumber = 8080;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Сервер запущен на порту " + portNumber);

            ExecutorService executorService = Executors.newFixedThreadPool(10); // Количество потоков в пуле

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключен клиент: " + socket);

                executorService.execute(() -> {
                    try {
                        handleClient(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String requestData = new String(buffer, 0, bytesRead);
                System.out.println("Получены данные от клиента: " + requestData);
                String responseData = "Принят запрос: " + requestData;
                outputStream.write(responseData.getBytes());
                System.out.println("Отправлен ответ клиенту: " + responseData);
            }
        } finally {
            socket.close();
        }
    }
}