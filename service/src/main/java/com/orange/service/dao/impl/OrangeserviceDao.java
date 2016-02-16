package com.orange.service.dao.impl;


import com.orange.service.dao.IOrangeserviceDao;
import com.orange.service.dao.mapper.IOrangeserviceMapper;
import com.orange.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/1/6 0006.
 */
@Repository
public class OrangeserviceDao implements IOrangeserviceDao {

    @Autowired
    private IOrangeserviceMapper orangeserviceMapper;

    @Override
    public Map getUserInfoByUsername(String username) {
        return orangeserviceMapper.getUserInfoByUsername(username);
    }

    @Override
    public User getUserInfoByUsernameForUser(User user) {
        return orangeserviceMapper.getUserInfoByUserForUser(user);
    }

    @Override
    public Map getUserInfoByUsername(User user) {
        return orangeserviceMapper.getUserInfoByUser(user);
    }


    @Override
    public int insertDataByUsername(String username){
        return orangeserviceMapper.insertDataBydata(UUID.randomUUID().toString(),username);
    }

    @Override
    public int deleteUsername(String username) {
        return orangeserviceMapper.deleteUserInterest(username);
    }

    @Override
    public int updataByUsername(String username,String updataforuserid) {
        return orangeserviceMapper.updataByUsername(username,updataforuserid);
    }

}
