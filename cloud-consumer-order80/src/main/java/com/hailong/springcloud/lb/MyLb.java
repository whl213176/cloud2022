package com.hailong.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @author wuhailong
 * @date 2022/6/10.
 */

@Component
public class MyLb implements LoadBalancer {
  //设置初始值，相当于主内存中原始的值
  private AtomicInteger atomicInteger = new  AtomicInteger(0);
  public final int getAndIncrement(){
    int current;
    int next;
    do {
      current = this.atomicInteger.get();
      next = current  >= 2147483647? 0 : current+1;
    }while (!this.atomicInteger.compareAndSet(current,next));
    System.out.println("***********第"+next+"次访问************");
    return  next;
  }

  @Override
  public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启动后rest接口计数从1开始
    int size = serviceInstances.size();
    return serviceInstances.get(getAndIncrement()%size);
  }

}
