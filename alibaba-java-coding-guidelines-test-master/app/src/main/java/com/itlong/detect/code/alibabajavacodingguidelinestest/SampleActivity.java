package com.itlong.detect.code.alibabajavacodingguidelinestest;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/8/31
 */
public class SampleActivity extends AppCompatActivity {
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("Test", "执行任务");
            }
        }, 300000);
        finish();
    }
}
