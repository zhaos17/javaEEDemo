package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhaos
 * @date: 2020/12/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int id;

    private String desc;

    private double db;
}