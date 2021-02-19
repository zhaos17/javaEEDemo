package com.example.javademo.test.fanxing;

import org.springframework.context.annotation.Description;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhaos
 * @date: 2021/1/28
 */
public class test1 {

//    public static <T> List<T> toEntity(Class<T> clazz) throws IllegalAccessException, InstantiationException {
//        List<T> list = new ArrayList<>();
////        Class <T> clazz = (Class <T>) ((ParameterizedType) entity.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        T dto = clazz.newInstance();
//        T dto2 = clazz.newInstance();
//        Field[] fields = clazz.getDeclaredFields();
//        Map<String, Field> fieldMap = new LinkedHashMap<>();
//        for (Field field : fields) {
//            String mod = Modifier.toString(field.getModifiers());
//            System.out.println("mod = " + mod);
//            // 跳过静态属性
//            if (mod.contains("static")) {
//                continue;
//            }
//
//            // 取得注解的设置的属性值
//            Description setField = field.getAnnotation(Description.class);
//            if (setField != null) {
//                String fieldName = setField.key();
//                String fieldType = setField.value();
//                //   必须,不然赋值会出现异常
//                field.setAccessible(true);
//                fieldMap.put(fieldType, field);
//                System.out.println("注解的属性 fieldName = " + fieldName);
//                System.out.println("注解的属性 fieldType = " + fieldType);
//            }
//        }
//        int num = 0;
//        for (String key : fieldMap.keySet()) {
//            num++;
//            fieldMap.get(key).set(dto, "dto1:" + key + num);
//            fieldMap.get(key).set(dto2, "dto2:" + key + num);
//        }
//        list.add(dto);
//        return list;
//    }
}
