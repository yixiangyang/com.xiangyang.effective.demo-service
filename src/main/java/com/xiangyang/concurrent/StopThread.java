package com.xiangyang.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static  boolean stopRequested;
    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread backgroudThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                System.out.println(stopRequested +" aaaaaaa"+i);
                while (!stopRequested){
                    i++;
                    System.out.print("1");
                }
            }
        });
        backgroudThread.start();
        TimeUnit.SECONDS.sleep(30L);
        stopRequested = true;
//        requestStop();
    }
}
