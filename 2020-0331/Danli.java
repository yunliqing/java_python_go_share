package com.test.danli;

public class Danli {

}

/**
 * 懒汉式
 * 线程不安全，因为没有上锁
 *
 * */
class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**
 *
 * 懒汉式
 * 线程安全，因为上了线程锁
 * 使用关键字 synchronized 修饰的方法，一旦被一个线程访问，其余线程无法访问。
 * */
class Singleton2 {
    private static Singleton2 instance;
    private Singleton2 (){}
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 饿汉式
 * 线程安全
 * 静态方法，在加载的时候，就生成了实例化对象，并保存
 * 如果这个对象不用，或者用的很少的话，会有点占内存
 *
 * */
class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3 (){}
    public static Singleton3 getInstance() {
        return instance;
    }
}