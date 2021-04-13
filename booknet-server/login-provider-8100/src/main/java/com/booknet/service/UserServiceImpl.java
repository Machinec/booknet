package com.booknet.service;

import com.alibaba.fastjson.JSONObject;
import com.booknet.dao.UserDao;
import com.booknet.pojo.User;
import com.booknet.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author zichang
 * @Date 2021/3/24 20:56
 * @Description
 */

@Service
public class UserServiceImpl implements UserService {

    // 微信小程序
    private static final String APP_ID = "wxe858bf5a3dfe93a7";
    private static final String APP_SECRET = "f1573eec82d8fe831012c37e517c57ac";

    // jwt签名密钥
    private static final String SECRET_KEY = "5371d568a45e5ab1s123c38e0932aef25317139b";

    private static final long EXPIRE_TIME = JWTUtil.EXPIRE_TIME;//7天


    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public String login(String code, User user) {
        // 请求微信接口获得openid session_key
        String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+
                APP_ID+"&secret="+APP_SECRET+"&js_code="+code+"&grant_type=authorization_code";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(code2SessionUrl,String.class);
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String openid = (String) jsonObject.getString("openid");
        String sessionKey = (String) jsonObject.getString("session_key");
        // 当请求失败时，openid == session_key == null
        if (openid == null || sessionKey == null){
            return null;
        }
        // 判断是否第一次登录
        User exist = userDao.selectByOpenid(openid);
        if (exist == null || exist.getStatus() == 0){
            user.setStatus(1).setField("").setOpenid(openid);
            userDao.insertUser(user);
        }
        // 保存<user_id, userInfo>至redis,
        String user_id = UUID.randomUUID().toString();
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("session_key", sessionKey);
        userInfo.put("openid", openid);
        redisTemplate.opsForHash().putAll(user_id, userInfo);
        redisTemplate.expire(user_id, EXPIRE_TIME, TimeUnit.SECONDS); // 设置redis时间
        // 生成返回token
        String token = JWTUtil.createToken(SECRET_KEY, user_id);
        return token;
    }

}
