package com.hailong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuhailong
 * @date 2022/6/28.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(NacosOrderMain80.class, args);
  }

}
