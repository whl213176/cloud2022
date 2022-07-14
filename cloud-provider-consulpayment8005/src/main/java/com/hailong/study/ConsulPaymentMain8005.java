package com.hailong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuhailong
 * @date 2022/6/8.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8005 {

  public static void main(String[] args) {
    SpringApplication.run(ConsulPaymentMain8005.class, args);
  }

}
