package com.example.javademo.test;

import com.example.javademo.modal.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest4 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        t.start();
    }

    @Test
    public void removeTest() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11, "小牙刷", 12.05));
        items.add(new Item(5, "日本马桶盖", 999.05));
        items.add(new Item(7, "格力空调", 888.88));
        items.add(new Item(17, "肥皂", 2.00));
        items.add(new Item(9, "冰箱", 4200.00));

        items.removeIf(ele -> ele.getId() == 7);

        //通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);
    }

    @Test
    public void orderTest() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(13, "背心", 7.80));
        list.add(new Item(11, "半袖", 37.80));
        list.add(new Item(14, "风衣", 139.80));
        list.add(new Item(12, "秋裤", 55.33));

//        list.sort(new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return o1.getId()  - o2.getId();
//            }
//        });
        list.sort((o1, o2) -> o1.getId() - o2.getId());
        list.forEach(System.out::println);
    }

    @Test
    public void streamTest() {
        // 过滤为空的
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//        filtered.forEach(System.out::println);

        // 随机获取十个整数
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

        // 获取对应的平方数
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
//        squaresList.forEach(System.out::println);

        // 获取空字符串的数量
//        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        long count = strings.stream().filter(string -> string.isEmpty()).count();
//        System.out.println(count);

        // limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

        // sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序
//        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);

        // parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        // 获取空字符串的数量
//        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();

        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }
}
