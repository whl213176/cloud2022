package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wuhailong
 * @date 2022/5/24.
 */

@SpringBootApplication
@EnableEurekaServer//代表是eureka的服务端，注册中心
public class EurekaMain7001 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain7001.class, args);
  }

}
