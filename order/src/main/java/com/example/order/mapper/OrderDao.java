package com.example.order.mapper;


import com.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> , JpaSpecificationExecutor<Order> {

    /**
     * 创建订单
     * @param order
     * @return
     */
//    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param money
     */
}
