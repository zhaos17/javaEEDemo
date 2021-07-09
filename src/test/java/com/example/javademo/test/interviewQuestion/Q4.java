package com.example.javademo.test.interviewQuestion;

import java.util.Scanner;

/**
 * @author: zhaos
 * @date: 2021/3/27
 */
public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println((int)(scanner.nextDouble() + 0.5));
        }
    }
}
