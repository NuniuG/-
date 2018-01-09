package com.example.lenovo.huangchong.chehua.ui.utitls;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Description:(签名工具类)
 * @ClassName: SignUtil
 * @author maorw maorw@tctogether.com
 * @date 2016�?3�?13�? 下午2:19:59
 *       <p>
 *       北京天成合科�?有限公司版权�?�?
 *       </p>
 */
public class SignUtil {

	public static final String SIGN = "sign";

	/**
	 * 把数组所有元素排序，并按照�?�参�?=参数值�?�的模式用�??&”字符拼接成字符�?
	 * 
	 * @param params
	 *            �?要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, Object> params) {
		if (params == null) {
			return "";
		}
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		StringBuffer prestr = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			Object value = null;
			if (params.get(key) == null) {
				continue;
			} else {
				value = params.get(key);
			}

			if (params.get(key) instanceof String
					|| params.get(key) instanceof Integer
					|| params.get(key) instanceof BigDecimal
					|| params.get(key) instanceof Double
					|| params.get(key) instanceof Long) {
				if (i == keys.size() - 1) {// 拼接时，不包括最后一�?&字符
					prestr.append(key + "=" + value);
				} else {
					prestr.append(key + "=" + value + "&");
				}
			}
		}
		return prestr.toString();
	}

	/**
	 * 把数组所有元素排序，并按照�?�参�?=参数值�?�的模式用�??&”字符拼接成字符�?
	 * 
	 * @param
	 *            �?要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(List<Map<String, Object>> data) {

		String prestr = "";
		for (int i = 0; i < data.size(); i++) {
			List<String> keys = new ArrayList<String>(data.get(i).keySet());
			Collections.sort(keys);
			for (int j = 0; j < keys.size(); j++) {
				String key = keys.get(j);
				String value = data.get(i).get(key).toString();
				if (i == data.size() - 1 && j == keys.size() - 1) {// 拼接时，不包括最后一�?&字符
					prestr = prestr + key + "=" + value;
				} else {
					prestr = prestr + key + "=" + value + "&";
				}
			}
		}

		return prestr;
	}

	/**
	 * 获取验证签名
	 * 
	 * @param params
	 * @return
	 */
	public static String getSign(Map<String, Object> params) {
		String sign = Md5Utils.md5(createLinkString(params) + "1", "utf-8");
		return sign;
	}

	/**
	 * 获取验证签名
	 * 
	 * @param
	 * @return
	 */
	public static String getSign(List<Map<String, Object>> data) {
		String sign = Md5Utils.md5(createLinkString(data) + "1", "utf-8");
		return sign;
	}

}
