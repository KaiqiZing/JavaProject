package com.TCPIPAdvance;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
    public static void main(String[] args) throws IOException, UnknownHostException {
        String hostname = "localhost";
        int port = 8000;

        try (Socket socket = new Socket("localhost", 6678)) {
            System.out.println("Connected to the server");

            // ��������
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello, server");

            // ��������
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String response = reader.readLine();
            System.out.println(response);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}