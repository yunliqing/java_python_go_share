package zhujie.test01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ---------------------------------------------
 * |@author: CHEN ZHONGYUAN                    |
 * ---------------------------------------------
 * |@contact: chenzhongyuan@dataexa.com        |
 * ---------------------------------------------
 * |@file: MyTest.java                          |
 * ---------------------------------------------
 * |@time: 2020-04-22 13:55                     |
 * ---------------------------------------------
 */
// 定义注解的时候，需要通过元注解Retention说明当前自定义注解的作用域（Class,Source,Runtime）
@Retention(RetentionPolicy.RUNTIME)
// 定义注解的时候，需要通过元注解Target说明当前的自定义注解的目标对象
@Target(ElementType.METHOD)
public @interface MyTest {
    // 在MyTest注解中定义成员属性，默认-1
    public long timeout() default -1;
}
