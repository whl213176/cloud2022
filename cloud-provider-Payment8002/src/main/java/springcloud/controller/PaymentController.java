package springcloud.controller;

import com.hailong.springcloud.entities.Payment;
import com.hailong.springcloud.util.CommonResult;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.PaymentService;

/**
 * @author wuhailong
 * @date 2022/5/23.
 */

@RestController
//@RequestMapping("v1")
@Api("spring-cloud练习")
@Slf4j
public class PaymentController {

  @Autowired
  PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @Resource
  private DiscoveryClient discoveryClient;

  @RequestMapping(value = "/get/payment/{id}", method = RequestMethod.GET)
  public CommonResult getPayment(@PathVariable("id") long id) {
    Payment payment = paymentService.selectPayment(id);
    log.info("开始查询数据");
    if (payment != null) {
      log.info("查询成功");
      return new CommonResult(200,"查询成功 serverPort: "+serverPort, payment);
    } else {
      return new CommonResult(444,"查询失败", null);
    }

  }

  @RequestMapping(value = "/insert/Payment", method = RequestMethod.POST)
  public CommonResult createPayment(@RequestBody Payment payment) {
    Integer num = paymentService.createPayment(payment);
    log.info("开始插入数据");
    if (num > 0) {
      log.info("插入成功");
      return new CommonResult(200,String.format("插入成功,插入【%s】条数据 serverPort: "+serverPort, num), num);

    } else {
      return new CommonResult(444,"插入失败", num);
    }
  }

  @GetMapping("/payment/discovery")
  public Object getDiscoveryClient() {
    List<String> services = discoveryClient.getServices();
    for (String server : services) {
      log.info("服务列表为{}", server);
    }
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance instance : instances) {
      log.info(instance.getServiceId() + "\t" + instance.getInstanceId() + "\t" + instance.getHost()
          + "\t" + instance.getPort() + "\t" + instance.getUri());
    }
    return this.discoveryClient;
  }

  @GetMapping("/payment/lb")
  public String getLb(){
    return serverPort;
  }
}
