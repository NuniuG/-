package com.example.lenovo.huangchong.wangxu.tmvp;


import com.example.lenovo.huangchong.wangxu.base.BaseModel;
import com.example.lenovo.huangchong.wangxu.base.BasePresenter;
import com.example.lenovo.huangchong.wangxu.base.BaseView;

/**
 * Created by 110 on 2018/1/3.
 */

public class Contract  {

    interface View extends BaseView {
        void show(String url);
    }

    interface Model extends BaseModel {
        void getLunData(String url, Callback callBack);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void isLunNet(String str);
    }
}