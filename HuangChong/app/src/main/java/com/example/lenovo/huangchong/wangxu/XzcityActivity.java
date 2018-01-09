package com.example.lenovo.huangchong.wangxu;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.huangchong.IndexListView;
import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.adapter.SubIndexAdapter;
import com.example.lenovo.huangchong.beans.IndexBean;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class XzcityActivity extends BaseActivity<Presenter, Model> implements IndexListView.onWordsChangeListener {


    @Bind(R.id.list)
    ListView list;
    @Bind(R.id.words)
    IndexListView words;
    @Bind(R.id.tv)
    TextView tv;
    List<IndexBean> indexList = new ArrayList<>();
    Handler handler  = new Handler();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_xzcity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        words.setOnWordsChangeListener(this);
        SubIndexAdapter subIndexAdapter = new SubIndexAdapter(XzcityActivity.this,indexList);
        list.setAdapter(subIndexAdapter);
        initData();
    }

    private void initData() {
        indexList.add(new IndexBean("澳门","AoMen","A"));
        indexList.add(new IndexBean("北京","BeiJing","B"));
        indexList.add(new IndexBean("重庆","ChongQing","C"));
        indexList.add(new IndexBean("福建","FuJian","F"));
        indexList.add(new IndexBean("上海","ShangHai","S"));
        indexList.add(new IndexBean("广州","GhuangZhou","G"));
        indexList.add(new IndexBean("深圳","ShenZhen","S"));
        indexList.add(new IndexBean("山西","ShanXi","S"));
        indexList.add(new IndexBean("山东","ShanDong","S"));

        indexList.add(new IndexBean("天津","TianJing","T"));
        indexList.add(new IndexBean("黑龙江","HeiLongJiang","H"));
        indexList.add(new IndexBean("河北","HeBei","H"));
        indexList.add(new IndexBean("河南","HeNan","H"));
        indexList.add(new IndexBean("吉林","JiLin","J"));


        //对集合排序
        Collections.sort(indexList, new Comparator<IndexBean>() {
            @Override
            public int compare(IndexBean bean1, IndexBean bean2) {
                //根据拼音进行排序
                return bean1.getPinyin().compareTo(bean2.getPinyin());
            }
        });

        updateListView();

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//当滑动列表的时候，更新右侧字母列表的选中状态
                words.setTouchIndex(indexList.get(i).getHeaderWord());
            }
        });

    }


    private void updateListView() {
        for (int i = 0; i < indexList.size(); i++) {
            String headerWord = indexList.get(i).getHeaderWord();
            //将手指按下的字母与列表中相同字母开头的项找出来
            if (words.equals(headerWord)) {
                //将列表选中哪一个
                list.setSelection(i);
                //找到开头的一个即可
                return;
            }
        }
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void wordsChange(String words) {
        updateWord(words);
    }

    private void updateWord(String words) {
        tv.setText(words);
        tv.setVisibility(View.VISIBLE);
        //清空之前的所有消息
        handler.removeCallbacksAndMessages(null);
        //500ms后让tv隐藏
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setVisibility(View.GONE);
            }
        }, 500);
    }
}
