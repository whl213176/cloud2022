package com.hailong.mySelfRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import io.swagger.models.auth.In;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuhailong
 * @date 2022/6/9.
 */

@Configuration
public class MySelfRule {

  @Bean
  public IRule getMyRule() {
    return new RandomRule();//定义为随机 atomic
  }

//  public static void main(String[] args) {
//    Integer a = new Integer(5);
//    AtomicInteger atomicInteger = new AtomicInteger(5);
//    boolean b = atomicInteger.compareAndSet(5, 2019);
//    System.out.println(b+","+atomicInteger.get());
//    boolean b1 = atomicInteger.compareAndSet(2020, 3);
//    System.out.println(b1+","+atomicInteger.get());
//    System.out.println(atomicInteger.get());
//  }
}
