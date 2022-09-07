package com.lovejjfg.detekttest

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SampleActivity : AppCompatActivity() {
    private val mHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHandler.postDelayed({ Log.d("Test", "执行任务") }, 300000)
        finish()
    }
}
