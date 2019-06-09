package com.bawei.gaochenkai.tabfrag;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.gaochenkai.R;
import com.bawei.gaochenkai.adapter.MyListAdapter;
import com.bawei.gaochenkai.base.BaseFragment;
import com.bawei.gaochenkai.bean.ListBean;
import com.bawei.gaochenkai.util.HttpUtil;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @Auther: 高晨凯
 * @Date: 2019/6/4 08:59:13
 * @Description: 正在热播页面
 */
public class TabFragHOME extends BaseFragment {

    private Banner banner;
    private ListView listView;
    private String str = "http://172.17.8.100/small/commodity/v1/bannerShow";
    private String str2 = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=5";
    private Integer pa = 1;
    private HttpUtil util = HttpUtil.getUtil();
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<ListBean> list2 = new ArrayList<>();

    @Override
    public int layout() {
        return R.layout.tabrag01;
    }

    @Override
    public void initView() {
        banner = getView().findViewById(R.id.banner);
        listView = getView().findViewById(R.id.listview);
    }

    @Override
    public void initData() {
        //网络判断
        boolean netWork = util.isNetWork(getActivity());
        if (netWork){
            Toast.makeText(getActivity(),"有网",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"没网",Toast.LENGTH_SHORT).show();
            return;
        }


        getBanner(); //轮播图
        getListview();//listview列表

    }
    //多条目列表
    private void getListview() {
        util.getAsyncTask(str2, new HttpUtil.CCallBackstring() {
            @Override
            public void getbackstring(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray result = jsonObject.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        JSONObject obj = (JSONObject) result.get(i);
                        String id = obj.getString("id");
                        String imageUrl = obj.getString("imageUrl");
                        String name = obj.getString("name");
                        list2.add(new ListBean(id,imageUrl,name));
                    }
                    listView.setAdapter(new MyListAdapter(list2,getActivity()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    //轮播图
    private void getBanner() {
        util.getAsyncTask(str, new HttpUtil.CCallBackstring() {
            @Override
            public void getbackstring(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray result = jsonObject.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        JSONObject obj = (JSONObject) result.get(i);
                        String imageUrl = obj.getString("imageUrl");
//                        list.add(imageUrl);
                        list.add(imageUrl);
                    }
                    banner.setImages(list);
                    banner.setDelayTime(3000);
                    banner.isAutoPlay(true);
                    banner.setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load(path).into(imageView);
                        }
                    }).start();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void initEvent() {

    }
}
