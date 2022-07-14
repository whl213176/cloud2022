package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableSwagger2
@EnableDiscoveryClient
public class PaymentMain8002 {

  public static void main(String[] args) {

    SpringApplication.run(PaymentMain8002.class, args);
  }

}
