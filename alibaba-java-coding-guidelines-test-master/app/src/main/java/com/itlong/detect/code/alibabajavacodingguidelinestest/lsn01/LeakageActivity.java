package com.itlong.detect.code.alibabajavacodingguidelinestest.lsn01;

/**
 * @author HuQingHui
 */

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itlong.detect.code.alibabajavacodingguidelinestest.R;

/**
 * @author  HUQINGHUI
 * 单例在横屏时出现的内存泄漏
 */
public class LeakageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CommonUtil commonUtil = CommonUtil.getInstance(getApplicationContext());
        //导致LeakageActivity泄漏
        CommonUtil commonUtil = CommonUtil.getInstance(this);
    }
}
