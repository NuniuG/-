package com.example.lenovo.huangchong.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.example.lenovo.huangchong.R;
import com.example.lenovo.huangchong.wangxu.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends Activity {


    Handler handler = new Handler();
    @Bind(R.id.pathView)
    PathView pathView;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        SharedPreferences pref = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
        editor = pref.edit();
        initView();

    }

    private void initView() {
        pathView.getPathAnimator()
                .delay(1000)
                .duration(5000)
                .listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {

                    }
                })
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {

                    private boolean isFirstIn;

                    @Override
                    public void onAnimationEnd() {
                        pathView.setFillAfter(true);
                        SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
                        isFirstIn = sharedPreferences.getBoolean("isFirstIn", true);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (isFirstIn) {
                                    editor.putBoolean("isFirstIn", false);
                                    editor.commit();
                                    startActivity(new Intent(StartActivity.this, YdActivity.class));
                                    //设置切换动画，从右边进入，左边退出
                                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                                    finish();
                                } else {
                                    startActivity(new Intent(StartActivity.this, MainActivity.class));
                                    //设置切换动画，从右边进入，左边退出
                                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                                    finish();
                                }
                            }
                        }, 1000);
                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();
    }
}
