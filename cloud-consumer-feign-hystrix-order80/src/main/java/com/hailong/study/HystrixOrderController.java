package com.hailong.study;

import com.hailong.study.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobal")
public class HystrixOrderController {

  @Resource
  PaymentService service;

  @GetMapping("/consumer/payment/hystrix/ok/{id}")
  public String PaymentInfo_Ok(@PathVariable("id") Integer id) {
    String result = service.PaymentInfo_Ok(id);
    log.info("result:" + result);
    return result;
  }

  @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
//  @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//  })
  @HystrixCommand
  public String PaymentInfo_TimeOut(@PathVariable("id") Integer id) {
    String result = service.PaymentInfo_TimeOut(id);
    log.info("result:" + result);
    return result;
  }

  public String paymentTimeOutFallbackMethod(Integer id) {
    return "我是消费者80，对方支付业务繁忙,请稍后再试或者运行出错，检查自己/(ㄒoㄒ)/~~";
  }

  public String paymentGlobal() {
    return "我是全局Global的降级方法(*^_^*)";
  }
}
