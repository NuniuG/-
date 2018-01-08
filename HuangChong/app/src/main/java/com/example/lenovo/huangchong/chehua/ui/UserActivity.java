package com.example.lenovo.huangchong.chehua.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.MainActivity;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

public class UserActivity extends BaseActivity<Presenter, Model> {

    @Bind(R.id.fh)
    TextView fh;
    @Bind(R.id.edit1)
    EditText edit1;
    @Bind(R.id.edit2)
    EditText edit2;
    @Bind(R.id.password)
    TextView password;
    @Bind(R.id.sing_in)
    Button singIn;
    @Bind(R.id.wexin)
    LinearLayout wexin;
    @Bind(R.id.qq)
    LinearLayout qq;
    @Bind(R.id.register)
    TextView register;
    private UMShareAPI mShareAPI;

    private UMAuthListener umAuthListener = new UMAuthListener() {
        public String iconurls;
        public String iconurl;
        public String name;
        public String names;

        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Set<String> strings = data.keySet();
            for (String string:strings){
                if (string.equals("iconurl")){
                    iconurl = data.get("iconurl");
                }if (string.equals("name")){
                    name = data.get("name");
                }
            }

            Intent intent = new Intent(UserActivity.this, MainActivity.class);
            intent.putExtra("iconurl",iconurl);
            intent.putExtra("name",name);
            startActivity(intent);


            Intent intent1 = new Intent(UserActivity.this, ScoreActivity.class);
            intent1.putExtra("iconurls",iconurl);
            intent1.putExtra("names",name);
            startActivity(intent1);
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };






    @Override
    protected int getLayoutResID() {
        return R.layout.activity_user;
    }

    @Override
    protected void initView() {
        fh = (TextView) findViewById(R.id.fh);
        fh.setOnClickListener(this);

        password = (TextView) findViewById(R.id.password);
        password.setOnClickListener(this);

        singIn = (Button) findViewById(R.id.sing_in);
        singIn.setOnClickListener(this);

        wexin = (LinearLayout) findViewById(R.id.wexin);
        wexin.setOnClickListener(this);

        qq = (LinearLayout) findViewById(R.id.qq);
        qq.setOnClickListener(this);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    @OnClick({R.id.fh, R.id.password, R.id.sing_in, R.id.wexin, R.id.qq})
    public void onClick(View view) {

        switch (view.getId()) {
            //返回
            case R.id.fh:
                finish();
                break;
            //注册
            case R.id.register:

                Intent intent = new Intent(UserActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            //找回密码
            case R.id.password:
                Intent intent1 =new Intent(UserActivity.this,PasswordAdapter.class);
                startActivity(intent1);
                break;
            //登录
            case R.id.sing_in:

                break;
            //微信登录
            case R.id.wexin:

                break;
            //QQ登录
            case R.id.qq:
                UMShareAPI.get(UserActivity.this).getPlatformInfo(UserActivity.this,SHARE_MEDIA.QQ,umAuthListener);
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
