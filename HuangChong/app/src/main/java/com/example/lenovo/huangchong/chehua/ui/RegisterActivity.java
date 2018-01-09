package com.example.lenovo.huangchong.chehua.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
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

import org.json.JSONObject;

import butterknife.Bind;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

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

    EventHandler eventHandler;
    private String TAG;
    private String strPhoneNumber;


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


        SMSSDK.initSDK(this, "2399edf332f4c", "f67043c84aed4ee416962464e3b10eb7");
        eventHandler = new EventHandler() {

            /**
             * 在操作之后被触发
             *
             * @param event  参数1
             * @param result 参数2 SMSSDK.RESULT_COMPLETE表示操作成功，为SMSSDK.RESULT_ERROR表示操作失败
             * @param data   事件操作的结果
             */

            @Override
            public void afterEvent(int event, int result, Object data) {
                Message message = myHandler.obtainMessage(0x00);
                message.arg1 = event;
                message.arg2 = result;
                message.obj = data;
                myHandler.sendMessage(message);
            }
        };

        SMSSDK.registerEventHandler(eventHandler);



    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
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

                if (v.getId() == R.id.regis) {
                    String strCode = sr.getText().toString();
                    if (null != strCode && strCode.length() == 4) {
                        Log.d(TAG, sr.getText().toString());
                        SMSSDK.submitVerificationCode("86", strPhoneNumber, sr.getText().toString());
                }
                } else if (v.getId() == R.id.code) {
                    strPhoneNumber = sjh.getText().toString();
                    if (null == strPhoneNumber || "".equals(strPhoneNumber) || strPhoneNumber.length() != 11) {
                        Toast.makeText(this, "电话号码输入有误", Toast.LENGTH_SHORT).show();
                        return;
                    }




                    SMSSDK.getVerificationCode("86", strPhoneNumber);
                    code.setClickable(false);
                    //开启线程去更新button的text
                    new Thread() {
                        @Override
                        public void run() {
                            int totalTime = 60;
                            for (int i = 0; i < totalTime; i++) {
                                Message message = myHandler.obtainMessage(0x01);
                                message.arg1 = totalTime - i;
                                myHandler.sendMessage(message);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            myHandler.sendEmptyMessage(0x02);
                        }
                    }.start();
                }

                break;
             // 注册

            case R.id.regis:
                mm.getText().toString();
                if (yhm!=null&& mm.length()>=6){
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);

                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            }else {
                    Toast.makeText(this, "密码长度或者用户名不正确", Toast.LENGTH_SHORT).show();
                }



                break;
            // QQ登录
            case R.id.qq2:

                break;
            // 微信登录
            case R.id.wexin1:

                break;
        }
    }



    Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x00:
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    Log.e(TAG, "result : " + result + ", event: " + event + ", data : " + data);
                    if (result == SMSSDK.RESULT_COMPLETE) { //回调  当返回的结果是complete
                        if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) { //获取验证码
                            Toast.makeText(RegisterActivity.this, "发送验证码成功", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "get verification code successful.");
                        } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) { //提交验证码
                            Log.d(TAG, "submit code successful");
                            Toast.makeText(RegisterActivity.this, "提交验证码成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.d(TAG, data.toString());
                        }
                    } else { //进行操作出错，通过下面的信息区分析错误原因
                        try {
                            Throwable throwable = (Throwable) data;
                            throwable.printStackTrace();
                            JSONObject object = new JSONObject(throwable.getMessage());
                            String des = object.optString("detail");//错误描述
                            int status = object.optInt("status");//错误代码
                            //错误代码：  http://wiki.mob.com/android-api-%E9%94%99%E8%AF%AF%E7%A0%81%E5%8F%82%E8%80%83/
                            Log.e(TAG, "status: " + status + ", detail: " + des);
                            if (status > 0 && !TextUtils.isEmpty(des)) {
                                Toast.makeText(RegisterActivity.this, des, Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 0x01:
                    code.setText("重新发送(" + msg.arg1 + ")");
                    break;
                case 0x02:
                    code.setText("获取验证码");
                    code.setClickable(true);
                    break;
            }
        }
    };

}
