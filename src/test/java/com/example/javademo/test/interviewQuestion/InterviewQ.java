package com.example.javademo.test.interviewQuestion;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author: zhaos
 * @date: 2021/1/26
 */
public class InterviewQ {

    @Test
    public void main() {
        //获取毫秒数
        Long milliSecond0 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        boolean odd0 = isOdd0(123456);
        Long milliSecond1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("按位与计算" + odd0 + "，花费时间:" + (milliSecond1 - milliSecond0));

        boolean odd1 = isOdd1(123456);
        Long milliSecond2 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("按取模计算" + odd1 + "，花费时间:" + (milliSecond2 - milliSecond1));
    }

    /**
     * 是否奇数
     * 按位与计算
     * @return boolean
     */
    public boolean isOdd0(int i) {
        return (i & 1) == 1;
    }

    /**
     * 是否奇数
     * 按取模计算
     * @return boolean
     */
    public boolean isOdd1(int i) {
        return i % 2 != 0;
    }
}
