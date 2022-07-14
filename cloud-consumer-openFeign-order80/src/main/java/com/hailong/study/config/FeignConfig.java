package com.hailong.study.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@Configuration
public class FeignConfig {
  @Bean  //配置feign的日志级别为最高级别，在使用feign调用服务提供接口时显示日志
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

}
