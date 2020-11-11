package edu.scse.onlineshool.ui.animatedcircleloadingview.selflistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.scse.onlineshool.R;
import edu.scse.onlineshool.ui.animatedcircleloadingview.HomeFragment;

public class InfoAdapter extends BaseAdapter {
    private Context mContext;
    private List<Map<String, ?>> listItems;
    private LayoutInflater inflater;

    public InfoAdapter(List<Map<String, ?>> listItems, Context mContext) {
        super();
        this.inflater = LayoutInflater.from(mContext);
        this.listItems = listItems;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /* 步骤1：创建一个空的InfoViewHolder对象 */
        InfoViewHolder infoViewHolder ;
        /* 步骤2：判断转换视图参数convertView是否为空，若为空则实例化viewHolder对象中的组件 */
        if (convertView == null){
            infoViewHolder = new InfoViewHolder();
            /* 步骤3：转换视图绑定列表选项布局文件 */
            convertView = this.inflater.inflate(R.layout.selflistview, null);

            /* 步骤4：获取列表布局中的所有组件对象 */
            infoViewHolder.imageView = convertView.findViewById(R.id.self_listview_imgIcon);
            infoViewHolder.textView = convertView.findViewById(R.id.self_listview_text);
            infoViewHolder.button = convertView.findViewById(R.id.self_listview_button);

            /* 步骤5：转换视图设置ViewHolder对象*/
            convertView.setTag(infoViewHolder);
        }else{
            infoViewHolder = (InfoViewHolder) convertView.getTag();
        }
        /* 步骤6：动态为每一个选项对象赋值 */
        infoViewHolder.imageView.setImageResource((Integer) this.listItems.get(position).get("imageView"));
        infoViewHolder.textView.setText(this.listItems.get(position).get("textView").toString());
        infoViewHolder.button.setOnClickListener(new ViewOcl(position));

        return convertView;
    }
    /* 自定义一个单击监听器 */
    private class ViewOcl implements View.OnClickListener{
        private int position;

        public ViewOcl(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.self_listview_button:
                    Toast.makeText(mContext, "你要回复 ["+ listItems.get(position).get("textView") +"]", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
