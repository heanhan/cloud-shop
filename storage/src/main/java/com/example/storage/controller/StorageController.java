package com.example.storage.controller;

import com.example.storage.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zhaojh
 * @date : 2024-08-08
 * @function :
 */

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageServiceImpl;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @RequestMapping("/decrease")
    public String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageServiceImpl.decrease(productId,count);
        return "Decrease storage success";
    }
}
