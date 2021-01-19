package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author: zhaos
 * @date: 2021/1/7
 */
/*
    @Builder 可以加到对象 构造类 方法上
 */
@Data
@AllArgsConstructor
@Builder
public class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区
}
