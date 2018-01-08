package com.example.lenovo.huangchong.wangxu.app;


import android.app.Application;

import com.example.lenovo.huangchong.wangxu.base.BaseActivity;
import com.example.lenovo.huangchong.wangxu.base.BaseFragment;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by 110 on 2018/1/3.
 */

public class App extends Application {
    public static BaseActivity baseActivity;
    public static BaseFragment baseFragment;
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("2227647331", "9c29cc8bc30f5edc087bde312ef083a1", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        Config.DEBUG = true;
    }
}
