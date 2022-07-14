package com.hailong.study.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@Service
@Slf4j
public class HystrixPaymentService {

  public String PaymentInfo_Ok(Integer id) {
    return "线程池:" + Thread.currentThread().getName() + "PaymentInfo_Ok,id" + id + "\t";
  }

  //  @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//  })
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
  })

  public String PaymentInfo_TimeOut(Integer id) {
    try {
//      int a = 10/0;
      Integer number = 2;
      TimeUnit.SECONDS.sleep(number);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return "线程池:" + Thread.currentThread().getName() + "PaymentInfo_TimeOut,id" + id + "\t,耗时3秒";
  }

  public String paymentInfo_TimeOutHandler(Integer id) {
    return "/(ㄒoㄒ)/~~调用支付接口超时或者异常，当前线程池名字:" + Thread.currentThread().getName() + ",请稍后再试";
  }
}
