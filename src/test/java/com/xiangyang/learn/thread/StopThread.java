package com.xiangyang.learn.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(stopRequested);
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                System.out.println("aaa:"+stopRequested);
                while (!stopRequested)
                    i++;

            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("这个是睡了两秒");
        stopRequested = true;
//        requestStop();
    }
}
