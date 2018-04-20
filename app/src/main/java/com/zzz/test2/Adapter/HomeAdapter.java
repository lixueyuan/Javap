package com.zzz.test2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zzz.test2.Model.HomeModel;
import com.zzz.test2.R;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */

public class HomeAdapter extends ArrayAdapter{
    private LayoutInflater layoutInflater = null;
    private List<HomeModel> homeModels;
    public HomeAdapter(Context context,int textViewResourceId,List objects) {
        super(context,textViewResourceId,objects);
        layoutInflater = LayoutInflater.from(context);
        homeModels = objects;
    }

    @Override
    public int getCount() {
        return homeModels.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return homeModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.home_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.id = (TextView)convertView.findViewById(R.id.text_view);
            viewHolder.name = (Button)convertView.findViewById(R.id.item_button);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.id.setText(homeModels.get(position).getId());
        viewHolder.name.setText(homeModels.get(position).getName());
        return convertView;
    }

    private static class ViewHolder {
        private TextView id;
        private TextView name;
    }

}
