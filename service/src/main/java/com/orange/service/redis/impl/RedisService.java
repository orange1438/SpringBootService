package com.orange.service.redis.impl;

import com.orange.service.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 * 目前模版使用的spring boot自带的redis，其他的jedis包也可以代替它
 * 具体的api，请参考各自的文档
 */
@Service
public class RedisService implements IRedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void textfun() {
        SetOperations set = stringRedisTemplate.opsForSet();
        set.add("openid", "oevMOt4FQdG5wxAuKUEWQ7H1C-Y");
        System.out.println("!CollectionUtils.isEmpty(set.members( \"openid\")) = " + !CollectionUtils.isEmpty(set.members("openid")));
        System.out.println("set.members(\"openid\") = " + set.members("openid"));
        System.out.println("set.members(\"openid\").toString() = " + set.members("openid").toString());
        try {
            Thread.sleep(1500);
            System.out.println("!CollectionUtils.isEmpty(set.members( \"openid\")) = " + !CollectionUtils.isEmpty(set.members("openid")));
            stringRedisTemplate.expire("openid", 0, TimeUnit.SECONDS);
            Thread.sleep(1500);
            System.out.println("!CollectionUtils.isEmpty(set.members(\"openid\"))) = " + !CollectionUtils.isEmpty(set.members("openid")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
