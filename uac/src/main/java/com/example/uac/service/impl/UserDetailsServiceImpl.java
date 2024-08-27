package com.example.uac.service.impl;

import com.example.uac.entity.Role;
import com.example.uac.entity.User;
import com.example.uac.model.dto.AuthenticationUser;
import com.example.uac.service.RoleService;
import com.example.uac.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService systemUserService;

    @Resource
    private RoleService roleService;

    /**
     * 实现了UserDetailsService接口中的loadUserByUsername方法
     * 执行登录,构建Authentication对象必须的信息,
     * 如果用户不存在，则抛出UsernameNotFoundException异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = systemUserService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role = roleService.findRoleById(user.getRoleId());
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new AuthenticationUser(user, grantedAuthorities);
    }
}
