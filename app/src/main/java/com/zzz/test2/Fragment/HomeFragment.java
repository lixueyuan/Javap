package com.zzz.test2.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zzz.test2.Adapter.HomeAdapter;
import com.zzz.test2.Model.HomeModel;
import com.zzz.test2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */

public class HomeFragment extends Fragment {
    @Nullable
    private ListView home_listView;
    private ArrayList<HomeModel> homeModels = new ArrayList<HomeModel>();
    private HomeAdapter homeAdapter = null;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListView();
        homeAdapter = new HomeAdapter(getActivity(),R.layout.home_list_item,homeModels);

    }

    private void initListView() {
        home_listView = getActivity().findViewById(R.id.home_list_view);
        //组织数据源
//        List<HashMap<String,HomeModel>> mylist = new ArrayList<HashMap<String,HomeModel>>();
        List<HomeModel> dataList = new ArrayList<HomeModel>();
        for(int i = 0;i < 20; i ++) {
//            HashMap<String,HomeModel> map = new HashMap<String, HomeModel>();
//            map.put("itemTitle",);
//            map.put("itemText","seconde Data");
            dataList.add(new HomeModel("1","lxy","23"));
            dataList.add(new HomeModel("2","lxy1","23"));
            dataList.add(new HomeModel("3","lxy2","23"));
            dataList.add(new HomeModel("4","lxy3","23"));
        }
        //config layout

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                dataList,//数据源
                R.layout.home_list_item,//item
                new String[] {"itemTitle","itemText"},//数据源key
                new int[] {R.id.text_view,R.id.item_button}//赋值
        );
        home_listView.setAdapter(adapter);
    }
}
