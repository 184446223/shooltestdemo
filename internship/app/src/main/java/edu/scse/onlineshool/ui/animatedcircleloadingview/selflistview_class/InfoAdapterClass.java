package edu.scse.onlineshool.ui.animatedcircleloadingview.selflistview_class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.scse.onlineshool.R;
import edu.scse.onlineshool.ui.animatedcircleloadingview.selflistview.InfoViewHolder;

public class InfoAdapterClass extends BaseAdapter {
    private Context mContext;
    private List<Map<String, ?>> listItems;
    private LayoutInflater inflater;

    public InfoAdapterClass(List<Map<String, ?>> listItems, Context mContext) {
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
        InfoViewHolderclass infoViewHolderclass ;
        /* 步骤2：判断转换视图参数convertView是否为空，若为空则实例化viewHolder对象中的组件 */
        if (convertView == null){
            infoViewHolderclass = new InfoViewHolderclass();
            /* 步骤3：转换视图绑定列表选项布局文件 */
            convertView = this.inflater.inflate(R.layout.selflistview_class, null);

            /* 步骤4：获取列表布局中的所有组件对象 */
            infoViewHolderclass.imageView = convertView.findViewById(R.id.self_listviewclass_imgIcon);
            infoViewHolderclass.textView_01 = convertView.findViewById(R.id.self_listviewclass_text);
            infoViewHolderclass.textView_02 = convertView.findViewById(R.id.self_listviewclass_text_2);
            infoViewHolderclass.textView_03 = convertView.findViewById(R.id.self_listviewclass_text_3);

            /* 步骤5：转换视图设置ViewHolder对象*/
            convertView.setTag(infoViewHolderclass);
        }else{
            infoViewHolderclass = (InfoViewHolderclass) convertView.getTag();
        }
        /* 步骤6：动态为每一个选项对象赋值 */
        infoViewHolderclass.imageView.setImageResource((Integer) this.listItems.get(position).get("imageView"));
        infoViewHolderclass.textView_01.setText(this.listItems.get(position).get("textView_01").toString());
        infoViewHolderclass.textView_02.setText(this.listItems.get(position).get("textView_02").toString());
        infoViewHolderclass.textView_03.setText(this.listItems.get(position).get("textView_03").toString());




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
