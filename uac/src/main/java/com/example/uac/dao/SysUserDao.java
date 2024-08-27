package com.example.uac.dao;

import com.example.uac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {


    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
}
