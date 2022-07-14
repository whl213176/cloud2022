package com.hailong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient   //服务发现
@EnableDiscoveryClient
@EnableScheduling  //swagger集成
@EnableSwagger2  //swagger
public class PaymentMain8001 {

  public static void main(String[] args) {

    SpringApplication.run(PaymentMain8001.class, args);
  }

}
