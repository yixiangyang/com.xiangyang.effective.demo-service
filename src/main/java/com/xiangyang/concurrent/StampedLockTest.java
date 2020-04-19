package com.xiangyang.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * Java8新引入的StampedLock 读写锁
 */
public class StampedLockTest {
    private static final StampedLock lock = new StampedLock();

    private static Map<String,String> mapCache = new HashMap<String, String>();

    //模拟数据库存储的数据
    private static Map<String,String> mapDB = new HashMap<String, String>();

    static {
        mapDB.put("zhangsan","你好张三");
        mapDB.put("lisi","你好李四");
    }

    private static String getInfo(String name){
        long stamp = lock.readLock();
        try {
            String info = mapCache.get(name);
            if(null != info){
                System.out.println("在缓存中获得了数据"+info);
                return info;
            }
        }finally {
            //释放悲观锁
            lock.unlock(stamp);
        }
        //获取写锁
        stamp = lock.writeLock();
        try {
            //判断写缓存是否被插入了数据
            String info = mapCache.get(name);
            if(null != info){
                System.out.println("获取到了写锁，再次确认在缓存中获取到了数据");
                return info;
            }
            //这里是往数据库获取数据
            String infoByDB = mapDB.get(name);
            //将数据插入到缓存中
            mapCache.put(name,infoByDB);
            System.out.println("缓存中没有数据，在数据库中获取到了数据");
        }finally {
            //释放写锁
            lock.unlock(stamp);
        }
        return null;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
           getInfo("zhangsan");
        });
        Thread t2 = new Thread(() ->{
            getInfo("zhangsan");
        });
        //线程启动
        t1.start();
        t2.start();
        //线程同步
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

