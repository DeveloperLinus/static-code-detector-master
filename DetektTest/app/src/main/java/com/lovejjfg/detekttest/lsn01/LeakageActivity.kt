package com.lovejjfg.detekttest.lsn01

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.lovejjfg.detekttest.R
import com.lovejjfg.detekttest.lsn01.CommonUtil.Companion.getInstance

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author HuQingHui
 * @date 2022/9/1
 */
/**
 * Created by Ray on 2020-1-7.
 * 单例在横屏时出现的内存泄漏
 */
class LeakageActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CommonUtil commonUtil = CommonUtil.getInstance(getApplicationContext());
        // 导致LeakageActivity泄漏：
        val commonUtil = getInstance(this)
    }
}
