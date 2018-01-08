package com.example.lenovo.huangchong.wangxu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.Bean1.Bean1;

import java.util.List;
//
//compile 'com.android.support:design:23.0.0'
//compile 'com.squareup.okhttp3:okhttp:3.9.0'
//compile 'com.youth.banner:banner:1.4.9'
//compile 'com.github.bumptech.glide:glide:3.8.0'
//compile 'com.google.code.gson:gson:2.2.4'
//compile 'com.github.bumptech.glide:glide:3.8.0'

/**
 * Created by dell on 2018/1/5.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Viewholder>{
    private Context context;
    private List<Bean1> list;

    public RecyclerviewAdapter(Context context, List<Bean1> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item2, null);
        Viewholder viewholder=new Viewholder(inflate);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.image1.setImageResource(list.get(position).getImage());
        holder.text1.setText(list.get(position).getName());
        holder.text2.setText(list.get(position).getDizhi());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends ViewHolder{

        private final ImageView image1;
        private final TextView text1;
        private final TextView text2;

        public Viewholder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
}
