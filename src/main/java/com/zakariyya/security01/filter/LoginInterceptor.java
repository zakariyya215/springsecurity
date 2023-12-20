package com.zakariyya.security01.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //在执行controller方法之前执行
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
//        /**
//         * 首先判断是否为HandlerMethod
//         * 判断token是否为空，如果为空跳转到登录页
//         * 如果不为空登录验证loginService,checkToken
//         * 如果认证成功，放行
//         */
//        if (!(handler instanceof HandlerMethod)) {
//            //handler可能是RequestResourceHandler
//            return true;
//        }
//        String token = request.getHeader("Authorization");
//        if (StringUtils.isBlank(token)) {
////            throw new BadCredentialsException("未登录");
//            Map<String,Object> resultMap = new HashMap<>();
//            resultMap.put("code",403);
//            resultMap.put("msg","未登录");
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().println(JSONUtil.toJsonStr(resultMap));
//            return false;
//        }
//        return false;
        return true;
    }
}
