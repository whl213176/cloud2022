package com.hailong.mySelfRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * @author wuhailong
 * @date 2022/6/9.
 */

@Configuration
public class MySelfRule {

  @Bean
  public IRule getMyRule() {
    return new RandomRule(); //定义为随机
  }

}
