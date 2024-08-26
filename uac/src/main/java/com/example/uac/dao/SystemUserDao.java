package com.example.uac.dao;

import com.example.uac.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserDao extends JpaRepository<SystemUser, Long>, JpaSpecificationExecutor<SystemUser> {


    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    SystemUser findByUsername(String username);
}
