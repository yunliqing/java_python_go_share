package com.wangluotcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用tcp协议接收数据
 *  创建接收端Socket对象
 *  监听（阻塞）
 *  获取输入流对象
 *  获取数据
 *  输出数据
 *  释放资源
 *
 * */
public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        // 创建接收端Socket对象
        ServerSocket ss = new ServerSocket(10086);
        // 监听
        Socket s = ss.accept();
        // 获取输入流对象
        InputStream is = s.getInputStream();
        // 获取数据
        byte[] bys = new byte[1024];
        int len; // 用于存储读到的字节个数。
        len = is.read(bys);

        // 输出数据
        System.out.println(new String(bys, 0, len));
        // 释放资源
        s.close();
        ss.close();
    }
}
