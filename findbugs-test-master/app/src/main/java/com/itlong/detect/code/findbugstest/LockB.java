package com.itlong.detect.code.findbugstest;

import android.util.Log;

import java.util.Date;

/**
 * @author HUQINGHUI
 */
public class LockB implements Runnable {
    @Override
    public void run() {
        try {
            Log.d("SpotBugs", new Date().toString() + " LockB 开始执行");
            synchronized (LockTest.obj2) {
                Log.d("SpotBugs", new Date().toString() + " LockB 锁住 obj2");
                synchronized (LockTest.obj1) {
                    Log.d("SpotBugs", new Date().toString() + " LockB 锁住 obj1");
                }
            }
            Log.d("SpotBugs", new Date().toString() + " LockB 执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
