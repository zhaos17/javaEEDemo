package com.example.javademo.utils;

import javafx.util.Pair;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zhaos
 * @date: 2021/1/18
 */
public class UUIDUtils {

    public static void main(String[] args) {
////        String str = "1e93eebdd25cef098197f0037bd9d5c," +
////                "1eb34706c185e908589e99e781d3641," +
////                "1eb3470023919108589e99e781d3641," +
////                "1eb346fc8f696f08589e99e781d3641," +
////                "1eb346fafc5eb908589e99e781d3641," +
////                "1e951e824ddd0d0b8303ddbbf1e10f7," +
////                "1ea7878a1a958209d7539447283014d," +
////                "1eb3476abbba9c08589e99e781d3641," +
////                "1e951e824de1ef0b8303ddbbf1e10f7," +
////                "1e951e824ddf7e0b8303ddbbf1e10f7";
////        String[] split = str.split(",");
////        for (String s : split) {
////            System.out.println(fromString(s));
////        }
//
////        System.out.println(fromString("1e93eebdd25cef098197f0037bd9d5c"));
////        System.out.println(fromTimeUUID(fromString("41833b40-e818-11ea-8518-f18d5e21b4c8")));
//
////        System.out.println(fromTimeUUID(fromString("b92577e0-511e-11e9-83d9-750d46843b0c")));
////
////        System.out.println(fromTimeUUID(fromString("02391910-3470-11eb-8589-e99e781d3641")));
//
////        System.out.println(getDayOfMonth());
//
        List<Double> dbSort = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dbSort.add(Math.random());
        }
        List<Double> collect = dbSort.stream().sorted(((o1, o2) -> Double.compare(o2, o1))).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


//    public static void main(String[] args) {
//        int[] arr = {1,3,5,7,9};
//        int[] arr2 = {2,3,5,6,8};

//        int i = 0,j = 0;
//        for (;i < arr.length;) {
//            for (;j < arr2.length;) {
//                if (arr[i] < arr2[j]) {
//                    System.out.println(arr[i]);
//                    i++;
//                    continue;
//                } else if (arr[i] > arr2[j]) {
//                    System.out.println(arr2[j]);
//                    j++;
//                    continue;
//                } else {
//                    continue;
//                }
//
//            }
//        }
//    }

    public static UUID fromString(String src) {
        if (StringUtils.isEmpty(src)) {
            return null;
        }

        try {
            if (src.contains("-")) {
                return UUID.fromString(src);
            }

            return UUID.fromString(src.substring(7, 15) + "-" + src.substring(3, 7) + "-1"
                    + src.substring(0, 3) + "-" + src.substring(15, 19) + "-" + src.substring(19));
        } catch (Exception e) {
            return null;
        }
    }

    public static String fromTimeUUID(UUID src) {
        if (null == src) {
            return null;
        }

        String str = src.toString();
        // 58e0a7d7-eebc-11d8-9669-0800200c9a66 => 1d8eebc58e0a7d796690800200c9a66. Note that [11d8] -> [1d8]
        return str.substring(15, 18) + str.substring(9, 13) + str.substring(0, 8) + str.substring(19, 23) + str.substring(24);
    }

    public static Pair<Integer, Integer> getImg() throws IOException {
        URL url = new URL("https://hkywuyinzifenxi.oss-cn-hangzhou.aliyuncs.com/image/BgModel/mapa20210415181428.png");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        BufferedImage image = ImageIO.read(connection.getInputStream());
        int srcWidth = image.getWidth();      // 源图宽度
        int srcHeight = image.getHeight();    // 源图高度

        System.out.println("srcWidth = " + srcWidth);
        System.out.println("srcHeight = " + srcHeight);
        return null;
    }

}
