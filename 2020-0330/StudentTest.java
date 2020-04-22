package com.test;
/**
 * 原型模式： 创建对象型模式，复制原型对象的方法， 创建对象实例
 *          使用原型模式创建的对象具备原型对象的属性值
 * 本质：通过定义一个原型类，获取实例，调用clone()方法，进行实例的复制
 *
 * 特点：1 原型模式创建实例，并不会执行构造方法。
 *      2 原型模式得到的实例，除了具备类下的实例外，还会具备原型实例下的属性值。
 *      3 使用原型模式得到的新实例，会开辟新的内存空间
 * 原型模式的克隆分为两种：1 浅度克隆  2 深度克隆
 * 浅度克隆：原理是从内存中以二进制流的方式，进行复制。重新开辟新的内存。
 *          当克隆的类中，有引用的对象。 （String或Integer等包装类除外）
 *          克隆出来的类中的引用变量存储的是之前的内存地址，是共享的。
 * 深度克隆：深度克隆后，引用对象独立，彼此不会影响。
 * */
public class StudentTest {
    public static void main(String[] args) {
        // 1.创建原型类的第一个原型实例
        Student student = new Student("王小明", 18, "男");
        System.out.println(student);

        // 2.调用克隆方法，进行对象克隆
        Student student2 = student.clone();
        student2.setName("李小强");
        System.out.println(student2);
    }
}
