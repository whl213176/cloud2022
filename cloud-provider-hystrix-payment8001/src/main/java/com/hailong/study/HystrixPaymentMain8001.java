package com.hailong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@SpringBootApplication
@EnableEurekaClient //开启eureka客户端
@EnableCircuitBreaker //与hystrix服务降级有关
public class HystrixPaymentMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(HystrixPaymentMain8001.class, args);
  }

}
