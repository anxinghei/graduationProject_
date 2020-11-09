package com.anxing.sys.util;

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

	

}
