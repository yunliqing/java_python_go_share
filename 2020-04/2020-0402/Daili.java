package com.test.daili;

import java.util.Random;

/**
 * d设计模式 之 代理模式
 *  解释：有一个 移动 接口
 *       汽车类 实现这个接口，也就是说，汽车可以移动。Car
 *       但是我现在想让一个汽车去移动。
 *       不行，必须通过代理让这个车移动。 Car3
 *       把 Car 实例对象传过去，Car3 会让这个 Car 移动
 *       这就是代理模式
 *
 *
 * */
public class Daili {
    public static void main(String[] args) {
        //使用聚合方式实现
        Car car = new Car();
        Moveable m = new Car3(car);
        m.move();
    }
}

interface Moveable {

    void move();

}

class Car implements Moveable {

    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Car3 implements Moveable{

    private Car car;
    public Car3(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶.......");
        //通过构造方法将car传进来，然后通过car调用方法
        car.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶......");
        System.out.println("汽车行驶时间:"+(endtime - starttime)+"毫秒!");
    }
}





