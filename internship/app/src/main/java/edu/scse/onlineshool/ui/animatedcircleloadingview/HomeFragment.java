package edu.scse.onlineshool.ui.animatedcircleloadingview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import edu.scse.onlineshool.R;
import edu.scse.onlineshool.SearchActivity;
import edu.scse.onlineshool.ui.animatedcircleloadingview.selflistview.InfoAdapter;


public class HomeFragment extends Fragment implements View.OnClickListener{

    public  String []mTabTitle = new String[]{"精选推荐","基础课程","进阶课程"};
    private TabLayout mTabLayout;
    public static final String TAG = "HomeFragment";

    private ListView listViewInfo;
    private List<Map<String, ?>> listItems;
    private SearchView main_searchview;
    private Toolbar mtoolbar;
    private TextView textViewName;

    private Banner banner;

    //设置图片资源:url或本地资源
    String[] images= new String[] {
            "I:\\internship\\app\\src\\main\\res\\drawable-v24\\first.jpg",
            "I:\\internship\\app\\src\\main\\res\\drawable-v24\\first.jpg",
            "I:\\internship\\app\\src\\main\\res\\drawable-v24\\second.jpg",
            "I:\\internship\\app\\src\\main\\res\\drawable-v24\\first.jpg",
            "I:\\internship\\app\\src\\main\\res\\drawable-v24\\third.jpg",
          };

    //设置图片标题:自动对应
    String[] titles=new String[]{"2020考研全程班","2020考研数学班","2020考研英语班","2020考研数据结构","2020考研政治高分班"};

    public HomeFragment(){

    }

    public static HomeFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text",text);
        HomeFragment  fragment = new HomeFragment ();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_home, container,false);
        initView(view);

        return view;
    }

    private List<Map<String, ?>> getListItems() {
        List<Map<String, ?>> listItems = new ArrayList<>();

        Map<String, Object> item01 = new HashMap<>();
        item01.put("id", 1);
        item01.put("imageView", R.drawable.first);
        item01.put("textView","【全套】PPT教程PPT零基础PPT入门小白脱白系列");
        listItems.add(item01);

        Map<String, Object> item02 = new HashMap<>();
        item02.put("id", 2);
        item02.put("imageView", R.drawable.second);
        item02.put("textView","【全套】PPT教程PPT零基础PPT入门小白脱白系列");
        listItems.add(item02);

        Map<String, Object> item03 = new HashMap<>();
        item03.put("id", 3);
        item03.put("imageView", R.drawable.third);
        item03.put("textView","【全套】PPT教程PPT零基础PPT入门小白脱白系列");
        listItems.add(item03);

        return listItems;
    }

    private void initView(View view){
        this.listItems = this.getListItems();
        InfoAdapter adapter = new InfoAdapter(this.listItems, getActivity());
        this.listViewInfo = view.findViewById(R.id.activity_main_home_listViewInfo);
        this.listViewInfo.setAdapter(adapter);

        mTabLayout =  view.findViewById(R.id.home_bottom_tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[2]));
        textViewName = view.findViewById(R.id.home_text_class);


        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG,"onTabSelected:"+tab.getText());
                textViewName.setText(tab.getText());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        banner =  view.findViewById(R.id.banner);
        setBanner();

        mtoolbar = view.findViewById(R.id.toolbar_home);
        mtoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getContext(), SearchActivity.class);//启动MainActivity
                startActivity(it);
            }
        });
    }

    public void setBanner(){
        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);

        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        banner.setIndicatorGravity(Banner.CENTER);

        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        banner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        banner.isAutoPlay(true) ;

        //设置轮播图片间隔时间（不设置默认为2000）
        banner.setDelayTime(5000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);

        //自定义图片加载框架
        banner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                System.out.println("加载中");
                Glide.with(getContext()).load(url).into(view);
                System.out.println("加载完");
            }
        });
        //设置点击事件，下标是从1开始
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getContext(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
