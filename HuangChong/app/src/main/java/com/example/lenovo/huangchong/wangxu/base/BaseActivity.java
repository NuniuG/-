package com.example.lenovo.huangchong.wangxu.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lenovo.huangchong.wangxu.app.App;


public abstract class  BaseActivity <P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements View.OnClickListener {


    public P mPresenter;
    public M mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResID());

        App.baseActivity = this;
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);

        if (this instanceof BaseView) {
            mPresenter.setMV(mModel, this);
        }
        initView();


    }

    protected abstract int getLayoutResID();

    /**
     * 获得Layout文件id
     *
     * @return
     */



    protected abstract void initView();


}
