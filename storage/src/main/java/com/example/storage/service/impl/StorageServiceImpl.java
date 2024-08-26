package com.example.storage.service.impl;

import com.example.storage.dao.StorageDao;
import com.example.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : zhaojh
 * @date : 2024-04-30
 * @function :
 */

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->扣减库存开始");
        storageDao.deleteById(productId);
        log.info("------->扣减库存结束");
    }
}
