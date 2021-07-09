package com.example.javademo.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhaos
 * @date: 2021/4/28
 */
public class Test {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        A a = new A();
        a.start();

        synchronized (atomicInteger) {
            try {
                atomicInteger.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger.get());
    }

    static class A extends Thread {
        @Override
        public void run() {
            atomicInteger.notify();
            atomicInteger.set(1);
        }
    }

}
