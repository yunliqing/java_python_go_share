package com.test.shipeiqi;
/**
 *
 * 设计模式 之 适配器模式
 * 有个手机类，可以实例化一个手机
 * 有一个vga接口，里面有一些 VGA 线的操作方法等吧
 * 这个时候，就会出现一个问题。
 * 我的手机想用VGA 这个方法去连接显示器。但是没有vga 接口，只有type c 接口
 * 就会出现一个 适配器类。用于统一不同接口直接的适配工作。
 * 在不改变 手机 和 VGA 的同时，来处理这件事
 *
 * 这个类，就是适配器类。
 *
 * */
public class Shipeiqi {
    public static void main(String[] args) {

    }
}

// 定义一个 手机类，有一个type c 的接口
class Phone {
    public void typecPhone() {
        System.out.println("信息从Typec口的手机输出。");
    }
}

// 定义了一个 vga 的接口
interface Vga {
    void vgaInterface();
}


/**
 *
 * 实现一个Type-c转VGA适配器，
 *
 * @author C ZHONGYUAN
 *
 */
class TypecVga implements Vga{

    private Phone phone;

    public TypecVga(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void vgaInterface() {
        if(phone != null) {
            phone.typecPhone();
            System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
            System.out.println("信息已转换成VGA接口，显示屏可以对接。");
        }
    }
}

