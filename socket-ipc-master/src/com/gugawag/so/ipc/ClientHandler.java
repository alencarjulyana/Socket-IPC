package com.gugawag.so.ipc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Enviando a data e hora para o cliente
            PrintWriter pout = new PrintWriter(clientSocket.getOutputStream(), true);
            pout.println(new Date().toString() + " - Boa noite, alunos!");

            // Lendo a mensagem do cliente
            InputStream in = clientSocket.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            String line = bin.readLine();
            System.out.println("O cliente disse: " + line);

            // Fechando a conexão com o cliente
            clientSocket.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}




























































































