
package com.lovejjfg.detekttest.error

import java.util.*

object LockTest {
    var obj1 = "obj1"
    var obj2 = "obj2"
    @JvmStatic
    fun main(args: Array<String>) {
        val la = LockA()
        Thread(la).start()
        val lb = LockB()
        Thread(lb).start()
    }
}

internal class LockA : Runnable {
    override fun run() {
        try {
            println(Date().toString().toString() + " LockA 开始执行")
            while (true) {
                synchronized(LockTest.obj1) {
                    println(Date().toString().toString() + " LockA 锁住 obj1")
                    Thread.sleep(3000) // 此处等待是给B能锁住机会
                    synchronized(LockTest.obj2) {
                        println(Date().toString() + " LockA 锁住 obj2")
                        Thread.sleep((60 * 1000).toLong()) // 为测试，占用了就不放
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

internal class LockB : Runnable {
    override fun run() {
        try {
            println(Date().toString().toString() + " LockB 开始执行")
            while (true) {
                synchronized(LockTest.obj2) {
                    println(Date().toString().toString() + " LockB 锁住 obj2")
                    Thread.sleep(3000) // 此处等待是给A能锁住机会
                    synchronized(LockTest.obj1) {
                        println(Date().toString().toString() + " LockB 锁住 obj1")
                        Thread.sleep((60 * 1000).toLong()) // 为测试，占用了就不放
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
