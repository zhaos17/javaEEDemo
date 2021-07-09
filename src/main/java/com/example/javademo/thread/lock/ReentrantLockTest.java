package com.example.javademo.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhaos
 * @date: 2021/7/8
 *
 * ReentrantLock 可重入锁 模拟售票
 */
public class ReentrantLockTest {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() ->  {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() ->  {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() ->  {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();

    }
}


class Ticket {

    // 创建
    private final ReentrantLock lock = new ReentrantLock();

    private Integer ticketNum = 30;

    public synchronized void sale() {
        lock.lock();
        try {
            // 是否有票
            if (ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出；当前票数：" + (ticketNum--) + "；卖出后：" + ticketNum);
            }
        } finally {
            lock.unlock();
        }
    }
}
