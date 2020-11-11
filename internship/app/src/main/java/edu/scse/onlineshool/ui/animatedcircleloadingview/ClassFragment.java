package edu.scse.onlineshool.ui.animatedcircleloadingview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.scse.onlineshool.R;
import edu.scse.onlineshool.ui.animatedcircleloadingview.selflistview.InfoAdapter;
import edu.scse.onlineshool.ui.animatedcircleloadingview.selflistview_class.InfoAdapterClass;

public  class ClassFragment extends Fragment {

    private ListView listViewInfo;
    private List<Map<String, ?>> listItems;

    public ClassFragment(){

    }
    public static ClassFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text",text);
        ClassFragment fragment = new ClassFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_class, container,false);
        initView(view);
        return view;
    }
    private void initView(View view){

        this.listItems = this.getListItems();
        InfoAdapterClass adapter = new InfoAdapterClass(this.listItems, getActivity());
        this.listViewInfo = view.findViewById(R.id.activity_main_class_listViewInfo);
        this.listViewInfo.setAdapter(adapter);
    }

    private List<Map<String, ?>> getListItems() {
        List<Map<String, ?>> listItems = new ArrayList<>();

        Map<String, Object> item01 = new HashMap<>();
        item01.put("id", 1);
        item01.put("imageView", R.drawable.first);
        item01.put("textView_01","IP路由与交换技术");
        item01.put("textView_02","已学完");
        item01.put("textView_03","老师已下课");
        listItems.add(item01);

        Map<String, Object> item02 = new HashMap<>();
        item02.put("id", 2);
        item02.put("imageView", R.drawable.second);
        item02.put("textView_01","微机原理与接口");
        item02.put("textView_02","已学完");
        item02.put("textView_03","老师已下课");
        listItems.add(item02);

        Map<String, Object> item03 = new HashMap<>();
        item03.put("id", 3);
        item03.put("imageView", R.drawable.third);
        item03.put("textView_01","无线传感器网络");
        item03.put("textView_02","已学3%");
        item03.put("textView_03","上次学到");
        listItems.add(item03);

        return listItems;
    }
}
