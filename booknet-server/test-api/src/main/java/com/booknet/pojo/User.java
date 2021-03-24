package com.booknet.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author zichang
 * @Date 2021/3/24 20:11
 * @Description
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    private String openid; //主键，隐藏
    private String name;
    private String school;
    private String avatar;
    private int status = 0;
    private String field = "";
}
