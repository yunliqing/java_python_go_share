package com.wangluotcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 使用tcp 协议发送数据
 *  创建发送端Socket对象，（创建连接）
 *  获取输出流对象
 *  发送数据
 *  释放资源
 *
 *  Socket(InetAddress address, int port)
 *
 * */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送端Socket对象，（创建连接）
        Socket s = new Socket(InetAddress.getByName("192.168.0.149"), 10086);
        // 获取输出流对象
        OutputStream os = s.getOutputStream();
        // 发送数据
        String str = "hello tcp, i am coming!!!";
        os.write(str.getBytes());
        // 释放资源
        os.close();
        s.close();
    }
}
