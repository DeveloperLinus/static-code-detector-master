package com.itlong.detect.code.alibabajavacodingguidelinestest;

import android.app.Application;
import android.content.Context;

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/8/31
 */
public class MyApp extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
