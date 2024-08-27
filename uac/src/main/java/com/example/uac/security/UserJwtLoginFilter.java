package com.example.uac.security;

import com.example.common.enums.ExceptionCode;
import com.example.common.exceptins.BizException;
import com.example.uac.model.dto.LoginUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录验证过滤器
 * <p>
 * 该类继承自UsernamePasswordAuthenticationFilter
 * attemptAuthentication ：接收并解析用户凭证。
 *
 * @author zhaojh
 */
@Component
public class UserJwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    @Resource
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Qualifier("failureAuthentication")
    @Resource
    @Override
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    @Qualifier("successAuthentication")
    @Resource
    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    public UserJwtLoginFilter() {
        super.setFilterProcessesUrl("/api/login");
    }

    /**
     * 接收并解析用户凭证
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            //从输入流中获取到登录的信息
            LoginUser loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                    loginUser.getPassword()));
        } catch (IOException e) {
            throw new BizException(ExceptionCode.ARGUMENT.getCode(), "登录字段有误");
        }
    }
}