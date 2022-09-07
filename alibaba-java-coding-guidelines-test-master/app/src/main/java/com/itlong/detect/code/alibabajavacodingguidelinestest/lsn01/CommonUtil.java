package com.itlong.detect.code.alibabajavacodingguidelinestest.lsn01;

import android.content.Context;

/**
 * @author HuQingHui
 */
public class CommonUtil {

    private static CommonUtil instance;
    private Context context;

    private CommonUtil(Context context) {
        this.context = context;
    }

    public static CommonUtil getInstance(Context context){
        if(instance == null){
            instance = new CommonUtil(context);
        }
        return instance;
    }
}
