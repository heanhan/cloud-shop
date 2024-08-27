package com.example.uac.service;

import com.example.uac.entity.Role;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-08-27
 */
public interface RoleService {

    /**
     * 通过角色id 查找角色信息
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);
}
