package com.bawei.gaochenkai;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bawei.gaochenkai.adapter.TabAdapter;
import com.bawei.gaochenkai.base.BaseActivity;
import com.bawei.gaochenkai.tabfrag.TabFragHOME;
import com.bawei.gaochenkai.tabfrag.MyTabFrag;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TabLayout tab;
    private ViewPager pager;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();


    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tab = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);
    }

    @Override
    public void initData() {
        list.add("正在热映");
        list.add("我的详情");
        fragments.add(new TabFragHOME());
        fragments.add(new MyTabFrag());

        pager.setAdapter(new TabAdapter(getSupportFragmentManager(),list,fragments));
        tab.setupWithViewPager(pager);
    }

    @Override
    public void initEvent() {

    }
}
