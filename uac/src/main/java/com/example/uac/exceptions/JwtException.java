package com.example.uac.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * jwt的异常
 */
public class JwtException extends AuthenticationException {

    private Integer code;

    public JwtException() {
        super("认证操作异常");
    }

    public JwtException(String message) {
        super(message);
        //token 的凭证失效
        this.code = 401;
    }

    public JwtException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}