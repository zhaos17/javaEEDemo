package com.example.javademo.transienttest;

import com.example.javademo.entity.User;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author: zhaos
 * @date: 2020/12/9
 */
public class TransientTest {

    /*
     * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
     * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
     * 否则，会报NotSerializableException异常
     * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
     */

    /**
     * 测试增加了transient关键字的属性在反序列化时，不会获取到对应值的情况
     */
    @Test
    public void inputTest() {
        User user = new User(); // "Alexia","123456"
        User.setUsername("Alexia");
        user.setPasswd("123456");

        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPasswd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/user.txt"));
            user = (User) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + User.getUsername());
            System.err.println("password: " + user.getPasswd());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试静态变量是否真的不会被序列化
     */
    @Test
    public void test2() {
        User user = new User();
        User.setUsername("Alexia");
        user.setPasswd("123456");

        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPasswd());

        try {
            // username在序列化的时候值为“Alexia”
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 在反序列化之前改变username的值
            User.setUsername("jmwang");

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/user.txt"));
            user = (User) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + User.getUsername());
            System.err.println("password: " + user.getPasswd());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
