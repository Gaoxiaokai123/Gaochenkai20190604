package com.bawei.gaochenkai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.gaochenkai.R;
import com.bawei.gaochenkai.bean.ListBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @Auther: 高晨凯
 * @Date: 2019/6/4 09:41:07
 * @Description: listview的适配器
 */
public class MyListAdapter extends BaseAdapter {
    private ArrayList<ListBean> list;
    private Context context;

    public MyListAdapter(ArrayList<ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)){
            case 0:
                ViewHolder holder;
                if (view == null){
                    view = View.inflate(context, R.layout.item,null);
                    holder = new ViewHolder();
                    holder.name2 = view.findViewById(R.id.item_name);
                    holder.id1 = view.findViewById(R.id.item_id);
                    holder.image3 = view.findViewById(R.id.item_image);
                    view.setTag(holder);
                }else{
                    holder = (ViewHolder) view.getTag();
                }
                holder.name2.setText("电影名称"+list.get(i).getName());
                holder.id1.setText("电影id"+list.get(i).getId());
                Glide.with(context).load(list.get(i).getImageUrl()).into(holder.image3);
                break;
            case 1:
                ViewHolder2 holder2;
                if (view == null){
                    view = View.inflate(context, R.layout.item2,null);
                    holder2 = new ViewHolder2();
                    holder2.name2 = view.findViewById(R.id.item_name);
                    holder2.id1 = view.findViewById(R.id.item_id);
                    holder2.image3 = view.findViewById(R.id.item_image);
                    view.setTag(holder2);
                }else{
                    holder2 = (ViewHolder2) view.getTag();
                }
                holder2.name2.setText("电影名称"+list.get(i).getName());
                holder2.id1.setText("电影id"+list.get(i).getId());
                Glide.with(context).load(list.get(i).getImageUrl()).into(holder2.image3);
                break;
        }

        return view;
    }

    static class ViewHolder{
        TextView id1;
        TextView name2;
        ImageView image3;
    }
    static class ViewHolder2{
        TextView id1;
        TextView name2;
        ImageView image3;
    }
}
