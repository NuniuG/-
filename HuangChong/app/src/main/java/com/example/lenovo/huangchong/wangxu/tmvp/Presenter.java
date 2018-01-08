package com.example.lenovo.huangchong.wangxu.tmvp;

/**
* Created by TMVPHelper on 2018/01/03
*/
public class Presenter extends Contract.Presenter{

    @Override
    public void isLunNet(final String str) {
        baseModel.getLunData(str, new Callback() {
            @Override
            public void cauu(String cuu) {
                baseView.show(cuu);
            }

            @Override
            public void full(String fll) {

            }
        });
    }
}