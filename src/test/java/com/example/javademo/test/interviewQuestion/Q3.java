package com.example.javademo.test.interviewQuestion;

import java.util.Scanner;

/**
 * @author: zhaos
 * @date: 2021/3/27
 * 输出一个整数的质因子
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        long k = (long) Math.sqrt(num);

        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "": num+" ");
    }
}
