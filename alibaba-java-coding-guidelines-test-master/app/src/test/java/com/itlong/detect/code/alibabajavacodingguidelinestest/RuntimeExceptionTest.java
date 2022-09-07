package com.itlong.detect.code.alibabajavacodingguidelinestest;

import android.os.SystemClock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RuntimeExceptionTest {
    @Test
    public void test() {
        try {
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("捕获到异常:" + e.getMessage());
        }
    }

    @Test
    public void test01() {
        try {
            throw new RuntimeException("RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("捕获到异常:" + e.getMessage());
        }
    }

    @Test
    public void test02() {
        try {
            throw new RuntimeException("RuntimeException");
        } catch (Throwable e) {
            System.out.println("捕获到异常:" + e.getMessage());
        }
    }


    public class ExceptionThread implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException("这个线程就干了这么一件事，抛出一个运行时异常");
        }
    }

    @Test
    public void test04() {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
            System.out.println("该干嘛干嘛去");
        } catch (RuntimeException e) {
            System.out.println("能不能捕获到异常？");
        }
        SystemClock.sleep(5000);
    }
}
