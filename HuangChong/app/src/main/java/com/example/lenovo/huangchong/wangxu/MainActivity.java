package com.example.lenovo.huangchong.wangxu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.chehua.ui.SetUpActivity;
import com.example.lenovo.huangchong.chehua.ui.UserActivity;
import com.example.lenovo.huangchong.chehua.ui.WalletActivity;
import com.example.lenovo.huangchong.wangxu.Bean1.Bean1;
import com.example.lenovo.huangchong.wangxu.adapter.RecyclerviewAdapter;
import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.image1)
    ImageView image1;
    @Bind(R.id.rb1)
    CheckBox rb1;
    @Bind(R.id.rb2)
    CheckBox rb2;
    @Bind(R.id.rb3)
    CheckBox rb3;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.user)
    LinearLayout user;
    @Bind(R.id.information)
    LinearLayout information;
    @Bind(R.id.pet)
    LinearLayout pet;
    @Bind(R.id.order)
    LinearLayout order;
    @Bind(R.id.wallet)
    LinearLayout wallet;
    @Bind(R.id.know)
    LinearLayout know;
    @Bind(R.id.setup)
    LinearLayout setup;
    @Bind(R.id.apply)
    Button apply;
    private Context contxt;
    private ImageView image_q;
    private TextView text_name;

    @Bind(R.id.Homerecyclerview)
    RecyclerView Homerecyclerview;
    private PopupWindow popupWindow;
    private PopupWindow popupWindow2;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private List<Bean1> list = new ArrayList<>();
    private TextView tv_all_address;
    private boolean isFirstIn;


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        user = (LinearLayout) findViewById(R.id.user);
        user.setOnClickListener(this);

        information = (LinearLayout) findViewById(R.id.information);
        information.setOnClickListener(this);

        pet = (LinearLayout) findViewById(R.id.pet);
        pet.setOnClickListener(this);

        order = (LinearLayout) findViewById(R.id.order);
        order.setOnClickListener(this);

        wallet = (LinearLayout) findViewById(R.id.wallet);
        wallet.setOnClickListener(this);

        know = (LinearLayout) findViewById(R.id.know);
        know.setOnClickListener(this);

        setup = (LinearLayout) findViewById(R.id.setup);
        setup.setOnClickListener(this);

        apply = (Button) findViewById(R.id.apply);
        apply.setOnClickListener(this);

        image_q = (ImageView) findViewById(R.id.image);
        text_name = (TextView) findViewById(R.id.name);


        String iconurl = getIntent().getStringExtra("iconurl");
        String name = getIntent().getStringExtra("name");
        text_name.setText(name);
        Picasso.with(MainActivity.this).load(iconurl).into(image_q);


        image1.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
        initData();
        ImageView ditu = (ImageView) findViewById(R.id.ditu);
        ditu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapActivity.class));
            }
        });

    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new Bean1(R.mipmap.ic_launcher, "小长+1", 10 + i + ""));
        }

        RecyclerviewAdapter adapter = new RecyclerviewAdapter(getApplication(), list);
        Homerecyclerview.setLayoutManager(new LinearLayoutManager(this));
        Homerecyclerview.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image1:
                Toast.makeText(MainActivity.this, "49646", Toast.LENGTH_SHORT).show();
                break;
            //个人
            case R.id.user:
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
                break;
            //消息
            case R.id.information:
                Toast.makeText(this, "消息", Toast.LENGTH_SHORT).show();
                break;
            //宠物
            case R.id.pet:
                Toast.makeText(this, "宠物", Toast.LENGTH_SHORT).show();

                break;
            //订单
            case R.id.order:

                Toast.makeText(this, "订单", Toast.LENGTH_SHORT).show();
                break;

            //钱包
            case R.id.wallet:

                Intent walle = new Intent(MainActivity.this, WalletActivity.class);
                startActivity(walle);

                break;
            //需知
            case R.id.know:

                Toast.makeText(this, "需知", Toast.LENGTH_SHORT).show();
                break;
            //设置
            case R.id.setup:

                Intent intent1 = new Intent(MainActivity.this, SetUpActivity.class);
                startActivity(intent1);
                break;

            //申请成为寄养家庭
            case R.id.apply:
                Toast.makeText(this, "申请成为寄养家庭", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void Showpouplewindow() {
        //寻找布局
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popuplayout, null);


        text1 = contentView.findViewById(R.id.pop_computer);
        text2 = contentView.findViewById(R.id.pop_dingdan);
        text3 = contentView.findViewById(R.id.pop_haoping);
        text4 = contentView.findViewById(R.id.pop_jaige);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏popopwindow
                popupWindow.dismiss();
                //显示recyclerview
                Homerecyclerview.setVisibility(View.VISIBLE);
                rb1.setChecked(false);

            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                Homerecyclerview.setVisibility(View.VISIBLE);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                Homerecyclerview.setVisibility(View.VISIBLE);
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                Homerecyclerview.setVisibility(View.VISIBLE);
            }
        });

        popupWindow = new PopupWindow(contentView);
        //设置宽度
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置高度
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        //隐藏recyclerview
        Homerecyclerview.setVisibility(View.GONE);


