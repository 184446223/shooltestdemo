package edu.scse.onlineshool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class SeachRecordAdapter extends BaseRecycleAdapter<String> {

    public SeachRecordAdapter(List<String> datas, Context mContext) {
        super(datas, mContext);
    }

    @Override
    protected void bindData(BaseViewHolder holder, final int position) {

        TextView textView= (TextView) holder.getView(R.id.tv_record);
        textView.setText(datas.get(position));

        //
        holder.getView(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null!=mRvItemOnclickListener){
                    mRvItemOnclickListener.RvItemOnclick(position);
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.search_item;
    }
}
