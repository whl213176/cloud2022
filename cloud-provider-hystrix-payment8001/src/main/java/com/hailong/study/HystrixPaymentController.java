package com.hailong.study;

import cn.hutool.core.util.IdUtil;
import com.hailong.study.service.HystrixPaymentService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@RestController
@Slf4j
public class HystrixPaymentController {

  @Autowired
  HystrixPaymentService service;

  @GetMapping("/payment/hystrix/ok/{id}")
  public String getOk(@PathVariable("id") Integer id) {
    String result = service.PaymentInfo_Ok(id);
    log.info("result:" + result);
    return result;
  }

  @GetMapping("/payment/hystrix/timeOut/{id}")
  public String getTimeOut(@PathVariable("id") Integer id) {
    String result = service.PaymentInfo_TimeOut(id);
    log.info("result:" + result);
    log.info("测试push");
    log.info("测试pull");
    return result;
  }

  public static void main(String[] args) {
    String string = UUID.randomUUID().toString();
    System.out.println(string);
    String s = IdUtil.simpleUUID();
    System.out.println(s);
  }
}
