package com.lovejjfg.detekttest.lsn03

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author HuQingHui
 * @date 2022/9/1
 */
class CommonLeakageCaseActivity : AppCompatActivity() {
    var a = 10
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this@CommonLeakageCaseActivity))

        //    loadData();
        // schedule();
        // handle();
    }

    // 1 Thread 引起:隐式持有MainActivity实例。MainActivity.this.a
    private fun loadData() {
        Thread {
            while (true) {
                try {
                    val b = a
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        // 解决方法：加上static，里面的匿名内部类就变成了静态匿名内部类
    }

    // 2 Timer
    private fun schedule() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                try {
                    val b = a
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }, 20000) // 延迟执行导致泄漏
        // 解决方法：activity onDestroy把timer.cancel掉然后赋空
    }

    // 3 mHandler是匿名内部类的实例，会引用外部对象MainActivity.this。如果Handler在Activity退出的时候，它可能还活着，这时候就会一直持有Activity。
    private var mHandler = object : Handler() {
             override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                 when (msg.what) {
                     0 -> Log.d("DetektTest", "加载数据")
                 }
            }
        }
//        private void handle(){
//            mHandler.sendMessageAtTime(msg, 10000);//atTime
//        }
    // 解决方案： 软引用+静态防止泄漏并实现功能
//    private class MyHandler(mainActivity: CommonLeakageCaseActivity) : Handler() {
//        //        private MainActivity mainActivity;//直接持有了一个外部类的强引用，会内存泄露
//        private val mainActivity //设置软引用保存，当内存一发生GC的时候就会回收。
//                : WeakReference<CommonLeakageCaseActivity>
//
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            val main: CommonLeakageCaseActivity = mainActivity.get()
//            if (main == null || main.isFinishing()) {
//                return
//            }
//            when (msg.what) {
//                0 ->                     //加载数据
// //                    MainActivity.this.a;//有时候确实会有这样的需求：需要引用外部类的资源。怎么办？
//                    var  b: Int = main.a
//            }
//        }

//        init {
//            this.mainActivity = WeakReference(mainActivity)
//        }
//    }
}
