package com.example.lenovo.huangchong.chehua.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;

import butterknife.Bind;

public class RegisterActivity extends BaseActivity<Presenter, Model> {

    @Bind(R.id.qx)
    TextView qx;
    @Bind(R.id.hc)
    TextView hc;
    @Bind(R.id.code)
    Button code;
    @Bind(R.id.sr)
    EditText sr;
    @Bind(R.id.mm)
    EditText mm;
    @Bind(R.id.yhm)
    EditText yhm;
    @Bind(R.id.regis)
    Button regis;
    @Bind(R.id.qq2)
    LinearLayout qq1;
    @Bind(R.id.wexin1)
    LinearLayout wexin1;
    @Bind(R.id.sjh)
    EditText sjh;
    private Context contxt;
    private String username;
    private String password;
    private SharedPreferences sp;


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

        qx = (TextView) findViewById(R.id.qx);
        hc = (TextView) findViewById(R.id.hc);
        code = (Button) findViewById(R.id.code);
        sr = (EditText) findViewById(R.id.sr);
        mm = (EditText) findViewById(R.id.mm);
        yhm = (EditText) findViewById(R.id.yhm);
        regis = (Button) findViewById(R.id.regis);
        qq1 = (LinearLayout) findViewById(R.id.qq2);
        wexin1 = (LinearLayout) findViewById(R.id.wexin1);
        sjh = (EditText) findViewById(R.id.sjh);



        qx.setOnClickListener(this);
        wexin1.setOnClickListener(this);
        hc.setOnClickListener(this);
        qq1.setOnClickListener(this);
        code.setOnClickListener(this);
        regis.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 取消
            case R.id.qx:
                finish();
                break;
            // 登录
            case R.id.hc:
                finish();
                break;
            // 验证码
            case R.id.code:

                Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();

                break;
             // 注册

            case R.id.regis:



                break;
            // QQ登录
            case R.id.qq2:

                break;
            // 微信登录
            case R.id.wexin1:

                break;
        }
    }


    private void submit() {
        // validate
        String srString = sr.getText().toString().trim();
        if (TextUtils.isEmpty(srString)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String mmString = mm.getText().toString().trim();
        if (TextUtils.isEmpty(mmString)) {
            Toast.makeText(this, "请设置密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String yhmString = yhm.getText().toString().trim();
        if (TextUtils.isEmpty(yhmString)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String sjhString = sjh.getText().toString().trim();
        if (TextUtils.isEmpty(sjhString)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }


    }

}
