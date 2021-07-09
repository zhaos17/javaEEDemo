package com.example.javademo.thread.sync;

/**
 * @author: zhaos
 * @date: 2021/7/8
 *
 * synchronized 模拟售票
 */
public class SaleTickets {

    public static void main(String[] args) {
        // 获取计算机为几核的
//        int processors = Runtime.getRuntime().availableProcessors();
//        System.out.println(processors);

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

    private Integer ticketNum = 30;

    public synchronized void sale() {
        // 是否有票
        if (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出；当前票数：" + (ticketNum--) + "；卖出后：" + ticketNum);
        }
    }
}
