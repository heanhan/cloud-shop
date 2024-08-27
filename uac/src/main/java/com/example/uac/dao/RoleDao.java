package com.example.uac.dao;

import com.example.uac.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @description: 角色的持久层
 * @date 2024-08-27
 */
@Repository
public interface RoleDao extends JpaRepository<Role,Integer> , JpaSpecificationExecutor<Role> {
}
