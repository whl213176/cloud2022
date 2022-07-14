package com.hailong.springcloud.controller;

import com.hailong.springcloud.entities.Payment;
import com.hailong.springcloud.lb.LoadBalancer;
import com.hailong.springcloud.util.CommonResult;
import java.net.URI;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuhailong
 * @date 2022/5/23.
 */

@RestController
@Slf4j
public class OrderController {

  @Autowired
  RestTemplate restTemplate;

  @Resource
  private DiscoveryClient discoveryClient;

  @Autowired
  private LoadBalancer loadBalancer;


  //  public static final String PAYMENT_URL = "http://localhost:8001";
//  public static final String PAYMENT_URL = "http://localhost:8002";
  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

  @GetMapping("/consumer/get/payment/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
    log.info("开始调用");
    return restTemplate.getForObject(PAYMENT_URL + "/get/payment/" + id, CommonResult.class);
  }

  @GetMapping("/consumer/insert/payment")
  public CommonResult<Payment> create(Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "/insert/Payment", payment, CommonResult.class);
  }

  @GetMapping("/consumer/payment/discovery")
  public CommonResult<Object> getService() {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", CommonResult.class);
  }
  @GetMapping("/consumer/payment/lb")
  public String getLb(){
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    if(instances == null || instances.size() <= 0)
    {
      return null;
    }
    ServiceInstance serviceInstance = loadBalancer.getInstance(instances);
    URI uri = serviceInstance.getUri();

    return restTemplate.getForObject(uri+"/payment/lb",String.class);
  }
}
