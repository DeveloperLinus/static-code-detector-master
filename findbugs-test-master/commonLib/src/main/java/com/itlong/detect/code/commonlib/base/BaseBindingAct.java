package com.itlong.detect.code.commonlib.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseBindingAct<T extends ViewDataBinding> extends Activity {
    private long  FLAG_HOMEKEY_DISPATCHED = -0x80000000;
    protected T binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this ,getLayoutId());
        init();
        initListener();
    }
    protected abstract int getLayoutId();
    protected abstract void init();
    protected void initListener(){}
}
