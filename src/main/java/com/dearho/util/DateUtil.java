package com.dearho.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Author wangyx
 * @Description:(此类型的描述)
 * @Version 1.0, 2015-4-21
 */
public class DateUtil
{
	
	
	private static SimpleDateFormat time = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat time10 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat time4 = new SimpleDateFormat("yyyy");
	private static SimpleDateFormat time6 = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat time8 = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat time7 = new SimpleDateFormat("MM-dd");
	private static SimpleDateFormat time14 = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static SimpleDateFormat time12 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static SimpleDateFormat time15 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	private static SimpleDateFormat time11= new SimpleDateFormat("MM/dd HH:mm");
	public static String getChar15DateString(Date date) {
		if(date!=null){
			return time15.format(date);
		}else{
			return null;
		}
	}
	public static String  getDateString(Date date,SimpleDateFormat format){
		return format.format(date);
	}
	public static String getChar19DateString(Date date) {
		if(date==null){
			return null;
		}
		return time.format(date);
	}
	public static String getChar12DateString(Date date) {
		if(date==null){
			return null;
			
		}else{
			return time12.format(date);
		}
		
	}
	
	public static String getChar11DateString(Date date) {
		if(date!=null){
			return time11.format(date);
		}else{
			return "";
		}
		
	}
	
	public static String getChar19DateString() {
		return time.format(new Date());
	}
	public static String getChar4DateString() {
		return time4.format(new Date());
	}
	public static String getChar6DateString() {
		return time6.format(new Date());
	}
	public static String getChar10DateString(Date date) {
		if(date==null){
			return null;
		}else{
			return time10.format(date);
		}
	}
	public static String getChar10DateString() {
		return time10.format(new Date());
	}
	public static String getChar8DateString() {
		return time8.format(new Date());
	}
	
	public static String getChar14DateString() {
		return time14.format(new Date());
	}
	
	public static int getCurrentYear(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return year;
	}
	
	
	public static Timestamp getCurrentDateTime(){
         String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
         Timestamp result = Timestamp.valueOf(nowTime);
         return result;
	}
	
	
	public static String getFormatDateTime(Timestamp time){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
	}
	/**
	* @Title: getAddDate
	* @Description: 得到几天之后的日期。
	* @param addDays
	* @return
	* @throws
	*/
	public static String getAddDate(int addDays){
		 Date date = new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.DATE, addDays);
		 return time10.format(cal.getTime());
	}
	public static String getAddDate(String currentDate,int addDays){
		Date date;
		try {
			date = time10.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, addDays);
		return time10.format(cal.getTime());
	}
	
	public static String getAddMonth(String currentMonth,int addMonth){
		Date date;
		try {
			date = time6.parse(currentMonth);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonth);
		return time6.format(cal.getTime());
	}
	
	/**
	* @Title: getIntervalDays
	* @Description: 等到两个日期间隔几天。
	* @param fromDate 格式 2014-03-19
	* @param endDate 格式 2014-10-20
	* @return
	* @throws
	*/
	public static Integer getIntervalDays(String fromDate,String endDate){
		Date fdate=null;
		Date edate=null;
		try {
			fdate = time10.parse(fromDate);
			edate = time10.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		Calendar cal = Calendar.getInstance();     
        cal.setTime(fdate);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(edate);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24);     
//        return Integer.parseInt(String.valueOf(between_days));//相差几天
        return Integer.parseInt(String.valueOf(between_days))+1;
	}
	public static int getDateDays(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	 public static int differentDays(Date date1,Date date2)
	    {
	        Calendar cal1 = Calendar.getInstance();
	        cal1.setTime(date1);
	        
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(date2);
	         
	        int millisecond1 = cal1.get(Calendar.MILLISECOND );
	        int millisecond2 = cal2.get(Calendar.MILLISECOND );
	        int second1 = cal1.get(Calendar.SECOND );
	        int second2 = cal2.get(Calendar.SECOND ); 

	        int minute1 = cal1.get(Calendar.MINUTE );
	        int minute2 = cal2.get(Calendar.MINUTE );
	        int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
	        int hour2 = cal2.get(Calendar.HOUR_OF_DAY);
	        int day1= cal1.get(Calendar.DAY_OF_YEAR);
	        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
	        int year1 = cal1.get(Calendar.YEAR);
	        int year2 = cal2.get(Calendar.YEAR);
	        if(year1 != year2){
	            int timeDistance = 0 ;
	            for(int i = year1 ; i < year2 ; i ++) {
	                if(i%4==0 && i%100!=0 || i%400==0) {
	                    timeDistance += 366;
	                }
	                else{
	                    timeDistance += 365;
	                }
	            }
	            int day= day2-day1;
	            if(hour2>hour1){
	            	 day+=1;
	            }else if(hour2== hour1&& minute2>minute1){
	            	 day+=1;
	            }else if(hour2== hour1&& minute2==minute1 &&second2>second1){
	            	 day+=1;
	            }else if(hour2== hour1&& minute2==minute1 &&second2==second1 &&millisecond2>millisecond1){
	            	 day+=1;
	            }
	            return timeDistance + day;
	        }else {
	            int day= day2-day1;
	            if(hour2>hour1){
	            	 day+=1;
	            }else if(hour2== hour1&& minute2>minute1){
	            	 day+=1;
	            }else if(hour2== hour1&& minute2==minute1 &&second2>second1){
	            	 day+=1;
	            }else if(hour2== hour1&& minute2==minute1 &&second2==second1 &&millisecond2>millisecond1){
	            	 day+=1;
	            }
	            return day;
	        }
	    }
	public static void main(String[] args) {
		/*String s = getAddMonth("2014-12", 1);
		System.out.println(s);
	int day =	getIntervalDays("2014-03-31","2014-04-01");
	System.out.println(day);
//		boolean is = isWorkDate("2014-05-17");
//		if (is){
//			System.out.println("是工作日");
//		}else{
//			System.out.println("不是工作日");
//		}
	
		System.out.println(getWeekDay(null));*/

		Date date = ToolDateTime.parse("2018-09-29 08:16:38", ToolDateTime.pattern_ymd_hms);
		Date date2 = ToolDateTime.parse("2018-12-29 01:37:00", ToolDateTime.pattern_ymd_hms);
		System.out.println(differentDays(date,date2));
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, -1);
		System.out.println(getChar19DateString(calendar.getTime()));
	}
  public static final long daysInterval(Date fromDate, Date toDate)
  {
    return (toDate.getTime() - fromDate.getTime()) / 86400000L;
  }
  public static final long daysInterval(Date fromDate) {
    if (fromDate == null)
      return 0L;
    Date toDate = new Date();
    return daysInterval(fromDate, toDate);
  }
  @SuppressWarnings("deprecation")
