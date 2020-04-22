package com.test;
/**
 * 原型模式
 *
 * */
// 让原型类实现 Cloneable 接口，可以进行克隆复制
public class Student implements Cloneable {
    private String name;
    private int age;
    private String sex;



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Student(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("有参构造方法执行");
    }

    public Student() {
        super();
        System.out.println("无参构造方法执行");
    }

    // 类下声明 clone 方法，进行实例的复制
    @Override
    protected Student clone() {
        try {
            Student student = (Student) super.clone();
            return student ;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
