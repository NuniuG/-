package com.example.lenovo.huangchong.chehua.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScoreActivity extends BaseActivity<Presenter, Model> {


    @Bind(R.id.fh2)
    TextView fh2;
    @Bind(R.id.namma)
    TextView namma;
    @Bind(R.id.tx)
    ImageView tx;
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;
    @Bind(R.id.editText)
    EditText editText;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_score;


    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        fh2.setOnClickListener(this);

        String iconurls = getIntent().getStringExtra("iconurls");
        String name = getIntent().getStringExtra("names");
        namma.setText(name);
        Picasso.with(ScoreActivity.this).load(iconurls).into(tx);
    }

    @Override
    @OnClick({R.id.fh2, R.id.namma, R.id.tx, R.id.ratingBar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fh2:
                finish();
                break;
            case R.id.ratingBar:
                break;
        }
    }

}
