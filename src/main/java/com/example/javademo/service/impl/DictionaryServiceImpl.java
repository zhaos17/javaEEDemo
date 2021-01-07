package com.example.javademo.service.impl;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author: zhaos
 * @date: 2020/12/25
 */
public class DictionaryServiceImpl extends Dictionary<String, Action> {

    public static void main(String[] args) {
        System.out.println(fromTimeUUID(UUID.fromString("0be293f0-e697-11ea-9464-b75355ac6c2d")));
    }

    public static String fromTimeUUID(UUID src) {
        if (null == src) {
            return null;
        }

        String str = src.toString();
        // 58e0a7d7-eebc-11d8-9669-0800200c9a66 => 1d8eebc58e0a7d796690800200c9a66. Note that [11d8] -> [1d8]
        return str.substring(15, 18) + str.substring(9, 13) + str.substring(0, 8) + str.substring(19, 23) + str.substring(24);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Enumeration<String> keys() {
        return null;
    }

    @Override
    public Enumeration<Action> elements() {
        return null;
    }

    @Override
    public Action get(Object key) {
        return null;
    }

    @Override
    public Action put(String key, Action value) {
        return null;
    }

    @Override
    public Action remove(Object key) {
        return null;
    }
}
