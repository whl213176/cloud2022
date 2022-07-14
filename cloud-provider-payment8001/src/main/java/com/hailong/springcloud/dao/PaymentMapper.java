package com.hailong.springcloud.dao;

import com.hailong.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

  Payment selectPayment(@Param("id") long id);

  int insertPayment(Payment payment);

}
