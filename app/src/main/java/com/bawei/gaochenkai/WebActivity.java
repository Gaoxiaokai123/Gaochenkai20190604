package com.bawei.gaochenkai;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bawei.gaochenkai.base.BaseActivity;

public class WebActivity extends BaseActivity {

    private WebView web;

    @Override
    public int layout() {
        return R.layout.activity_web;
    }

    @Override
    public void initView() {
        web = findViewById(R.id.web);
    }

    @Override
    public void initData() {
//        web.loadUrl("file://android_Baway_DetailView.html");
        web.loadUrl("file:///android_asset/Baway_DetailView.html");
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    public void initEvent() {

    }
}
