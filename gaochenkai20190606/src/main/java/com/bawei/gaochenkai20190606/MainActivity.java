package com.bawei.gaochenkai20190606;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sp;
    private ViewPager pager;
    private RadioGroup radiogroup;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("ydy",Context.MODE_PRIVATE);
        if (sp.getBoolean("key",false)){
            //跳转页面
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            return;
        }
        //如果不是
        sp.edit().putBoolean("key",true).commit();

        //获取控件id
        pager = findViewById(R.id.pager);
        radiogroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);

        //进入引导页让button隐藏
        button.setVisibility(View.GONE);
        //图片数组
        int arr[] = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
        ArrayList<ImageView> list = new ArrayList<>();
        //设置radiobutton距离

        for (int i = 0; i < arr.length; i++) {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(arr[i]);
            list.add(imageView);
            //设置小圆点
            RadioButton button = new RadioButton(MainActivity.this);
            //设置选择器
            button.setButtonDrawable(R.drawable.sel_r);
            radiogroup.addView(button);
        }
        //选中第一个按钮
        radiogroup.check(radiogroup.getChildAt(0).getId());
        //设置适配器
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return false;
            }
        });





    }

    //跳转页面
    @Override
    public void onClick(View view) {

    }
}
