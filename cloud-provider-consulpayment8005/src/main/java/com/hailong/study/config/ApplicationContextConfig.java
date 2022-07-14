package com.hailong.study.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuhailong
 * @date 2022/6/8.
 */

@Configuration
public class ApplicationContextConfig {

  @Bean
  @LoadBalanced //软负载均衡，轮询
  public RestTemplate getTemplate() {
    return new RestTemplate();
  }
}
