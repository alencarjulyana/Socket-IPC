package com.gugawag.so.ipc;

/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.21
 *
 * @author Silberschatz, Gagne, and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Ninth Edition
 * Copyright John Wiley & Sons - 2013.
 */
import java.net.*;
import java.io.*;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        try {
            // Criando o servidor na porta 6013
            ServerSocket serverSocket = new ServerSocket(6013);
            System.out.println("=== Servidor iniciado ===\n");

            // Loop infinito para aceitar conexões de clientes
            while (true) {
                // Aceita a conexão do cliente
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado: " + clientSocket.getInetAddress());

                // Criando uma nova thread para atender este cliente
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start(); // Inicia a thread
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}