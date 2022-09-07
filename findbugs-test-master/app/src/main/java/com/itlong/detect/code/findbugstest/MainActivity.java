package com.itlong.detect.code.findbugstest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * @author HUQINGHUI
 */
public class MainActivity extends Activity {
    private Button btnTestDeadLock;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btnTestDeadLock = findViewById(R.id.btn_test_dead_lock);
//        btnTestDeadLock.setOnClickListener(v -> {
            LockA la = new LockA();
            new Thread(la).start();
            LockB lb = new LockB();
            new Thread(lb).start();
//        });

    }
}