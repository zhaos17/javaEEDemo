package com.example.javademo.test.interviewQuestion;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author: zhaos
 * @date: 2021/3/27
 */
public class Q2 {
    /**
     * 十六进制转十进制
     */
    @Test
    public void t1() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int i = Integer.parseInt(s.substring(2),16);
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            //16进制输入为字符串输入
            int num = 0;
            for (int i = 2; i < s.length(); i++) { //i=2,用来跳过“0x”
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') {
                    num = num * 16 + s.charAt(i) - 'A' + 10;
                } else {
                    num = num * 16 + s.charAt(i) - '0';
                }
            }
            System.out.println(num);
        }
    }
}
