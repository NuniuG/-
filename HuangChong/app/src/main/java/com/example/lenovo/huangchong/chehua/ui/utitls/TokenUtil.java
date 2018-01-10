/**
 * @描述		:	
 * @作�??	    :Android - csx
 * @创建日期  :2016�?3�?23�? 下午7:12:37  
 *
 */
package com.example.lenovo.huangchong.chehua.ui.utitls;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @描述 :Token工具�?   获取token值
 * @作�?? :Android - csx
 * @创建日期 :2016�?3�?23�? 下午7:45:35
 * 
 */
public class TokenUtil {

	/**
	 * 唯一标示
	 */
	public static final String TOKEN = "token";

	// 全局上下�?
	private static Context context = null;

	public static void init(Context mContext) {
		context = mContext;
	}

	/**
	 * 
	 * @描述 :生成访问Token
	 * @方法名称 :createToken----&gt;TokenUtil.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?23�? 下午7:14:17
	 * @return
	 * 
	 */
	public static String createToken() {
		// 生成的token
		String token = null;
		//获取时间同时对时间进行格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取当前系统时间
		Date date = new Date(System.currentTimeMillis());

		// IPUtils.getIp(context)该方法获取ip地址
		//因此我们可以知道token有ip+时间+CD
		token = IPUtils.getIp(context) + sdf.format(date) + "CD";

		token = Md5Utils.md5(token, "utf-8");

		return token;
	}

}
