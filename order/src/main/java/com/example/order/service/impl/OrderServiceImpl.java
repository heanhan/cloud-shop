package com.example.order.service.impl;

import com.example.order.entity.Order;
import com.example.order.feign.AccountFeign;
import com.example.order.feign.StorageFeign;
import com.example.order.mapper.OrderDao;
import com.example.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author : zhaojh
 * @date : 2024-08-08
 * @function :
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageFeign storageFeign;

    @Resource
    private AccountFeign accountFeign;


    /**
     * 创建订单
     * @param order
     * @return
     * 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
    @GlobalTransactional(name = "create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->交易开始");
        //本地方法
//        orderMapper.create(order);

        //远程方法 扣减库存
        storageFeign.decrease(order.getProductId(),order.getCount());

        //远程方法 扣减账户余额

        log.info("------->扣减账户开始order中");
        accountFeign.decrease(order.getUserId(),order.getMoney());
        log.info("------->扣减账户结束order中");

        log.info("------->交易结束");
    }

    /**
     * 修改订单状态
     */
    @Override
    public void update(Long userId, BigDecimal money, Integer status) {
        log.info("修改订单状态，入参为：userId={},money={},status={}",userId,money,status);
//        orderMapper.update(userId,money,status);
    }
}
