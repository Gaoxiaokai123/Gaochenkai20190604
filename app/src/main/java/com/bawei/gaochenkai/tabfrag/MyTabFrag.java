package com.bawei.gaochenkai.tabfrag;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.gaochenkai.R;
import com.bawei.gaochenkai.WebActivity;
import com.bawei.gaochenkai.base.BaseFragment;
import com.bumptech.glide.Glide;

import java.net.URL;

/**
 * @Auther: 高晨凯
 * @Date: 2019/6/4 08:59:13
 * @Description: 我的详情页面
 */
public class MyTabFrag extends BaseFragment {

    private ImageView image;
    private TextView text;

    @Override
    public int layout() {
        return R.layout.tabrag02;
    }

    @Override
    public void initView() {
        image = getView().findViewById(R.id.tab_imaeg);
        text = getView().findViewById(R.id.tab_text);
    }

    @Override
    public void initData() {
        //图库
        getimageView();
        //webview页面
        getebview();
    }

    private void getebview() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WebActivity.class);
                startActivity(intent);
            }
        });
    }

    //图库
    private void getimageView() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,0);
            }
        });


    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                Uri uri = data.getData();
//                data.setData(uri);
                Glide.with(getActivity()).load(uri).into(image);
                break;
        }
    }
}
