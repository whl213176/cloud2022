/*
package com.hailong.springcloud;


import java.io.IOException;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

*/
/**
 * @author wuhailong
 * @date 2022/6/5.
 *//*



public class zkClient {

  private String connectString = "192.168.1.14:2181,192.168.1.15:2181,192.168.1.16:2181";
  private int sessionTimeout = 2000;
  private ZooKeeper zooKeeper;

  @Before
  public void init() throws IOException {

    zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
      @Override
      public void process(WatchedEvent watchedEvent) {
//        System.out.println("---------------------------------");
//        List<String> children = null;
//        try {
//          children = zooKeeper.getChildren("/", true);
//          for (String str : children) {
//            System.out.println(str);
//          }
//          System.out.println("---------------------------------");
//        } catch (KeeperException e) {
//          e.printStackTrace();
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//
      }
    });
  }

  //创建节点
  @Test
  public void create() throws KeeperException, InterruptedException {
    String s = zooKeeper
        .create("/sanguo", "zhangsan".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

  }

  //监听节点
  @Test
  public void getChildren() throws KeeperException, InterruptedException {
    List<String> children = zooKeeper.getChildren("/", true);
    for (String str : children) {
      System.out.println(str);
    }
  }

  //判断某个节点是否存在
  @Test
  public void exists() throws KeeperException, InterruptedException {
    Stat exists = zooKeeper.exists("/sanguo", false);
    System.out.println(exists == null ? "not exists" : "exists");
  }
}
*/
