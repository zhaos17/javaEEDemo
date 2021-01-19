package com.example.javademo.utils;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author: zhaos
 * @date: 2021/1/18
 */
public class UUIDUtils {

    public static void main(String[] args) {
//        System.out.println(fromTimeUUID(UUID.fromString("0be293f0-e697-11ea-9464-b75355ac6c2d")));
        System.out.println(fromTimeUUID(UUID.fromString("0be293f0-e697-11ea-9464-b75355ac6c2d")));
//        System.out.println(fromString("1eae1205815d3d097dbeb63eee49fc7"));
    }

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

}
