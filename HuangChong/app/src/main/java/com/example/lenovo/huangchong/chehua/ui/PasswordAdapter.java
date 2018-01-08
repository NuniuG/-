package com.example.lenovo.huangchong.chehua.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PasswordAdapter extends BaseActivity<Presenter, Model> {


    @Bind(R.id.fh5)
    TextView fh5;
    @Bind(R.id.submit)
    TextView submit;
    @Bind(R.id.edit1)
    EditText edit1;
    @Bind(R.id.edit2)
    EditText edit2;
    @Bind(R.id.code1)
    TextView code1;
    @Bind(R.id.edit3)
    EditText edit3;
    @Bind(R.id.edit4)
    EditText edit4;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_password_adapter;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        fh5.setOnClickListener(this);
        submit.setOnClickListener(this);
        code1.setOnClickListener(this);
    }

    @Override
    @OnClick({R.id.fh5, R.id.submit, R.id.code1})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fh5:
                finish();
                break;
            case R.id.submit:
                Toast.makeText(this, "提交", Toast.LENGTH_SHORT).show();
                break;
            case R.id.code1:
                Toast.makeText(this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
        }

    }




}
