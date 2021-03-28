package com.booknet;

import com.auth0.jwt.JWT;
import com.booknet.utils.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author zichang
 * @Date 2021/3/25 14:28
 * @Description
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("hello", "qiaomao");
    }

    @Test
    public void verifyTokenTest(){
        String SECRET_KEY = "5371d568a45e5ab1s123c38e0932aef25317139b";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVfdGltZSI6IjE2MTY2NjMwMDYyOTQiLCJ1c2VyX2lkIjoiY2Q5Yjk2NTMtMzM2ZC00NDRjLTg2ODAtYmVjOTBmZWI0Yjk5IiwiZXhwIjoxNjE3MjY3ODA2fQ.E6aQoN5ITJQ6JpHTYQQn8MDdDeIJihxeCi9at0kQrvQ";

        System.out.println("验证token");
        System.out.println(JWTUtil.verifyToken(token, SECRET_KEY));

        System.out.println("获取token中的信息");
        String user_id = JWT.decode(token).getClaim("user_id").asString();
        String create_time = JWT.decode(token).getClaim("create_time").asString();
        System.out.println(user_id);
        System.out.println(create_time);
        System.out.println("根据user_id获取redis中的信息");

        Map<String, String> map = redisTemplate.opsForHash().entries(user_id);
        System.out.println("session_key=> " + map.get("session_key"));
        System.out.println("openid" + map.get("openid"));
    }
}
