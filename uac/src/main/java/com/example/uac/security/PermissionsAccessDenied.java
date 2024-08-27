package com.example.uac.security;

import com.alibaba.fastjson.JSON;
import com.example.common.result.ResultBody;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : zhaojh
 * @Date: 2024-08-26 16:15
 * @Description : 权限不足403处理器 统一处理 AccessDeniedException 异常
 */
@Component
public class PermissionsAccessDenied implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(JSON.toJSONString(ResultBody.error(403,
                "未授权")));
        out.flush();
        out.close();
    }
}
