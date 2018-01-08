package com.example.lenovo.huangchong.chehua.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.tmvp.Model;
import com.example.lenovo.huangchong.wangxu.tmvp.Presenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WalletActivity extends BaseActivity<Presenter, Model> {


    @Bind(R.id.fh31)
    TextView fh3;
    @Bind(R.id.record1)
    TextView record1;
    @Bind(R.id.money)
    TextView money;
    @Bind(R.id.recharge)
    Button recharge;
    @Bind(R.id.withdrawals)
    Button withdrawals;
    @Bind(R.id.coupon)
    LinearLayout coupon;
    @Bind(R.id.alipay)
    LinearLayout alipay;
    @Bind(R.id.integral)
    LinearLayout integral;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_wallet;

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        fh3.setOnClickListener(this);
        record1.setOnClickListener(this);
        money.setOnClickListener(this);
        recharge.setOnClickListener(this);
        withdrawals.setOnClickListener(this);
        alipay.setOnClickListener(this);
        integral.setOnClickListener(this);
        coupon.setOnClickListener(this);

    }

    @Override

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fh31:
                finish();
                break;
            // 交易记录
            case R.id.record1:
                Toast.makeText(this, "交易记录", Toast.LENGTH_SHORT).show();
                break;
            // 充值
            case R.id.recharge:
                Toast.makeText(this, "充值", Toast.LENGTH_SHORT).show();
                break;
            //提现
            case R.id.withdrawals:
                Toast.makeText(this, "提现", Toast.LENGTH_SHORT).show();
                break;
            //支付宝
            case R.id.alipay:
                Toast.makeText(this, "支付宝", Toast.LENGTH_SHORT).show();
                break;
            //优惠券
            case R.id.coupon:
                Toast.makeText(this, "优惠券", Toast.LENGTH_SHORT).show();
                break;
            //积分
            case R.id.integral:

                Intent intent = new Intent(WalletActivity.this,IntegralActivity.class);
                startActivity(intent);

                break;
        }
    }


    }

