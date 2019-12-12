package com.example.account.entity.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : zhaojh
 * @date : 2019-12-12
 * @function :
 */

@Data
public class Account {

    private Long id;

    /**用户id*/
    private Long userId;

    /**总额度*/
    private BigDecimal total;

    /**已用额度*/
    private BigDecimal used;

    /**剩余额度*/
    private BigDecimal residue;
}