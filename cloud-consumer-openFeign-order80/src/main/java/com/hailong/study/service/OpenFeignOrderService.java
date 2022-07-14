package com.hailong.study.service;

import com.hailong.springcloud.entities.Payment;
import com.hailong.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignOrderService {
  @GetMapping("/get/payment/{id}")
  CommonResult<Payment> selectPayment(@PathVariable("id") long id);
  @GetMapping("/get/sleep")
  String getSleep();

}
