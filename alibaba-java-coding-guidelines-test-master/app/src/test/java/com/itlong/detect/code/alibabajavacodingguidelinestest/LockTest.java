package com.itlong.detect.code.alibabajavacodingguidelinestest;

import android.os.SystemClock;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/8/31
 */
public class LockTest {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    @Test
    public void mainTest() {
        long startTime = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));
        LockA la = new LockA();
        executor.execute(la);
        LockB lb = new LockB();
        executor.execute(lb);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }
        long endTime = System.currentTimeMillis();
        long waitTime = endTime - startTime;
        System.out.println("总共消耗的时间为: " + waitTime + "ms");
    }
}

class LockA implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockA 开始执行");
            while(true){
                synchronized (LockTest.obj1) {
                    System.out.println(new Date().toString() + " LockA 锁住 obj1");
                    Thread.sleep(3000); // 此处等待是给B能锁住机会
                    synchronized (LockTest.obj2) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj2");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class LockB implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockB 开始执行");
            while(true){
                synchronized (LockTest.obj2) {
                    System.out.println(new Date().toString() + " LockB 锁住 obj2");
                    Thread.sleep(3000); // 此处等待是给A能锁住机会
                    synchronized (LockTest.obj1) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj1");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
