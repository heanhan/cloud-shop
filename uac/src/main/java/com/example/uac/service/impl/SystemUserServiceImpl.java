package com.example.uac.service.impl;

import com.example.uac.dao.SystemUserDao;
import com.example.uac.entity.SystemUser;
import com.example.uac.model.vo.RegisterUserVo;
import com.example.uac.service.SystemUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private BCryptPasswordEncoder encoder;

    @Resource
    private SystemUserDao systemUserDao;


    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return SystemUser
     */
    @Override
    public SystemUser findByUsername(String username) {
        return systemUserDao.findByUsername(username);
    }

    /**
     * 用户注册
     *
     * @param param 用户
     * @return Boolean
     */
    @Override
    public Boolean registerUser(RegisterUserVo param) {
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(param,systemUser);
        systemUser.setPassword(encoder.encode(param.getPassword()));
        LocalDateTime now = LocalDateTime.now();
        systemUser.setCreateTime(now);
        systemUser.setUpdateTime(now);
        SystemUser save = systemUserDao.save(systemUser);
        if (ObjectUtils.isEmpty(save)) {
            return false;
        }
        return true;
    }
}
