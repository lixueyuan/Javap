package com.zzz.test2.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.youth.banner.Banner;
import com.zzz.test2.Other.GlideImageLoader;
import com.zzz.test2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */

public class ItemDetailActivity extends AppCompatActivity {
    Banner banner;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.item_detail_activity);
        banner = findViewById(R.id.banner);
        List<Integer> imgList = new ArrayList<>();
        imgList.add(R.mipmap.banner11);
        imgList.add(R.mipmap.banner1);
        banner.setImages(imgList).setImageLoader(new GlideImageLoader()).start();
    }
}
