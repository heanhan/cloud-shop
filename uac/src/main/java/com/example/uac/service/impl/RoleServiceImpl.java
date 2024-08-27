package com.example.uac.service.impl;

import com.example.uac.dao.RoleDao;
import com.example.uac.entity.Role;
import com.example.uac.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-08-27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    /**
     * 通过角色id 查找角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public Role findRoleById(Integer roleId) {
        Optional<Role> byId = roleDao.findById(roleId);
        return byId.orElse(null);
    }
}
