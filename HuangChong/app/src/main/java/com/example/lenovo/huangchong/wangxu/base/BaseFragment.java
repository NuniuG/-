package com.example.lenovo.huangchong.wangxu.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 110 on 2018/1/3.
 */

public abstract class BaseFragment <P extends BasePresenter,M extends BaseModel> extends Fragment {


    public P mPresenter;
    public M mModel;
    private View view;
    //是否可见
    protected  boolean isVisble;
    //标志位。标志Fragment已经初始化完成
    public boolean isPrepared = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setMV(mModel,this);
        }

        view = inflater.inflate(getLayoutIdFragmen(), container, false);

        initView(view);

        return view;
    }



    private void onVisible() {
        //加载数据
        loadData();
    }

    protected abstract void loadData();

    protected abstract int getLayoutIdFragmen();

    protected abstract void initView(View view);
}
