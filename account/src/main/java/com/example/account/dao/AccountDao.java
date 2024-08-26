package com.example.account.dao;

import com.example.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description : 账户的持久层
 * @Author : zhaojh
 * @Date : 2024/8/14 15:23
 */

@Repository
public interface AccountDao extends JpaRepository<Account, Long> , JpaSpecificationExecutor<Account> {
}
