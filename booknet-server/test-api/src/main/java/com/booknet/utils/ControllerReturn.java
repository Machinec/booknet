package com.booknet.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author zichang
 * @Date 2021/3/24 20:25
 * @Description
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) // 支持链式写法
public class ControllerReturn {
//    public static int SUCCESS_CODE = 200;
//    public static int FAIL_CODE = 400;

    int code;
    String message;
    Object data;

    public ControllerReturn(int code, String message){
        this.code = code;
        this.message = message;
        data = null;
    }
}
