package com.example.lenovo.huangchong.wangxu.tmvp;


import com.example.lenovo.huangchong.wangxu.app.App;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
* Created by TMVPHelper on 2018/01/03
*/
public class Model implements Contract.Model{
    private  static Model model;
    private OkHttpClient clien;

    public static Model getInstanc(){
        if (model == null){
            synchronized (Model.class){
                model = new Model();
            }
        }
        return model;
    }

    public Model() {
        clien = new OkHttpClient();
    }

    @Override
    public void getLunData(String url, final Callback callBack) {
        Request request = new Request.Builder().url(url).build();
        clien.newCall(request).enqueue(new okhttp3.Callback() {


            public String string;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            string = response.body().string();

                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.cauu(string);
                    }
                });

            }
        });

    }
}