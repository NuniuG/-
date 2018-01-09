package com.example.lenovo.huangchong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.beans.IndexBean;
import com.example.lenovo.huangchong.wangxu.XzcityActivity;


import java.util.List;

/**
 * Created by ASUS on 2018/1/8.
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class SubIndexAdapter extends BaseAdapter {
    private List<IndexBean> indexList;
    private Context context;
    private IndexViewHolder indexViewHolder;

    public SubIndexAdapter(XzcityActivity xzcityActivity, List<IndexBean> indexList) {
        this.indexList = indexList;
        this.context=xzcityActivity;

    }

    @Override
    public int getCount() {
        return indexList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.xzcity_item, null);
            indexViewHolder = new IndexViewHolder(view);

            view.setTag(indexViewHolder);
        }else {
            indexViewHolder= (IndexViewHolder) view.getTag();
        }
        String word = indexList.get(i).getHeaderWord();
        indexViewHolder.tv_word.setText(word);
        indexViewHolder.tv_name.setText(indexList.get(i).getName());

        //将相同字母开头的合并在一起
        if (i == 0) {
            //第一个是一定显示的
            indexViewHolder.tv_word.setVisibility(View.VISIBLE);
        } else {
            //后一个与前一个对比,判断首字母是否相同，相同则隐藏
            String headerWord = indexList.get(i - 1).getHeaderWord();
            if (word.equals(headerWord)) {
                indexViewHolder.tv_word.setVisibility(View.GONE);
            } else {
                indexViewHolder.tv_word.setVisibility(View.VISIBLE);
            }
        }
        return view;
    }


    public static class IndexViewHolder {
        public View rootView;
        public TextView tv_word;
        public TextView tv_name;

        public IndexViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_word = (TextView) rootView.findViewById(R.id.tv_word);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
