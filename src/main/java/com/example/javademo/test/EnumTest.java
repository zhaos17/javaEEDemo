package com.example.javademo.test;

import com.example.javademo.modal.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: zhaos
 * @date: 2020/12/11
 */
public class EnumTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<UUID> uuidList = new ArrayList<>();
        uuidList.add(UUID.randomUUID());

        User user = new User();
        user.setAge(1);
        user.setName("zs");
        user.setUuidList(uuidList);

        System.out.println("初始的user：" + user);

        changeVal(user);
//        changeVal(user.clone());
        System.out.println("changeVal之后的user：" + user);
    }

    public static void changeVal(User user) {
        List<UUID> uuidList = new ArrayList<>(user.getUuidList());
        uuidList.add(UUID.randomUUID());

//        user.setUuidList(uuidList);
        System.out.println("changeVal中的user：" + uuidList);
    }

}
