package com.TCP_IP;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {

    // �ͻ��˷������ݵ������ʵ��TCP/ip����

    public static void main(String[] args) throws IOException {
        System.out.println("Client send data to Server");

        Socket client = new Socket("localhost", 6666);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("hello tcp i am coming now!".getBytes());


        System.out.println("�������Է���˵Ļ�д����");
        InputStream inputStream = client.getInputStream();
        byte[] bytedata = new byte[10240];  // �����ֽ���
        int lendata = inputStream.read(bytedata);
        System.out.println(new String(bytedata, 0, lendata));

        inputStream.close();
        outputStream.close();
        client.close();
    }
}
