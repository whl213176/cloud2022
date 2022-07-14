package com.hailong.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @author wuhailong
 * @date 2022/6/10.
 */


public interface LoadBalancer {

  /**
   * 根据传的serviceInstance服务器集合获取到对应的服务
   * @param serviceInstances
   * @return
   */
  ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
