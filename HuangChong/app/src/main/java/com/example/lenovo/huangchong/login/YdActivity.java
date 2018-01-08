package com.example.lenovo.huangchong.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.MainActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class YdActivity extends Activity {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.banner)
    Banner banner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yd);
        ButterKnife.bind(this);

        List<Integer> imaglist = new ArrayList<>();
        imaglist.add(R.drawable.pager01);
        imaglist.add(R.drawable.pager02);
        imaglist.add(R.drawable.pager03);

        banner.setImages(imaglist)//添加图片集合或图片url集合
                .isAutoPlay(false)//设置不自动轮播
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setImageLoader(new GlideImage())//加载图片
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                .start();
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 3) {
                    button.setVisibility(View.VISIBLE);
                } else {
//                    button.setVisibility(View.GONE);
                    button.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Intent intent = new Intent(YdActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }

    }
}
