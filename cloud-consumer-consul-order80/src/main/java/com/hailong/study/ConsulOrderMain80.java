package com.hailong.study;

import com.hailong.mySelfRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wuhailong
 * @date 2022/6/8.
 */

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class ConsulOrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(ConsulOrderMain80.class, args);
  }

}
