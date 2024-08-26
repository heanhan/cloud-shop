package com.example.commodtity.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品标签 Tag
 */

@Data
public class Tag implements Serializable {

    /**
     *标签id
     */
    private Integer id;

    /**
     *标签名称
     */
    private String tagName;

    /**
     *标签描述
     */
    private String tagDesc;

    /**
     *创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
