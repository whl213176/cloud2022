package com.hailong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuhailong
 * @date 2022/6/17.
 */

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain {

  public static void main(String[] args) {
    SpringApplication.run(GatewayMain.class, args);
  }

}
