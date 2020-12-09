package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: zhaos
 * @date: 2020/12/9
 */
//@Data // get set 方法
@Accessors(chain = true) // 开启链式写法
@AllArgsConstructor // 有参构造
@NoArgsConstructor // 无参构造
public class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    private static String username;
    private transient String passwd;

    //    private static String stac = "静态";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


}
