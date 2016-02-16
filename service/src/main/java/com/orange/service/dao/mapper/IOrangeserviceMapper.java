package com.orange.service.dao.mapper;

import com.orange.service.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/1/7 0007.
 * 参考：http://www.oschina.net/question/87022_243792
 */
public interface IOrangeserviceMapper {
    @Select("select * from test_user where username=#{username};")
    Map getUserInfoByUsername(String username);

    @Select("select * from test_user where username=#{username};")
    Map getUserInfoByUser(User user);

    @Select("select `user_id`,`username` from test_user where username=#{username};")
    User getUserInfoByUserForUser(User user);

    /* 有2个或2个以上参数的用法 */
    @Insert("INSERT INTO test_user(user_id,username) VALUES (#{userid}, #{name});")
    int insertDataBydata(@Param("userid")String userid,@Param("name")String name);

    @Delete("DELETE FROM test_user WHERE username = #{user_name}")
    int deleteUserInterest(String user_name);

    @Update("UPDATE test_user set USER_ID=#{userid} WHERE username = #{name}")
    int updataByUsername(@Param("name")String name,@Param("userid")String userid);
}
