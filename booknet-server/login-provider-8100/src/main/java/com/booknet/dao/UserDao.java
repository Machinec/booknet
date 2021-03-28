package com.booknet.dao;

import com.booknet.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author zichang
 * @Date 2021/3/24 20:50
 * @Description
 */

@Mapper
@Repository
public interface UserDao {

    @Insert("insert into user(openid, name, school, avatar, status, field) " +
    "values(#{openid}, #{name}, #{school}, #{avatar}, #{status}, #{field})")
    int insertUser(User user);

    @Select("select * from user where openid = #{openid}")
    User selectByOpenid(String openid);
}
