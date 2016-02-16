package com.orange.service.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/14 0014.
 *
 * 关于实体类、序列化说明：
 * 1.如果使用Serializable来序列化，
 * 可以用Mybatis Reverse的方式，从数据库表里，
 * 自动生成和数据表对应的的实体类（如果数据表字段很多的情况下话）。
 *
 * 2.关于序列化传输，可以使用protobuffer来自动生成类，可快速序列化等，跨语言支持C++、python、java
 */
//如果需要把实体类序列化话，加上@XmlRootElement注解
@XmlRootElement
public class User implements Serializable{

    private String userId;

    private String username;

    public User() {
    }

    public User(String Id,String username) {
        this.userId = Id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId +
                "', username='" + username + '\'' +
                '}';
    }

}
