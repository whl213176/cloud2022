package com.hailong.study;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuhailong
 * @date 2022/6/7.
 */

@RestController
@Slf4j
public class OrderZkController {

  @Resource
  private RestTemplate restTemplate;

  public static final String PAYMENT_URL = "http://cloud-provider-payment";
  @GetMapping(value = "/consumer/payment/zk")
  public String paymentInfo()
  {
    String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    return result;
  }
}
