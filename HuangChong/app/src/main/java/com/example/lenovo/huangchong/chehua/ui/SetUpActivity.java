package com.example.lenovo.huangchong.chehua.ui;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetUpActivity extends BaseActivity<Presenter, Model> {


    @Bind(R.id.fh1)
    TextView fh1;
    @Bind(R.id.qd)
    TextView qd;
    @Bind(R.id.functions)
    LinearLayout functions;
    @Bind(R.id.score)
    LinearLayout score;
    @Bind(R.id.about)
    LinearLayout about;
    @Bind(R.id.display)
    CheckBox display;

    @Bind(R.id.introduction)
    LinearLayout introduction;
    @Bind(R.id.picture)
    LinearLayout picture;
    @Bind(R.id.caching)
    LinearLayout caching;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        fh1.setOnClickListener(this);
        qd.setOnClickListener(this);
        functions.setOnClickListener(this);
        score.setOnClickListener(this);
        about.setOnClickListener(this);
        introduction.setOnClickListener(this);
        picture.setOnClickListener(this);
        caching.setOnClickListener(this);

        display.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    display.setBackgroundResource(R.mipmap.on);
                }else {
                    display.setBackgroundResource(R.mipmap.off);
                }

            }
        });
    }

    @Override
    @OnClick({R.id.fh1, R.id.qd, R.id.functions, R.id.score, R.id.about, R.id.display, R.id.linearLayout5, R.id.introduction, R.id.picture, R.id.caching})
    public void onClick(View view) {
        switch (view.getId()) {
            //返回
            case R.id.fh1:
                finish();
                break;
            //确定
            case R.id.qd:
                Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
                break;



            //建议introduc tion
            case R.id.introduction:
                Toast.makeText(this, "建议", Toast.LENGTH_SHORT).show();
                break;


            //新功能介绍functions
            case R.id.functions:
                Toast.makeText(this, "新功能介绍", Toast.LENGTH_SHORT).show();
                break;



            //去评分score
            case R.id.score:

                Intent intent = new Intent(SetUpActivity.this,ScoreActivity.class);
                startActivity(intent);

                break;


            //关于欢欢about
            case R.id.about:
                Toast.makeText(this, "关于欢欢", Toast.LENGTH_SHORT).show();
                break;





            //图片缓存文件大小
            case R.id.picture:
                Toast.makeText(this, "图片缓存文件大小", Toast.LENGTH_SHORT).show();
                break;
            //清除缓存
            case R.id.caching:
                Toast.makeText(this, "清除缓存", Toast.LENGTH_SHORT).show();
                break;
        }

    }



}
