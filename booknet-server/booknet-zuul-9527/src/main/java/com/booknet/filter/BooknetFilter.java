package com.booknet.filter;

import com.alibaba.fastjson.JSON;
import com.booknet.config.FilterIgnoreURL;
import com.booknet.utils.JWTUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zichang
 * @Date 2021/3/25 17:24
 * @Description
 */
public class BooknetFilter extends ZuulFilter {

    // 请求头存放token字段
    private static final String REQUEST_AUTH_HEADER="Authorization";

    // token 密钥
    private static final String SECRET_KEY = "5371d568a45e5ab1s123c38e0932aef25317139b";

    //过滤器的类型，他决定过滤器在那个生命周期中执行。
    @Override
    public String filterType() {
        return "pre";
        /**
         *  Filter类型
         *  PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
         *  ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
         *  POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
         *  ERROR：在其他阶段发生错误时执行该过滤器。
         */
    }

    //定义filter的优先级，数字越小表示顺序越高，越优先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否启用filter
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 编写filter需要执行的逻辑
    @Override
    public Object run() throws ZuulException {
        // 获取请求
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        // 判断是否是白名单的url
        String requestUrl = request.getRequestURL().toString();
        // 判断url是否再 FilterIgnoreURL.urls白名单内
//        System.out.println("filter拦截url => " + requestUrl);
//        System.out.println("yml白名单 => " + FilterIgnoreURL.urls.toString());
        for (String url :
                FilterIgnoreURL.urls) {
            // 请求为白名单内的url，不做拦截处理
            if (requestUrl.contains(url)) {
                return null;
            }
        }
        /**
         从请求头中获取token
         客户端调用请求头格式：
         header: {
         'content-type': 'application/json', // 默认值
         'Authorization': 'Bearer ' + token
         },
         **/
        String token = request.getHeader(REQUEST_AUTH_HEADER);
        token = token.split(" ")[1];

        // token验证失败
        if (token == null || !JWTUtil.verifyToken(token, SECRET_KEY)){
            // 终止转发，返回响应报文
            context.setSendZuulResponse(false);
            // 设置响应报文信息
            HttpServletResponse response = context.getResponse();
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            context.setResponseStatusCode(400);
            Map<String,String> responseMap=new HashMap<String,String>();
            // 前端判断code是否为9527，重新调用wx.login接口
            responseMap.put("code", "9527");
            responseMap.put("message", "用户校验失败，请求被拦截");

            context.setResponseBody(JSON.toJSONString(responseMap));
        }

        return null;
    }
}
