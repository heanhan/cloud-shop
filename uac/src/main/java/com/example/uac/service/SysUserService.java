package com.example.uac.service;

import com.example.uac.entity.User;
import com.example.uac.model.vo.RegisterUserVo;

public interface SysUserService {

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return SystemUser
     */
    User findByUsername(String username);

    /**
     * 用户注册
     * @param param 用户
     * @return Boolean
     */
    Boolean registerUser(RegisterUserVo param);
}
