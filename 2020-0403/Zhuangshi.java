package com.test.zhuangshi;

/**
 * 设计模式 之 装饰模式
 * 解释：
 * 假设有一个接口Human，一个接口的实现类Man。人类Human是可以跑步的，但是不能飞。
 * 如果想给人类加上飞翔的翅膀，可以有三种解决方案：
 * 修改实现类Man的方法，但不符合开闭原则
 * 给实现类Man添加一个子类，扩展一个人类可以飞的功能。问题在于，如果又想给人类增加猎豹般奔跑的速度，需要继续扩展一个子类。
 * 显然，使用继承的方式去扩展一个类的功能，会增加类的层级，类的臃肿会加大维护的成本。
 * 使用装饰模式扩展一个类的功能。
 * 好处在于，如果继承关系是纵向的，那么装饰类则是某个类横向的扩展，并不会影响继承链上的其他类。
 * 例如：C extends B , B extends A，如果需要扩展B的功能，可以设计一个B的装饰类，它并不会影响B的子类C。
 * 如果采用在B里面增加方法，势必会使B的所有子类结构被改变。
 */

public class Zhuangshi {
    public static void main(String[] args) {
        //创建被装饰的类
        Human human = new Man();

        //创建装饰的类，并添加被装饰类的引用
        Human superMan = new ManDecorator(human);

        //执行增强后的run方法
        superMan.run();
    }
}


// 定义一个接口，人类是可以跑步的。抽象一个run()方法。
interface Human {
    public void run();
}

// 定义一个被装饰的类，也是继承接口的类。
// 定义了一个男人类
class Man implements Human {

    @Override
    public void run() {
        System.out.println("人类会跑步，跑起来。");
    }
}

// 定义一个装饰类的抽象类
abstract class AbstractDecorator implements Human {
    //持有被装饰类的引用
    private Human human;

    //构造函数注入被装饰者
    public AbstractDecorator(Human human) {
        this.human = human;
    }

    //调用被装饰类的方法
    @Override
    public void run() {
        human.run();
    }
}


// 定义一个装饰类的实现类
class ManDecorator extends AbstractDecorator {
    public ManDecorator(Human human) {
        //调用父类的构造方法
        super(human);
    }

    //装饰类增加的功能
    private void fly() {
        System.out.println("人可以飞");
    }

    //增强了功能的run方法
    @Override
    public void run() {
        super.run();
        fly();
    }
}

