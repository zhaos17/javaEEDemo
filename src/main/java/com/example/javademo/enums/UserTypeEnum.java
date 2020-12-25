package com.example.javademo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: zhaos
 * @date: 2020/12/11
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    /**
     * 学生
     */
    STUDENT("学生"),
    /**
     *老 师
     */
    TEACHER("老师"),
    /**
     * 农民
     */
    FARMER("农民");

    private final String desc;
}