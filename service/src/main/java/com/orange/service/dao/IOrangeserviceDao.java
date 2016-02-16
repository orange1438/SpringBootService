package com.orange.service.dao;


import com.orange.service.domain.User;

import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/1/6 0006.
 */
public interface IOrangeserviceDao {

    Map getUserInfoByUsername(String username);

    /* 以下2个类传递，均可*/
    User getUserInfoByUsernameForUser(User user);
    Map getUserInfoByUsername(User user);

    int insertDataByUsername(String username);

    int deleteUsername(String username);

    int updataByUsername(String username,String updataforuserid);

}
