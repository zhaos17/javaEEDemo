package com.example.javademo.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        List<Integer> squaresList = numbers.stream()
                .map(i -> i * i)
                .sorted((x, y) -> y - x) // 倒叙
                .collect(Collectors.toList());
        squaresList.forEach(System.out::println);
//        squaresList.forEach(num -> {
//            num++;
//            System.out.println(num);
//        });

        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap = new HashMap<>();

        strMap = strList.stream()
                .collect(Collectors.toMap(strList::indexOf, str -> str));

        strMap.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });

    }
}
