package com.anxinghei.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getDataforBook() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(new Date());
	}

	public static String getDataforBand() {
		SimpleDateFormat df = new SimpleDateFormat("MMdd");
		return df.format(new Date());
	}
	
	public static String getMonth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		return df.format(new Date());
	}
	
	public static String getYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(new Date());
	}

	// 是否在规定打折时间内
	public static boolean isBand(String startday, String endday) {
		String date = getDataforBand();
		if (date.compareTo(startday) >= 0 && date.compareTo(endday) < 0) {
			return true;
		}
		return false;
	}

	// 订房时间内是否已有其他属于该房间的订单
	public static boolean isBooked(String startday, String endday, String bookedStartday, String bookedEndday) {
		if (endday.compareTo(bookedStartday) <= 0 || startday.compareTo(bookedEndday) >= 0) {
			// 预订时间不与已有订单时间冲突，可以订房
			return true;
		}
		return false;
	}

}
