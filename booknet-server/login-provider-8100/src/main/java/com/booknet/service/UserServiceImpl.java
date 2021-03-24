package com.booknet.service;

import com.alibaba.fastjson.JSONObject;
import com.booknet.dao.UserDao;
import com.booknet.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author zichang
 * @Date 2021/3/24 20:56
 * @Description
 */

@Service
public class UserServiceImpl implements UserService {

    private static final String APP_ID = "wxe858bf5a3dfe93a7";
    private static final String APP_SECRET = "f1573eec82d8fe831012c37e517c57ac";


    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public String login(String code, User user) {
        String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+
                APP_ID+"&secret="+APP_SECRET+"&js_code="+code+"&grant_type=authorization_code";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(code2SessionUrl,String.class);
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String openid = (String) jsonObject.getString("openid");
        String session_key = (String) jsonObject.getString("session_key");
        // 当请求失败时，openid == session_key == null
        // 请求微信接口获得openid session_key
        // 保存session_key至redis
        // 判断是否第一次登录
        // 生成返回token
        return "openid=" + openid + "  session_key=" + session_key;
    }

}
