package com.test;
import java.util.*;
/**
 * 构建者模式
 * Director：控制者类，这是控制整个组合过程，在这个类内部有个Construct()方法，这个方法的作用就是通过调用Builder内部的各个组件的生成方法来完成组装；
 *
 * Builder：构建者接口，定义各部件生成的方法；
 *
 * ConcreteBuilder：具体构建者类：实现Builder构建者接口，具体定义如何生成各个部件；依赖于Product成品类，其中还有获取成品组装结构的方法GetResult()方法；
 *
 * Product：成品类
 *
 * */
public class goujianzhe {
    public static void main(String[] args) {
        // 主函数调用测试类。
        Clienter c = new Clienter();
    }
}



class Computer {
    List<String> parts = new ArrayList<String>();
    public void show(){
        for(String s:parts){
            System.out.println(s);
        }
    }
}

// 定义产品接口
interface Builder {
    void build_CPU();
    void build_mainboard();
    void build_memory();
    void build_DISK();
    void build_power();
    Computer getComputer();
}

// 电脑类实现构造接口
class ComputerBuilder implements Builder {
    // 这里是实例化了一个别的类的对象，也可以用当前类的对象。
    private Computer computer = new Computer();
    @Override
    public void build_CPU() {
        computer.parts.add("采用INTEL的CPU");
    }
    @Override
    public void build_mainboard() {
        computer.parts.add("采用大型主版");
    }
    @Override
    public void build_memory() {
        computer.parts.add("采用8G内存");
    }
    @Override
    public void build_DISK() {
        computer.parts.add("采用1TB固态硬盘");
    }
    @Override
    public void build_power() {
        computer.parts.add("采用XXX电源");
    }
    @Override
    public Computer getComputer() {
        return computer;
    }
}

// 组装类，开始对电脑类进行执行。把电脑类对象传进来，进行调用电脑类中的方法
// 电脑对象为指针对象，所以执行完了，对象的属性就都有了。也就是组装类的意义。
class Director {
    public void construct(Builder builder){
        builder.build_CPU();
        builder.build_mainboard();
        builder.build_memory();
        builder.build_DISK();
        builder.build_power();
    }
}

// 测试类， 实例化一个电脑类，实例化一个组装类，把电脑类对象给了组装类进行组装
// 组装完，这时候电脑对象就是一个完整的对象了。
class Clienter {
    public static void main(String[] args) {
        Builder builder = new ComputerBuilder();
        Director director = new Director();
        director.construct(builder);
        builder.getComputer().show();
    }
}


