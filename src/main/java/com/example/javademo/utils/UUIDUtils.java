package com.example.javademo.utils;

import org.springframework.util.StringUtils;

import java.util.*;

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
//        System.out.println(fromTimeUUID(fromString("a1a95820-7878-11ea-9d75-39447283014d")));
//        System.out.println(fromTimeUUID(fromString("02d551ab-3055-11eb-90e1-813a7c3d67d0")));
//        List<UUID> inDoorDeviceStoreIds = new ArrayList<>();
//
//        System.out.println(CollectionUtils.isEmpty(inDoorDeviceStoreIds));
        System.out.println(fromString("1eb3476abbba9c08589e99e781d3641"));
//        Date date = new Date(1617328962000L);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        int intMonth = calendar.get(Calendar.MONTH) + 1;
//        int quarter = intMonth % 3 == 0 ? intMonth/3 : intMonth/3+1;
//        System.out.println(quarter);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list.subList(0, 3).size());
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

}