//        popupWindow.setOutsideTouchable(true);

//        popupWindow.setFocusable(true);


        popupWindow.setTouchable(false);

        //设置入场动画
//        popupWindow.setAnimationStyle(R.style.contextMenuAnim);
        //显示popupwindow
        popupWindow.showAsDropDown(rb1);



    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {


    }

    public void click(View view) {

        CheckBox rButton = (CheckBox) view;
        boolean check = rButton.isChecked();
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        switch (view.getId()) {
            case R.id.rb1:
                if (check) {
                    Toast.makeText(MainActivity.this, "15646", Toast.LENGTH_SHORT).show();
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    Showpouplewindow();
                }

                break;
            case R.id.rb2:

                if (check) {
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    Showpouplewindow2();
                }

                break;
            case R.id.rb3:
                if (check) {
//                    popupWindow.dismiss();
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    Saixuan();

                }
                break;
        }

    }

    private void Saixuan() {
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popuplayout3, null);
        TextView textView = contentView.findViewById(R.id.tv_all_address);
        TextView dizhi = contentView.findViewById(R.id.dizhi);
        final CheckBox xizao = contentView.findViewById(R.id.xizao);
        CheckBox jiesong = contentView.findViewById(R.id.btn4);
        CheckBox yuandan = contentView.findViewById(R.id.jiedan);
        CheckBox viewById = contentView.findViewById(R.id.cunjie);
        CheckBox qingmingjie = contentView.findViewById(R.id.qingmingjie);
        CheckBox laodong = contentView.findViewById(R.id.laodong);
        CheckBox duanwu = contentView.findViewById(R.id.duanwu);
        CheckBox zhongqiu = contentView.findViewById(R.id.zhongqiu);
        CheckBox guoqing = contentView.findViewById(R.id.guoqing);
        TextView chongzhi = contentView.findViewById(R.id.guoqing);
        TextView chaxun = contentView.findViewById(R.id.main_screen);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XzcityActivity.class));

            }
        });


        xizao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    xizao.setBackgroundResource(R.color.huangse);
                } else {
                    xizao.setBackgroundResource(R.color.yuanse);
                }
            }
        });


        popupWindow = new PopupWindow(contentView);
        //设置宽度
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置高度
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);


        popupWindow.setTouchable(false);
        //隐藏recyclerview
        Homerecyclerview.setVisibility(View.GONE);


        //设置防止抢占焦点
//        popupWindow.setFocusable(true);

        //设置入场动画
//        popupWindow.setAnimationStyle(R.style.contextMenuAnim);
        //显示popupwindow
        popupWindow.showAsDropDown(rb1);


    }

    private void Showpouplewindow2() {
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popuplayouttwo, null);

        popupWindow = new PopupWindow(contentView);
        //设置宽度
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置高度
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        //隐藏recyclerview
        Homerecyclerview.setVisibility(View.GONE);


        popupWindow.setTouchable(false);
//        popupWindow.setFocusable(false);
        //设置入场动画
//        popupWindow.setAnimationStyle(R.style.contextMenuAnim);
        //显示popupwindow
        popupWindow.showAsDropDown(rb1);


    }


}





