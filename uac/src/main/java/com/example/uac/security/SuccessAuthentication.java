package com.example.uac.security;

import com.example.common.result.ResultBody;
import com.example.uac.entity.User;
import com.example.uac.model.dto.AuthenticationUser;
import com.example.uac.utils.JSONUtils;
import com.example.uac.utils.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhaojh
 * @Date: 2024-08-26 15:43
 * @Description : 登录认证成功的处理
 */
@Component
public class SuccessAuthentication implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication auth) throws IOException {
        AuthenticationUser authUser = (AuthenticationUser) auth.getPrincipal();
        User user = authUser.getUser();
//        LoginUser loginInfo = new LoginUser();
//        loginInfo.setUserId(user.getId());
//        loginInfo.setTenantId(user.getTenantId());
        String token = JwtUtil.createToken(authUser.getUsername(), JwtUtil.TOKEN_SECRET);
        Map<String, Object> map = new HashMap<>(7);
        map.put("username", user.getUsername());
        map.put("nickname", user.getNickname());
        map.put("type", user.getType());
        map.put("id", user.getId());
        map.put("avatar", user.getAvatar());
        map.put(JwtUtil.TOKEN_HEADER,token);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSONUtils.toString(ResultBody.success(map)));
    }
}