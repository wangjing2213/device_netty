package com.dearho.util;


import java.text.DecimalFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class DateUtils {

	public static final String YMD1="yyyy-MM-dd";
	public static final String YMD2="yyyyMMdd";
	public static final String YMDHMS1="yyyy-MM-dd HH:mm:ss";
	public static final String YMDHMS2="yyyyMMddHHmmss";
	


	/**
	 * @see 按指定格式取得当前时间字符串
	 * @return String
	 */
	public static String now(String pattern) {
		return DateTime.now().toString(DateTimeFormat.forPattern(pattern));
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 字符串转为DateTime
	 * @param d
	 * @return
	 */
	public static DateTime parse(String d){
		return parse(d,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 字符串转为DateTime
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static DateTime parse(String d,String pattern){
		return DateTimeFormat.forPattern(pattern).parseDateTime(d);
	}
	
	/**
	 * 将字符串时间从一种格式转换为另一种格式
	 * @param d
	 * @param fromPattern
	 * @param toPattern
	 * @return
	 */
	public static String strTranslate(String d,String fromPattern,String toPattern){
		return parse(d,fromPattern).toString(toPattern);
	}
	
	/**
	 * 比较两个date时间的时间差
	 * @param startTime 一个源时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * @param endTime 一个目标时间数据(格式要求：yyyy-MM-dd hh:mm 或 yyyy-MM-dd hh:mm:ss)
	 * return 输出格式为 年:月:日:时:分:秒
	 * add by wangtao
	 */	
	public static String dateBetween(Date startDate, Date endDate) {
		String date = "";
		try {
			long startTime = startDate.getTime()/1000;
			long endTime = endDate.getTime()/1000;	
			long l = endTime-startTime;
			long hour = l/(60*60);
			long min = ((l/(60))-hour*60);
			long s = (l-hour*60*60-min*60);
			date =  hour + ":" + min + ":" + s; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 比较两个date时间的相差多少个固定秒数
	 * @param startTime 一个源时间数据
	 * @param endTime 一个目标时间数据
	 * @param num 固定时间的秒数
	 * return 输出格式int 次数     像下取整  小数部分省略
	 * add by wangtao
	 */	
	public static int dateBetween(Date startDate, Date endDate, int num) {
		int times = 0 ;
		try {
			long startTime = startDate.getTime()/1000;
			long endTime = endDate.getTime()/1000;	
			long l = endTime-startTime;
			times = Integer.parseInt(new DecimalFormat("#").format(l/num));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return times;
	}
}