public static final int yearsInterval(Date fromDate, Date toDate) {
    if ((fromDate == null) || (toDate == null))
      return 0;
    return toDate.getYear() - fromDate.getYear();
  }
  public static final String leftDays(Date fromDate) {
    Date toDate = new Date();
    long l = daysInterval(fromDate, toDate);
    l = l * -1L + 1L;
    if (l <= 0L)
      return "到期";
    return String.valueOf(l);
  }
  public static final int yearsInterval(Date fromDate) {
    if (fromDate == null)
      return 0;
    Date toDate = new Date();
    return yearsInterval(fromDate, toDate);
  }
  public static boolean equalsDate(Date d1, Date d2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(d1).equals(sdf.format(d2));
  }
  public static int compareDate(Date d1, Date d2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(d1).compareTo(sdf.format(d2));
  }
  public static String getDate(int days) {
    GregorianCalendar calTmp = new GregorianCalendar();
    calTmp.add(5, -1 * days);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(calTmp.getTime());
  }
  public static Date toDate(int days) {
    GregorianCalendar calTmp = new GregorianCalendar();
    calTmp.add(5, -1 * days);
    return calTmp.getTime();
  }
  public static Date getFirstWeek(Date d) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(d);
    int dayOfWeek = cal.get(7);
    cal.add(5, cal.getActualMinimum(7) - dayOfWeek + 1);
    return cal.getTime();
  }
  public static Date getLastWeek(Date d) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(d);
    int dayOfWeek = cal.get(7);
    cal.add(5, cal.getActualMaximum(7) - dayOfWeek + 2);
    return cal.getTime();
  }
  public static Date getFirstMonth(Date d) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(d);
    int dayOfWeek = cal.get(5);
    cal.add(5, cal.getActualMinimum(5) - dayOfWeek);
    return cal.getTime();
  }
  public static Date getLastMonth(Date d) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(d);
    int dayOfWeek = cal.get(5);
    cal.add(5, cal.getActualMaximum(5) - dayOfWeek + 1);
    return cal.getTime();
  }
  public static Date getFirstYear(Date d) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(d);
    int dayOfWeek = cal.get(6);
    cal.add(5, cal.getActualMinimum(6) - dayOfWeek);
    return cal.getTime();
  }
  public static Date getLastYear(Date d) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(d);
    int dayOfWeek = cal.get(6);
    cal.add(5, cal.getActualMaximum(6) - dayOfWeek + 1);
    return cal.getTime();
  }

  public static Date getStart() {
    Calendar cal = new GregorianCalendar();
    cal.set(2008, 6, 8, 0, 0, 0);
    return cal.getTime();
  }

  public static Date getEnd() {
    Calendar cal = new GregorianCalendar();
    return cal.getTime();
  }
  public static String formatDate(Date date,String format){
	  if(date == null){
		  date = new Date();
	  }
	  SimpleDateFormat sdf = new SimpleDateFormat(format);
	  return sdf.format(date);
  }
  public static Date parseDate(String dateStr,String format) throws ParseException{
	  if(StringHelper.isEmpty(dateStr) || StringHelper.isEmpty(format)){
		  return null;
	  }
	  SimpleDateFormat sdf = new SimpleDateFormat(format);
	  return sdf.parse(dateStr);
  }
  public static void main1(String[] args) throws Exception {
    System.out.println(getDate(0));
    System.out.println(compareDate(new Date(), toDate(1)));
  }
  
  public static String getWeekDay(Date date){
	  if(date == null){
		  date = new Date();
	  }
	  Calendar calendar = Calendar.getInstance();
	  calendar.setTime(date);
	  int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	  switch (dayOfWeek) {
		case 1:
			return "星期日";
		case 2:
			return "星期一";
		case 3:
			return "星期二";
		case 4:
			return "星期三";
		case 5:
			return "星期四";
		case 6:
			return "星期五";
		case 7:
			return "星期六";
		default:
			return "";
	  }
	
  }
  /**
   * 
   * @Title: isPM
   * @Description:
   * @return
   * @        throws
   */
  public static boolean isPM(){
	  GregorianCalendar ca = new GregorianCalendar(); 
	  if(0==ca.get(GregorianCalendar.AM_PM)){
		  return true;
	  }else{
		  return false;
	  }
  }
  /**
   * 查询当前日期前(后)x天的日期 LH
   * 2016年9月9日09:22:16
   * @param date 当前日期
   * @param day 天数,（如果day数为负数,说明是此日期前的天数）
   * @return
   */
  public static Calendar beforNumberCalendar(Date date, int day) {
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      c.add(Calendar.DATE, day);
      return c;
  }
  /**
   * 一个时间段的所有日期(包括起始和终止日期) LH 
   * 2016年9月9日09:20:06
   * @param p_start 起始日期
   * @param p_end	终止日期
   * @return
   */
  public  static List<String> getDates(Calendar p_start, Calendar p_end) {
	  List<String> result = new ArrayList<String>();
      result.add(getDateString(p_start.getTime(), time7));
      Calendar temp = p_start;
      temp.add(Calendar.DATE, 1);
      while (temp.before(p_end)) {
          result.add(getDateString(temp.getTime(), time7));
          temp.add(Calendar.DAY_OF_YEAR, 1);
      }
      result.add(getDateString(p_end.getTime(), time7));
      return result;
  }
  
  public static String getMinutesDistanceDescription(long diff)  {
		long day = 0;
		long hour = 0;
		long min = 0;

		day = diff / (24 * 60 );
		hour = (diff / 60 - day * 24);
		min = (diff  - day * 24 * 60 - hour * 60);
		
		StringBuffer buffer=new StringBuffer();
		if(day>0){
			buffer.append(day).append("天");
		}
		if(hour>0){
			buffer.append(hour).append("小时");
		}
		if(min>0 ){
			buffer.append(min).append("分");
		}
		
		return buffer.toString();
}
  
  
  public static String getHourDistanceDescription(long diff)  {
		long day = 0;
		long hour = 0;
		

		day = diff / (24 );
		hour = (diff - day * 24);
	
		
		StringBuffer buffer=new StringBuffer();
		if(day>0){
			buffer.append(day).append("天");
		}
		if(hour>0){
			buffer.append(hour).append("小时");
		}
		return buffer.toString();
}
  
  
  public static String getDistanceTimes(Date one)  {
		return getDistanceTimes(one, new Date());
  }
  public static String getDistanceTimes(Date begin,Date end){
	long day = 0;
	long hour = 0;
	long min = 0;
	long sec = 0;
	long time1 = begin.getTime();
	long time2 = end.getTime();
	long diff;
	if (time1 < time2) {
		diff = time2 - time1;
	} else {
		diff = time1 - time2;
	}
	day = diff / (24 * 60 * 60 * 1000);
	hour = (diff / (60 * 60 * 1000) - day * 24);
	min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
	sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
	
	//long[] times = { day, hour, min, sec };
	StringBuffer buffer=new StringBuffer();
	if(day>0){
		buffer.append(day).append("天");
	}
	if(hour>0){
		buffer.append(hour).append("小时");
	}
	if(buffer.length()==0 && min>0 ){
		buffer.append(min).append("分");
	}
	
	return buffer.toString();
	}
  
  
  
  public static String getDistanceTimes(Long duration){
	  if(duration==null){
		  return null;
	  }
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		
		long diff=duration;
		
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		
		//long[] times = { day, hour, min, sec };
		StringBuffer buffer=new StringBuffer();
		if(day>0){
			buffer.append(day).append("天");
		}
		if(hour>0){
			buffer.append(hour).append("小时");
		}
		if(buffer.length()==0 && min>0 ){
			buffer.append(min).append("分");
		}
		
		return buffer.toString();
		}
	  
  
  
  
  
  
  public static String computeDistanceTimes(Date beginDate,Date endDate) throws Exception{

		 return computeDistanceTimes(beginDate,endDate,false);
		
	 
  }
  
  

  
  
  public static String computeDistanceTimes(Date beginDate,Date endDate,Boolean is30d) throws Exception{
		 
		 if(beginDate==null){
			 return null;
		 }
		 if(endDate==null){
			 endDate=new Date();
		 }
		 if(beginDate.after(endDate)){
			 return null;
		 }
		 Integer month=0;
		 
		 Calendar conditionCalendar = Calendar.getInstance();
		 conditionCalendar.setTime(beginDate);
		 conditionCalendar.add(Calendar.DAY_OF_MONTH, 30);
		 
		 Calendar beginCalendar = Calendar.getInstance();
		 beginCalendar.setTime(beginDate);
		 
		 while(conditionCalendar.getTime().getTime()<=endDate.getTime()){
			  month++;
			  conditionCalendar.add(Calendar.DAY_OF_MONTH, 30);
			  beginCalendar.add(Calendar.DAY_OF_MONTH, 30);
		 }
		 
		
		long day=0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		long time1 = beginCalendar.getTime().getTime();
		long time2 = endDate.getTime();
		long diff;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		
		
		StringBuffer result=new StringBuffer();
		
		if(month>0){
			result.append(month).append("月").append(day).append("天");
		}else if(day>0){
			result.append(day).append("天").append(hour).append("小时");
		}else if(hour>0){
			result.append(hour).append("小时").append(min).append("分");
		}else{
			result.append(min).append("分").append(sec).append("秒");
		}
		
		 return result.toString();
		 
		 
	 }
  
  	public static Date timeStamp2Date(String timestampString){    
	  Long timestamp = Long.parseLong(timestampString)*1000;    
	  return new Date(timestamp);    
	}
  	
  	public static String date2TimeStamp(Date date) {
        try {
            return String.valueOf(date.getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
  	
  	/**  
     * 凌晨  LH
     * @param date  
     * @flag 0 返回yyyy-MM-dd 00:00:00日期<br>  
     *       1 返回yyyy-MM-dd 23:59:59日期  
     * @return  
     */
  	public static Date weeHours(Date date, int flag) {    
         Calendar cal = Calendar.getInstance();    
         cal.setTime(date);    
         int hour = cal.get(Calendar.HOUR_OF_DAY);    
         int minute = cal.get(Calendar.MINUTE);    
         int second = cal.get(Calendar.SECOND);    
         //时分秒（毫秒数）    
         long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;    
         //凌晨00:00:00    
         cal.setTimeInMillis(cal.getTimeInMillis()-millisecond);    
              
         if (flag == 0) {    
             return cal.getTime();    
         } else if (flag == 1) {    
             //凌晨23:59:59    
             cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);    
         }    
         return cal.getTime();    
     } 
  	
  	public static Date getDate() {
  		Date date=null;
  		try {
  		date=new Date();
// 			date=time.parse("2018-07-04 08:00:01");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return date;
//  		return new Date();
  	}
}