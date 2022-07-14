package com.hailong.study;

import com.hailong.springcloud.entities.Payment;
import com.hailong.springcloud.util.CommonResult;
import com.hailong.study.service.OpenFeignOrderService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@RestController
public class OpenFeignOrderController {

  @Resource
  OpenFeignOrderService openFeignOrderService;

  @GetMapping("/consumer/get/payment/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
    return openFeignOrderService.selectPayment(id);
  }
  @GetMapping("consumer/get/sleep")
  public String getSleep(){
    return openFeignOrderService.getSleep();

  }
}
