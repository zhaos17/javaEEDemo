package com.example.javademo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: zhaos
 * @date: 2021/1/22
 */
@Getter
@AllArgsConstructor
public enum ShowTypeEnum {

    TOP15(15),
    BOTTOM15(-15),
    ALL(0);

    private Integer limit;

    public static void main(String[] args) {
        ShowTypeEnum showTypeEnum = ShowTypeEnum.values()[3];

        System.out.println(showTypeEnum);
    }
}
