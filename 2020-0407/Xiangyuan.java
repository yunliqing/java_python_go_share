package com.test.xiangyuan;

public class Xiangyuan {
    public static void main(String[] args) {
        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i3 = 123;
        Integer i4 = 123;
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        System.out.println("======================");

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));

        // Byte Short Integer Long
        // 包装类 把 -128 到 127 给缓存起来。如果超过了 127 之后，就会重新创建对象
        // 这就是享元模式
        // 个人理解：享元模式，就是说，如果两个对象的相同，但是又不是相同的对象。
        // 这时候，让对象使用一个对象，避免内存开销。这就是享元模式

    }
}
