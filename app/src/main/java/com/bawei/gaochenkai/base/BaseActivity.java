package com.bawei.gaochenkai.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.gaochenkai.R;

/**
 * @Auther: 高晨凯
 * @Date: 2019/6/4 08:53:11
 * @Description: activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        initView();
    initData();
    initEvent();
    }

    public abstract int layout();

    public abstract void initView();

    public abstract void initData();

    public abstract void initEvent();

}
