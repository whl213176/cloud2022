package com.zookeeper.study;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author wuhailong
 * @date 2022/6/6.
 */

@Slf4j
public class TestCurator {

  public static void main(String[] args) {
    InterProcessMutex interProcessMutex = new InterProcessMutex(getCuratorFrameWork(), "/sanguo");
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          interProcessMutex.acquire();
          log.info("线程1获取到锁");
          interProcessMutex.acquire();
          log.info("线程1再次获取到锁");
          Thread.sleep(5 * 1000);
          interProcessMutex.release();
          log.info("线程1释放锁");
          interProcessMutex.release();
          log.info("线程1再次释放锁");
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          interProcessMutex.acquire();
          log.info("线程2获取到锁");
          interProcessMutex.acquire();
          log.info("线程2再次获取到锁");
          Thread.sleep(5 * 1000);
          interProcessMutex.release();
          log.info("线程2释放锁");
          interProcessMutex.release();
          log.info("线程2再次释放锁");
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  private static CuratorFramework getCuratorFrameWork() {
    ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);
    CuratorFramework client = CuratorFrameworkFactory.builder()
        .connectString("192.168.1.14:2181,192.168.1.15:2181,192.168.1.16:2181")
        .connectionTimeoutMs(2000).sessionTimeoutMs(3000)
        .retryPolicy(policy)
        .build();
    client.start();
    log.info("zookeeper启动成功");
    return client;
  }

}
