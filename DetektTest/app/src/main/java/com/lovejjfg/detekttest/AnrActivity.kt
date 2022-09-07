package com.lovejjfg.detekttest

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author HuQingHui
 * @date 2022/8/31
 */
class AnrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemClock.sleep(100000)
    }
}
