package zhujie.test01;

import java.lang.reflect.Method;

/**
 * ---------------------------------------------
 * |@author: CHEN ZHONGYUAN                    |
 * ---------------------------------------------
 * |@contact: chenzhongyuan@dataexa.com        |
 * ---------------------------------------------
 * |@file: MyJunit.java                        |
 * ---------------------------------------------
 * |@time: 2020-04-22 14:01                    |
 * ---------------------------------------------
 */
public class MyJunit {
    public static void main(String[] args) throws Exception {
        // 加载UserDao.class 字节码文件方法中，判断哪些方法上有自定义的@MyTest,如果当前方法@MyTest,执行，否则不执行。
        // 1. 将UserDao.class 字节码文件加载到内存中，class对象
        Class clazz = Class.forName("zhujie.test01.UserDao");
        // 2. 获取字节码对象上所有的方法,返回Method数组对象，数组中的每一个元素都代表Method()对象。
        Method[] mds = clazz. getMethods();
        // 3.遍历字节码对象所有的方法
        for (Method md : mds) {
            System.out.println(md.getName());
            // 判断当前方法中是否有@MyTest注解信息
            if (md.isAnnotationPresent(MyTest.class)){
                // 如果当前的方法上有@MyTest注解，执行，否则忽略
                md.invoke(new UserDao());
            }
        }
    }
}
