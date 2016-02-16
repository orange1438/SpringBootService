package com.orange.service.service.impl;

import com.orange.service.dao.IOrangeserviceDao;
import com.orange.service.domain.User;
import com.orange.service.service.IOrangeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/14 0014.
 */
@Service
public class OrangeserviceImpl implements IOrangeservice {

    @Autowired
    private IOrangeserviceDao orangeserviceDao;

    @Override
    public String hello() {
        return "hello world.....";
    }

    @Override
    public String hello(String id) {
        return "hello world!!! "+id;
    }

    @Override
    public Map getUserInfoByUsername(String username) {
        return orangeserviceDao.getUserInfoByUsername(username);
    }

    @Override
    public Map getUserInfoByUserMap(User user) {
        return orangeserviceDao.getUserInfoByUsername(user);
    }

    @Override
    public User getUserInfoByUser(User user) {
        return orangeserviceDao.getUserInfoByUsernameForUser(user);
    }

    @Override
    public int insertDataByUsername(String username) {
        return orangeserviceDao.insertDataByUsername(username);
    }

    @Override
    public int deleteDataByUsername(String username) {
        return orangeserviceDao.deleteUsername(username);
    }

    @Override
    public int updataDataByUsername(String username,String updataforuserid) {
        return orangeserviceDao.updataByUsername(username,updataforuserid);
    }

}
