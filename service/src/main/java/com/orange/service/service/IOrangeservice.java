package com.orange.service.service;

import com.orange.service.domain.User;

import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/14 0014.
 */
public interface IOrangeservice {

    //在这里写你的服务提供的相关方法
    String hello();
    String hello(String id);

    Map getUserInfoByUsername(String username);
    Map getUserInfoByUserMap(User user);
    User getUserInfoByUser(User user);

    int insertDataByUsername(String username);

    int deleteDataByUsername(String username);

    int updataDataByUsername(String username,String updataforuserid);
}
