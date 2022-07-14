package com.hailong.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuhailong
 * @date 2022/6/28.
 */

@RestController
@Slf4j
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping(value = "/payment/nacos/{id}")
  public String getPayment(@PathVariable("id") Integer id)
  {
    return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
  }


}
