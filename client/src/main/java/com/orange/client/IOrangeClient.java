package com.orange.client;

import com.orange.client.domain.User;
import com.orange.client.exception.ClientException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 *
 * 该接口，对应同service项目下webservice的接口
 */
public interface IOrangeClient {
    Map test(String id) throws ClientException,IOException;
    String hello1(String id) throws ClientException,IOException;
    String hello2(String id) throws ClientException,IOException;

    int insertDataByUsername(String username) throws ClientException,IOException;

    int deleteDataByUsername(String username) throws ClientException,IOException;

    int updataDataByUsername(String username,String updataforuserid) throws ClientException,IOException;

    Map getUserInfoByUsername(String username) throws ClientException,IOException;
    Map getUserInfoByUserMap(User user) throws ClientException,IOException;
    User getUserInfoByUser(User user) throws ClientException,IOException;
}
