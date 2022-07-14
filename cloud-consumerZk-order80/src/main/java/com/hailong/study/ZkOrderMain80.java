package com.hailong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuhailong
 * @date 2022/6/7.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(ZkOrderMain80.class, args);
  }

}
