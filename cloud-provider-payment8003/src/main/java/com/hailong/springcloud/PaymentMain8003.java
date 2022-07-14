package com.hailong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuhailong
 * @date 2022/5/31.
 */

@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向作为consul zookeeper作为服务中心时注册服务
public class PaymentMain8003 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8003.class, args);
  }

}
