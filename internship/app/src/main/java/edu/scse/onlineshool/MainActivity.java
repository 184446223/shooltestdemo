package edu.scse.onlineshool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.scse.onlineshool.ui.animatedcircleloadingview.ClassFragment;
import edu.scse.onlineshool.ui.animatedcircleloadingview.FriendFragment;
import edu.scse.onlineshool.ui.animatedcircleloadingview.HomeFragment;
import edu.scse.onlineshool.ui.animatedcircleloadingview.MyFragmentAdapter;
import edu.scse.onlineshool.ui.animatedcircleloadingview.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public static final String TAG = "MainActivity";
    public  int []mTabRes = new int[]{R.drawable.tab_home_selector,R.drawable.friend,R.drawable.tab_class_selector,R.drawable.tab_profile_selector};
    public  int []mTabResPressed = new int[]{R.drawable.ic_tab_strip_icon_feed_selected,R.drawable.friend_pressed,R.drawable.ic_tab_strip_icon_class_selected,R.drawable.ic_tab_strip_icon_profile_selected};
    public  String []mTabTitle = new String[]{"首页","通讯录","课程表","我的"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }

    private void InitView(){
        mViewPager = findViewById(R.id.ViewPager);
        mTabLayout =  findViewById(R.id.bottom_tab_layout);
        final List<Fragment> fragments = new ArrayList<>();
        String from = "TaTabLayout Tab";
        mTabLayout.setupWithViewPager(mViewPager);
        fragments.add(HomeFragment.newInstance(from));
        fragments.add(FriendFragment.newInstance(from));
        fragments.add(ClassFragment.newInstance(from));
        fragments.add(ProfileFragment.newInstance(from));
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),fragments, Arrays.asList(mTabTitle));
        mViewPager.setAdapter(adapter);

        //下表初始化 ，开始默认进入首页
        for(int i=0;i< mTabLayout.getTabCount();i++){
            if(i==0) {
                mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(mTabResPressed[i]));
            }else {
                mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(mTabRes[i]));
            }
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //改变Tab 状态
                for(int i=0;i< mTabLayout.getTabCount();i++){
                    if(i == tab.getPosition()){
                        mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(mTabResPressed[i]));
                    }else{
                        mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(mTabRes[i]));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG,"select page:"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }



}
