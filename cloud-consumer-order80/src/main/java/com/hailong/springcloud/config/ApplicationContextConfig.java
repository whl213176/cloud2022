package com.hailong.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuhailong
 * @date 2022/5/23.
 * @Description ribbon是在业务内的负载均衡，有7中负载均衡方式，默认为轮询，轮询算法的公式为： rest接口的第几次请求数 % 服务器集群总数量 =
 * 实际调用服务器位置下标，每次服务重启后下标从1开始
 * List<ServiceInstance> instance = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")
 * 如：list[0] = 172.0.0.1:8002
 * list[1] = 172.0.0.1:8001
 */

@Configuration
public class ApplicationContextConfig {


//  @LoadBalanced
  @Bean
  public RestTemplate loadBalanced1() {
    return new RestTemplate(); // 负载均衡轮询算法
  }

//  @Primary
//  @Bean
//  public RestTemplate restTemplate() {
//    return new RestTemplate();
//  }
}
//applicationContext.xml<bean id="" class="">
