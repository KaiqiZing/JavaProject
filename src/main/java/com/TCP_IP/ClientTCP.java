package com.TCP_IP;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {

    // 客户端发送数据到服务端实现TCP/ip连接

    public static void main(String[] args) throws IOException {
        System.out.println("Client send data to Server");

        Socket client = new Socket("localhost", 6666);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("hello tcp i am coming now!".getBytes());


        System.out.println("接受来自服务端的回写数据");
        InputStream inputStream = client.getInputStream();
        byte[] bytedata = new byte[10240];  // 创建字节组
        int lendata = inputStream.read(bytedata);
        System.out.println(new String(bytedata, 0, lendata));

        inputStream.close();
        outputStream.close();
        client.close();
    }
}
