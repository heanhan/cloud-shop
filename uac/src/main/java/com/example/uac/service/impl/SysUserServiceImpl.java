package com.example.uac.service.impl;

import com.example.uac.dao.SysUserDao;
import com.example.uac.entity.User;
import com.example.uac.model.vo.RegisterUserVo;
import com.example.uac.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: 用户的业务员层
 * @date 2024-08-27
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;
    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return SystemUser
     */
    @Override
    public User findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }

    /**
     * 用户注册
     *
     * @param param 用户
     * @return Boolean
     */
    @Override
    public Boolean registerUser(RegisterUserVo param) {
        return null;
    }
}
