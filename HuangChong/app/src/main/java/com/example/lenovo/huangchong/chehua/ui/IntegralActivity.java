package com.example.lenovo.huangchong.chehua.ui;

import android.view.View;
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

public class IntegralActivity extends BaseActivity<Presenter, Model> {

    @Bind(R.id.pop)
    TextView pop;
    @Bind(R.id.everyday)
    LinearLayout everyday;
    @Bind(R.id.fh4)
    TextView fh4;
    @Bind(R.id.raise)
    LinearLayout raise;
    @Bind(R.id.publish)
    LinearLayout publish;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_integral;

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        pop.setOnClickListener(this);
        fh4.setOnClickListener(this);
        everyday.setOnClickListener(this);
        raise.setOnClickListener(this);
        publish.setOnClickListener(this);

    }

    @Override
    @OnClick({R.id.pop, R.id.everyday, R.id.fh4, R.id.raise, R.id.publish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pop:
                Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fh4:
                finish();
                break;
            case R.id.everyday:
                Toast.makeText(this, "任务1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.raise:
                Toast.makeText(this, "好评3", Toast.LENGTH_SHORT).show();

                break;
            case R.id.publish:
                Toast.makeText(this, "发表2", Toast.LENGTH_SHORT).show();
                break;
        }
    }




}
