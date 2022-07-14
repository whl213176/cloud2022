package com.hailong.springcloud.service;

import com.hailong.springcloud.entities.Payment;

/**
 * @author wuhailong
 * @date 2022/5/23.
 */


public interface PaymentService {

  int createPayment(Payment payment);

  Payment selectPayment(long id);

}
