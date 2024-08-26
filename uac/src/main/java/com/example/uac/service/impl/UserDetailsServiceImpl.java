package com.example.uac.service.impl;

import com.example.uac.entity.SystemUser;
import com.example.uac.service.SystemUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SystemUserService systemUserService;

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return 返回用户详情
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser byUsername = systemUserService.findByUsername(username);
        if(!ObjectUtils.isEmpty(systemUserService)){

        }
        return null;
    }
}
