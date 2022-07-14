package com.hailong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wuhailong
 * @date 2022/6/12.
 */

@SpringBootApplication
@EnableFeignClients
public class OpenFeignOrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OpenFeignOrderMain80.class,args);
  }

}
