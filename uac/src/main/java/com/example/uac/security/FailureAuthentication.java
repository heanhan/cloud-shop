package com.example.uac.security;

import com.alibaba.fastjson.JSON;
import com.example.common.result.ResultBody;
import com.example.uac.exceptions.JwtException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : zhaojh
 * @Date: 2024-08-26 15:38
 * @Description : 登录认证验证失败的处理
 */
@Component
public class FailureAuthentication implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        ResultBody<String> result;
        if (exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException) {
            result = ResultBody.error("账户名或者密码输入错误!");
        } else if (exception instanceof LockedException) {
            result = ResultBody.error("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            result = ResultBody.error("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            result = ResultBody.error("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            result = ResultBody.error("账户被禁用，请联系管理员!");
        } else if (exception instanceof JwtException) {
            result = ResultBody.error(exception.getMessage());
        } else {
            result = ResultBody.error("登录失败!");
        }
        response.getWriter().write(JSON.toJSONString(result));
    }
}