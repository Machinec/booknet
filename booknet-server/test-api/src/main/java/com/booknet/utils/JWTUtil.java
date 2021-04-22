package com.booknet.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author zichang
 * @Date 2021/3/25 13:38
 * @Description
 */
public class JWTUtil {

    public static final long EXPIRE_TIME = 60*60*24*7;//7天

    // 请求头存放token字段
    private static final String REQUEST_AUTH_HEADER="myAuthorization";

    /*
     * @Author zichang
     * @Date 2021/3/25 13:59
     * @Description
     * @Param secret_key jwt签名密钥， session_key_id redis中小程序session_key的键值
     * @return java web token
     **/
    public static String createToken(String secret_key, String user_id){
        // 签名
        Algorithm algorithm = Algorithm.HMAC256(secret_key);
        long createTime = System.currentTimeMillis();
        String token = JWT.create()
                .withClaim("create_time", String.valueOf(createTime))
                .withClaim("user_id", user_id)
                .withExpiresAt(new Date(createTime + EXPIRE_TIME * 1000))
                .sign(algorithm);

        return token;
    }

    /*
     * @Author zichang
     * @Date 2021/3/25 17:19
     * @Description 验证token
     * @Param
     * @return
     **/
    public static boolean verifyToken(String token, String secretKey){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String getUserId(HttpServletRequest request){
        //从请求头中获取token
        String token = request.getHeader(REQUEST_AUTH_HEADER);
        token = token.split(" ")[1];
        String user_id = JWT.decode(token).getClaim("user_id").asString();
        return user_id;
    }
}
