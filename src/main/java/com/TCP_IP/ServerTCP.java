package com.TCP_IP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    // ������������ȴ��ͻ��������������Ӳ��������Կͻ��˵�����
    public static void main(String[] args) throws IOException {
        System.out.println("server start, please waiting...");
        ServerSocket serverSocket = new ServerSocket(6666);
        // �������Ӳ����ض���
        Socket server = serverSocket.accept();
        InputStream is = server.getInputStream(); // ͨ��socket��ȡ������
        byte[] bytedata = new byte[10240];  // �����ֽ���
        int lendata = is.read(bytedata);    // ��ȡ�ֽ��鵽���ݵ���
        String messagedata = new String(bytedata,0, lendata); // �������鲢��ӡ�ַ�����Ϣ
        System.out.println("Server��ȡ���Կͻ��˵�����:" + messagedata);

        System.out.println("=======��д������=========");
        OutputStream outputStream = server.getOutputStream();
        outputStream.write("i am fine thanks".getBytes());
        outputStream.close(); // ��д��Ҫ�ǵùرջ�д����
        is.close();
        server.close();
    }
}
