package com.example.demo.util;

import java.math.BigDecimal;

public class MyNumberUtils {

	/**
	 * double四舍五入保留N位小数
	 * @param digit
	 * @param val
	 * @return
	 */
	public static Double doubleRounding(int digit, Double val) {
		BigDecimal b = new BigDecimal(val);
		val = b.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
		return val;
	}

}
