package com.example.javademo.thread;

/**
 * @author: zhaos
 * @date: 2021/7/8
 */
public class ThreadTest {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "the");

        thread.setDaemon(true);
        thread.start();

        System.out.println(Thread.currentThread().getName() + " over");
    }
}
