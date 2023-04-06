package com.TCP_IP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    // 服务端先启动等待客户端启动后建立连接并接受来自客户端的数据
    public static void main(String[] args) throws IOException {
        System.out.println("server start, please waiting...");
        ServerSocket serverSocket = new ServerSocket(6666);
        // 接受链接并返回对象
        Socket server = serverSocket.accept();
        InputStream is = server.getInputStream(); // 通过socket获取输入流
        byte[] bytedata = new byte[10240];  // 创建字节组
        int lendata = is.read(bytedata);    // 读取字节组到数据当中
        String messagedata = new String(bytedata,0, lendata); // 解析数组并打印字符串信息
        System.out.println("Server获取来自客户端的数据:" + messagedata);

        System.out.println("=======回写数据中=========");
        OutputStream outputStream = server.getOutputStream();
        outputStream.write("i am fine thanks".getBytes());
        outputStream.close(); // 回写后要记得关闭回写数据
        is.close();
        server.close();
    }
}
