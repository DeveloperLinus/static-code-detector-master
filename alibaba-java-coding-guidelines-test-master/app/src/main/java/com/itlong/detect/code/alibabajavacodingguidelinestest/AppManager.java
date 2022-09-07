package com.itlong.detect.code.alibabajavacodingguidelinestest;

import android.content.Context;

/**
 * 描述：单例内存泄漏检测
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/8/31
 */
public class AppManager {
    private static AppManager instance;
    private Context context;

    private AppManager(Context context) {
        this.context = context;
    }

    public static AppManager getInstance(Context context) {
        if (instance == null) {
            instance = new AppManager(context);
        }
        return instance;
    }
}
