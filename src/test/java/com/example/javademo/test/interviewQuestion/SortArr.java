package com.example.javademo.test.interviewQuestion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zhaos
 * @date: 2021/4/12
 */
public class SortArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 这段只是为了造一个int数组
            String strs = sc.nextLine();
            String[] arrs = strs.split(",");
            if (arrs.length <= 0) {
                return;
            }
            int[] intArr = new int[arrs.length];
            for (int i = 0; i < arrs.length; i++) {
                intArr[i] = Integer.parseInt(arrs[i]);
            }
            System.out.println(getMinVal(intArr));
        }
    }
    public static long getMinVal(int[] intArr) {
        List<String> strList = Arrays.stream(intArr).mapToObj(String::valueOf).sorted((a,b)-> {
            if (a.length() > b.length()) {
                return compareTo(a,b,0,0);
            } else if (a.length() < b.length()) {
                return -compareTo(b,a,0,0);
            }
            return a.compareTo(b);
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        strList.forEach(sb::append);
        return Long.parseLong(sb.toString());
    }
    public static int compareTo(String a,String b,int aSize,int bSize) {
        if (a.charAt(aSize) != b.charAt(bSize)) {
            return a.charAt(aSize) >= b.charAt(bSize) ? 1 : -1;
        } else {
            while (aSize < a.length() && bSize < b.length() && a.charAt(aSize) >= b.charAt(bSize)) {
                ++aSize;
                bSize = Math.min(++bSize,b.length() - 1);
            }
            if (aSize >= a.length()) {
                return a.charAt(aSize - 1) >= b.charAt(bSize - 1) ? 1 : -1;
            } else {
                return a.charAt(aSize) >= b.charAt(bSize) ? 1 : -1;
            }
        }
    }
}
