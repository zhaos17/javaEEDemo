package com.example.javademo.test.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhaos
 * @date: 2021/1/7
 */
public class StreamTest {

    /*
        串行流：适合存在线程安全问题、阻塞任务、重量级任务，以及需要使用同一事务的逻辑。
        并行流：适合没有线程安全问题、较单纯的数据处理任务。
     */

    @Test
    void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<String> strs = numbers.stream().map(num -> Integer.toString(++num)).collect(Collectors.toList());

        strs.forEach(System.out::println);
    }

    @Test
    void test2_1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(System.out::println);
    }

    @Test
    void test2_2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num -> System.out.println(Thread.currentThread().getName()+">>"+num));
    }

    @Test
    void test2_3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> strs = numbers.parallelStream().map(num -> ++num).collect(Collectors.toList());
        strs.forEach(System.out::println);
    }
}
