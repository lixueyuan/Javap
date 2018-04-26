package com.zzz.test2.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zzz.test2.Activity.ItemDetailActivity;
import com.zzz.test2.Activity.PersonActivity;
import com.zzz.test2.Model.HomeModel;
import com.zzz.test2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */

public class HomeFragment extends Fragment {
    @Nullable
    private static final String TAG = HomeFragment.class.getSimpleName();
    private ListView home_listView;
    private ArrayList<HomeModel> homeModels = new ArrayList<HomeModel>();
    private Boolean isSelected = false;
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
        initData();
        home_listView = HomeFragment.this.getActivity().findViewById(R.id.home_list_view);
        home_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Log.i(TAG, "onItemClick   position--->" + position);
                startActivity(new Intent(getActivity(), ItemDetailActivity.class));
            }
        });
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.home_listview_header,null);
        home_listView.addHeaderView(header);
        home_listView.setAdapter(mAdapter);
    }

    private void initData() {
        //组织数据源
        homeModels.add(new HomeModel("123","lixueyuan1",1,"123","tupianming",1,"21","pinglun"));
        homeModels.add(new HomeModel("123","lixueyuan2",1,"123","tupianming",1,"22","pinglun"));
        homeModels.add(new HomeModel("123","lixueyuan3",1,"123","tupianming",1,"23","pinglun"));
        homeModels.add(new HomeModel("123","lixueyuan4",1,"123","tupianming",1,"24","pinglun"));
        homeModels.add(new HomeModel("123","lixueyuan5",1,"123","tupianming",1,"25","pinglun"));
    }

    private BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return homeModels.size();
        }

        @Override
        public Object getItem(int position) {
            return homeModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return homeModels.get(position).hashCode();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final CustomViewHolder cvh;
            if (convertView == null) {
                cvh = new CustomViewHolder();
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.home_list_item, null);
                cvh.personImageButton = convertView.findViewById(R.id.home_item_icon_button);
//                cvh.personName = convertView.findViewById(R.id.home_item_personName);
//                cvh.focusButton = convertView.findViewById(R.id.home_item_focusButton);
//                cvh.bigImage = convertView.findViewById(R.id.home_item_bigImage);
//                cvh.productionName = convertView.findViewById(R.id.home_item_productionName);
//                cvh.loveButton = convertView.findViewById(R.id.home_item_loveButton);
//                cvh.loveText = convertView.findViewById(R.id.home_item_loveText);
//                cvh.commentButton = convertView.findViewById(R.id.home_item_commentButton);
//                cvh.shareButton = convertView.findViewById(R.id.home_item_shareButton);
////                cvh.personImageButton.setOnClickListener(mOnClickListener);
////                cvh.focusButton.setOnClickListener(mOnClickListener);
                convertView.setTag(cvh);
            } else {
                cvh = (CustomViewHolder) convertView.getTag();
            }
//            cvh.personImageButton.setTag(position);
//            cvh.focusButton.setTag(position);
//            cvh.focusButton.setText(homeModels.get(position).getFocusIdentity());
            //设置点击头像事件
            cvh.personImageButton.setOnClickListener(clickPersonIconAction);
            //点击爱心按钮事件
            cvh.loveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isSelected =! isSelected;
                    if (isSelected) {
                        //点亮爱心事件
                        cvh.loveButton.setBackgroundResource(R.mipmap.dianzan2);
                    }else {
                        //取消点亮事件
                        cvh.loveButton.setBackgroundResource(R.mipmap.dianzan1);
                    }
                }
            });
            //点击评论按钮点击事件
            cvh.commentButton.setOnClickListener(commentAction);
            //点击转发按钮点击事件
            cvh.shareButton.setOnClickListener(shareAction);
            //设置属性值
            cvh.personName.setText(homeModels.get(position).getName());
            cvh.loveText.setText(homeModels.get(position).getLoveNumber());
            cvh.productionName.setText(homeModels.get(position).getImageName());
            return convertView;
        }

        class CustomViewHolder {
            //个人图像
            public Button personImageButton;
            //用户名
            public TextView personName;
            //关注按钮
            public ImageView focusButton;
            //作品大图
            public ImageView bigImage;
            //作品名
            public TextView productionName;
            //爱心按钮
            public ImageView loveButton;
            //关注数量
            public TextView loveText;
            //评论按钮
            public Button commentButton;
            //转发按钮
            public Button shareButton;
        }

        private View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object o = v.getTag();
                if (o instanceof Integer) {
                    Log.i(TAG, "onItemLongClick   position--->" + o);
                    Toast.makeText(getActivity(), "button click-->" + ((Integer) o), Toast.LENGTH_SHORT).show();
                }
            }
        };
        //select person icon button action点击头像响应事件
        private View.OnClickListener clickPersonIconAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PersonActivity.class));
            }
        };
        //选中爱心按钮事件
        private View.OnClickListener loveProductionAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击爱心按钮事件",Toast.LENGTH_SHORT).show();
            }
        };
        //评论按钮事件
        private View.OnClickListener commentAction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"评论事件",Toast.LENGTH_SHORT).show();
            }
        };
        //转发按钮事件
        private View.OnClickListener shareAction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"转发事件",Toast.LENGTH_SHORT).show();
            }
        };
    };
}
