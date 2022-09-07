package com.itlong.detect.code.findbugstest;

import android.util.Log;

import java.util.Date;

/**
 * @author HUQINGHUI
 */
public class LockA implements Runnable {
    @Override
    public void run() {
        try {
            Log.d("SpotBugs", new Date().toString() + " LockA 开始执行");
            synchronized (LockTest.obj1) {
                Log.d("SpotBugs", new Date().toString() + " LockA 锁住 obj1");
                synchronized (LockTest.obj2) {
                    Log.d("SpotBugs", new Date().toString() + " LockA 锁住 obj2");
                }
            }
            Log.d("SpotBugs", new Date().toString() + " LockA 执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
