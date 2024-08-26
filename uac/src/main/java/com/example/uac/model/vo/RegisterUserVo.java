package com.example.uac.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterUserVo {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空！")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

}
