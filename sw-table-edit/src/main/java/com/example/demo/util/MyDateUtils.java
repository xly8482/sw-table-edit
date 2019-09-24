package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {

	/**
	 * 比较日期是否相等
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean sameDate(Date d1, Date d2) {
		if (null == d1 || null == d2)
			return false;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		return cal1.getTime().equals(cal2.getTime());
	}

	/**
	 * 比较月份是否相等
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean sameMonth(Date d1, Date d2) {
		if (null == d1 || null == d2)
			return false;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		cal2.set(Calendar.DAY_OF_MONTH, 1);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		return cal1.getTime().equals(cal2.getTime());
	}

	/**
	 * 字符串转日期
	 * 
	 * @param dateStr
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String dateStr, String formatStr) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);

		Date date = null;
		try {
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
