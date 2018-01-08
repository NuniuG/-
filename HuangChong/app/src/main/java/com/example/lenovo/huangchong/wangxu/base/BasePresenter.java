package com.example.lenovo.huangchong.wangxu.base;

/**
 * Created by 110 on 2018/1/3.
 */
public abstract class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;

    public void setMV(M m, V v) {
        this.baseModel = m;
        this.baseView = v;
        this.onStart();
    }

    public abstract void onStart();
}
