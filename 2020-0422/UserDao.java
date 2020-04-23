package zhujie.test01;

/**
 * ---------------------------------------------
 * |@author: CHEN ZHONGYUAN                    |
 * ---------------------------------------------
 * |@contact: chenzhongyuan@dataexa.com        |
 * ---------------------------------------------
 * |@file: UserDao.java                          |
 * ---------------------------------------------
 * |@time: 2020-04-22 13:55                     |
 * ---------------------------------------------
 */
public class UserDao {

    static {
        System.out.println("加载静态代码段的消息");
    }

    @MyTest
    public void addUser() {
        System.out.println("添加用户");
    }
    @MyTest
    public void delUser() {
        System.out.println("删除用户");
    }
    @MyTest
    public void uptUser() {
        System.out.println("修改用户");
    }
    public void getUser() {
        System.out.println("查询用户");
    }

}
