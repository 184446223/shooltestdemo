package edu.scse.onlineshool.ui.animatedcircleloadingview.self_horizontallistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.scse.onlineshool.R;

public class HorRecyclerVIewAdapter extends RecyclerView.Adapter<HorRecyclerVIewAdapter.MyViewHolder> {

    private List<InfoViewHolderProfile> classList;

    public HorRecyclerVIewAdapter(List<InfoViewHolderProfile> classList) {
        this.classList= classList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.selflistview_profile,parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        InfoViewHolderProfile horItem = classList.get(position);
        holder.classHorImage.setImageResource(horItem.getImageId());
        holder.classHorName.setText(horItem.getName());
        holder.classView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                InfoViewHolderProfile  myclass = classList.get(positon);
                Toast.makeText(v.getContext(),"hor："+"你点击了"+myclass.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        View classView;

        //图片
        public ImageView classHorImage;
        //标题
        public TextView classHorName;

        public MyViewHolder(View itemView) {
            super(itemView);
            classView = itemView;
            classHorImage = itemView.findViewById(R.id.self_listview_profile_image);
            classHorName = itemView.findViewById(R.id.self_listview_profile_text);
        }
    }
}
