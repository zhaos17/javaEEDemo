package com.example.javademo.utils;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author: zhaos
 * @date: 2021/1/18
 */
public class UUIDUtils {

    public static void main(String[] args) {
//        System.out.println(fromTimeUUID(UUID.fromString("6c075c40-cbf1-11ea-aaa5-059f09ba413e")));
//        System.out.println(fromTimeUUID(UUID.fromString("ed6247c0-62c2-11ea-b3fd-356953dd22be")));
        // 6c185e90-3470-11eb-8589-e99e781d3641
        // abbba9c0-3476-11eb-8589-e99e781d3641
        System.out.println(fromTimeUUID(fromString("2a0cd594-6926-11eb-9a8f-f5be458cec35")));
        System.out.println(fromTimeUUID(fromString("02d551ab-3055-11eb-90e1-813a7c3d67d0")));
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
