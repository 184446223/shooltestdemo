package edu.scse.onlineshool.ui.animatedcircleloadingview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;



import edu.scse.onlineshool.R;

public class FriendFragment extends Fragment {

    public FriendFragment(){

    }
    public static FriendFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text",text);
        FriendFragment fragment = new FriendFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_friend, container,false);
        return view;
    }
    private void initView(View view){

    }


}
