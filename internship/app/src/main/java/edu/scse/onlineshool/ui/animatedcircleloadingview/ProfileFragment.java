package edu.scse.onlineshool.ui.animatedcircleloadingview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.scse.onlineshool.R;
import edu.scse.onlineshool.ui.animatedcircleloadingview.myUI.MyOneLineView;
import edu.scse.onlineshool.ui.animatedcircleloadingview.self_horizontallistview.HorRecyclerVIewAdapter;
import edu.scse.onlineshool.ui.animatedcircleloadingview.self_horizontallistview.InfoViewHolderProfile;

public  class ProfileFragment  extends Fragment implements MyOneLineView.OnRootClickListener, MyOneLineView.OnArrowClickListener{

    private RecyclerView mRecyclerView;
    private HorRecyclerVIewAdapter adapter;
    private LinearLayoutManager layoutManager;

    LinearLayout llRoot;


    public ProfileFragment(){

    }

    public static ProfileFragment  newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text",text);
        ProfileFragment  fragment = new ProfileFragment ();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_profile, container,false);
        initView(view);

        return view;
    }
    private void initView(View view){

        mRecyclerView = view.findViewById(R.id.recyclerView);

        //RecyclerView填充数据
        List<InfoViewHolderProfile> mList = new ArrayList();
        for ( int i=1 ; i<20 ; i++){
            mList.add(new InfoViewHolderProfile("class"+i,R.drawable.first));
        }

        //横向滑动布局
        adapter = new HorRecyclerVIewAdapter(mList);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //使用示例，通过Java代码来创建MyOnelineView

        llRoot =  view.findViewById(R.id.ll_root);

        //icon + 文字 + 箭头
        llRoot.addView(new MyOneLineView(getActivity())
                .initMine(R.mipmap.selfclass, "我的课程", "", true)
                .setOnRootClickListener(this, 1));
        llRoot.addView(new MyOneLineView(getActivity())
                .initMine(R.mipmap.shoucang, "我的收藏", "", true)
                .setOnRootClickListener(this, 2));
        llRoot.addView(new MyOneLineView(getActivity())
                .initMine(R.mipmap.notes, "我的笔记", "", true)
                .setOnRootClickListener(this, 3));
        llRoot.addView(new MyOneLineView(getActivity())
                .initMine(R.mipmap.wenjuan, "我的问卷", "", true)
                .setOnRootClickListener(this, 4));
        llRoot.addView(new MyOneLineView(getActivity())
                .initMine(R.mipmap.test, "我的测试", "", true)
                .setOnRootClickListener(this, 5));
        llRoot.addView(new MyOneLineView(getActivity())
                .initMine(R.mipmap.lianxi, "我的练习", "", true)
                .setOnRootClickListener(this, 6));
        //icon + 文字 + 文字 + 箭头
//        llRoot.addView(new MyOneLineView(getActivity())
//                .initMine(R.mipmap.ic_launcher, "第二行", "第二行", true)
//                .setOnArrowClickListener(this, 2));

    }


    @Override
    public void onRootClick(View view) {

        int position = 0;
        switch ((int) view.getTag()) {
            case 1:
                position = 1;
                break;
            case 2:
                position = 2;
                break;
        }
        Toast.makeText(getActivity(), "点击了第" + position + "行", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onArrowClick(View view) {

        int position = 0;
        switch ((int) view.getTag()) {
            case 1:
                position = 1;
                break;
            case 2:
                position = 2;
                break;
        }
        Toast.makeText(getActivity(), "点击了第" + position + "行右边的箭头", Toast.LENGTH_SHORT).show();
    }

}
