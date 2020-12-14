package com.he.springcloud.dao;

import com.he.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {

    Payment getPayment(@Param("id") Long id);

}
