package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Сервер запущен на порту " + port);
            System.out.println("Подключен клиент с порта " + clientSocket.getPort());

            final String name = in.readLine();
            System.out.println("Привет  " + name + " ваш порт: " + clientSocket.getPort());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}