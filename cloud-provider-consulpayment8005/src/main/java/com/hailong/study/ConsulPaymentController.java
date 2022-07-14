package com.hailong.study;

import java.util.UUID;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuhailong
 * @date 2022/6/8.
 */

@RestController
@Slf4j
public class ConsulPaymentController {

  @Value("${server.port}")
  private String serverPort;

  @RequestMapping(value = "/payment/consul")
  public String paymentConsul()
  {
    return "springcloud with consul: "+serverPort+"\t   "+ UUID.randomUUID().toString();
  }
}
