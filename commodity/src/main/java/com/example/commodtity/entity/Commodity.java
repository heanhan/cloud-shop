package com.example.commodtity.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2024-04-30
 * @function :
 */

@Data
public class Commodity implements Serializable {

    private Long id;

    /**用户id*/
    private Long commodityId;

    /**标签*/
    private List<Tag> tags;

    /**
     * 上架 ：true上架，false 下架
     */
    private Boolean shelves;

    /**
     * 价格
     */
    private Double price;

    /**
     * 推荐
     */
    private Integer recommend;

}