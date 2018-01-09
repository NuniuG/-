package com.example.lenovo.huangchong.wangxu.app;

import android.content.Context;

public class AppUtils {
	// 保存用户或寄养师当前是否切换状态
	public static boolean isUserState;
	// 全局上下文
	public static Context appContext;

	// http://192.168.25.167

	// http://www.yhq1913.com

	// 内网请求连接http://123.56.150.230:8885/dog_family/    192.168.43.249
	//public static final String BASE_URL = "http://123.56.150.230:8885";
	public static final String BASE_URL = "http://172.16.52.38:8080";
	//public static final String BASE_URL = "http://169.254.200.100:8080";
	//public static final String BASE_URL = "http://192.168.43.249:8080";

	// 数据请求URL
	public static final String REQUESTURL = BASE_URL + "/dog_family/";

	// 请求图片的URL
	public static final String HTTP_IMAGE_URL = BASE_URL + "/dog_family/upload";





}
