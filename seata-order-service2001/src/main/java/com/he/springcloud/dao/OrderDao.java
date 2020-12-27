package com.he.springcloud.dao;

import com.he.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

//    新建订单
    void create(Order order);
//    修改订单状态，将status从0改成1
    void update(@Param("userId")Long userId,@Param("status")Integer status);

}
