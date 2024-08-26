package com.example.order.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : zhaojh
 * @date : 2024-04-30
 * @function :
 */

@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}