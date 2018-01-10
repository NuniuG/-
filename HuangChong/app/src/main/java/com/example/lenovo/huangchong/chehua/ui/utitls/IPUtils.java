/**
 * @描述		:	
 * @作�??	    :Android - csx
 * @创建日期  :2016�?3�?14�? 下午3:01:54  
 *
 */
package com.example.lenovo.huangchong.chehua.ui.utitls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * @描述 :网络判断工具
 * @作�?? :Android - csx
 * @创建日期 :2016�?3�?14�? 下午3:01:54
 * 
 */
public class IPUtils {

	// 获取网络管理信息
	private static ConnectivityManager manager = null;

	// 获取网络信息
	private static NetworkInfo network = null;

	public static final String IP = "ip";

	/**
	 * 
	 * @描述 :是否连接网络
	 * @方法名称 :isConnNetWork----&gt;IPUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?14�? 下午3:03:02
	 * @return
	 * 
	 */
	@SuppressWarnings("static-access")
	public static boolean isConnNetWork(Context context) {
		manager = (ConnectivityManager) context
				.getSystemService(context.CONNECTIVITY_SERVICE);
		network = manager.getActiveNetworkInfo();
		if (network != null && network.isAvailable()
				&& network.isConnectedOrConnecting()) {
			// 有网
			return true;
		} else {
			// 没网
			return false;
		}
	}

	/**
	 * 
	 * @描述 :判断当前网络是否为WiFi
	 * @方法名称 :isWiFi----&gt;IPUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?14�? 下午3:21:46
	 * @return
	 * 
	 */
	@SuppressWarnings("static-access")
	public static boolean isWiFi(Context context) {
		manager = (ConnectivityManager) context
				.getSystemService(context.CONNECTIVITY_SERVICE);
		network = manager.getActiveNetworkInfo();
		if (network != null && network.isAvailable()) {
			// 是网
			if (network.getType() == ConnectivityManager.TYPE_WIFI) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * @描述 :获取ip
	 * @方法名称 :getIp----&gt;IPUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?24�? 上午9:11:24
	 * @param context
	 * @return
	 * 
	 */
	public static String getIp(Context context) {
		// 获取WiFi管理器
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(context.WIFI_SERVICE);
		// 判断wifi是否开启
		if (!wifiManager.isWifiEnabled()) {
			return "127.0.0.9";
		}
		//下面这两行代码来获取ip地址
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int ipAddress = wifiInfo.getIpAddress();

		//当我们获取ip后是int类型的,需要使用该方法来转化为String类型的ip
		String ip = intToIp(ipAddress);

		return ip;

	}

	/**
	 * 
	 * @描述 :转化ip
	 * @方法名称 :intToIp----&gt;IPUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?24�? 上午9:11:02
	 * @param i
	 * @return
	 * 
	 */
	private static String intToIp(int i) {

		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
				+ "." + (i >> 24 & 0xFF);
	}
}
