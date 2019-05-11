package com.louis.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtils {

	public static String YYYY_MM_DD = "yyyy-MM-dd";
	public static String YYYYMMDD = "yyyyMMdd";
	public static String YYYYMM = "yyyyMM";
	public static String YYYY_MM = "yyyy-MM";
	public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static String YYYYMMDDHHMM = "yyyyMMddHHmm";
	public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将字符串时间改成Date类型
	 */
	public static Date strToDate(String dateStr, String format) {

		Date date = null;
		try{//如果是时间戳，则直接根据时间戳创建Date对象
			return new Date(Long.valueOf(dateStr));
		}catch(NumberFormatException e){
			
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 将Date时间转成字符串
	 */
	public static String DateToStr(String format, Date date) {
		if(null==date){
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 获取2个字符日期的天数差
	 * 
	 * @return 天数差
	 */
	public static long getDaysOfTowDiffDate(String p_startDate, String p_endDate) {

		Date l_startDate = DateUtils.strToDate(DateUtils.YYYY_MM_DD, p_startDate);
		Date l_endDate = DateUtils.strToDate(DateUtils.YYYY_MM_DD, p_endDate);
		long l_startTime = l_startDate.getTime();
		long l_endTime = l_endDate.getTime();
		long betweenDays = (long) ((l_endTime - l_startTime) / (1000 * 60 * 60 * 24));
		return betweenDays;
	}

	/**
	 * 获取2个Date型日期的分钟数差值
	 * 
	 * @param p_startDate
	 * @param p_endDate
	 * @return 分钟数差值
	 */
	public static long getMinutesOfTowDiffDate(Date p_startDate, Date p_endDate) {
		long l_startTime = p_startDate.getTime();
		long l_endTime = p_endDate.getTime();
		long betweenMinutes = (long) ((l_endTime - l_startTime) / (1000 * 60));
		return betweenMinutes;
	}

	/**
	 * 获取2个字符日期的天数差
	 * 
	 * @param l_startDate
	 * @param l_endDate
	 * @return 天数差
	 */
	public static long getDaysOfTowDiffDate(Date l_startDate, Date l_endDate) {

		long l_startTime = l_startDate.getTime();
		long l_endTime = l_endDate.getTime();
		long betweenDays = (long) ((l_endTime - l_startTime) / (1000 * 60 * 60 * 24));
		return betweenDays;
	}

	/**
	 * 给出日期添加一段时间后的日期
	 * 
	 * @param dateStr
	 * @param plus
	 * @return
	 */
	public static String getPlusDays(String format, String dateStr, long plus) {

		Date date = DateUtils.strToDate(format, dateStr);
		long time = date.getTime() + plus * 24 * 60 * 60 * 1000;

		return DateUtils.DateToStr(format, new Date(time));
	}

	/**
	 * 给出日期添加一段时间后的日期
	 */
	public static String getPlusDays(String format, Date date, long plus) {

		long time = date.getTime() + plus * 24 * 60 * 60 * 1000;

		return DateUtils.DateToStr(format, new Date(time));
	}
	
	public static String dateToOrderno(Date date){
		
		String no = DateToStr(YYYYMMDDHHMMSSSSS,date);
		Random random = new Random();
		int x = random.nextInt(8999);
		x = x+1000;
		no = no+x;
		return no;
	}
	/**
	 * 当前日期减一个月
	 */
	public static Date decreaseMonth(Date date){
		Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.MONTH, -1); 
        return cl.getTime();
	}
	
	/**
	 * 当前日期减一个月
	 * @param date	yyyy-MM
	 * @return	String yyyy-mm
	 */
	public static String decreaseMonth(String date){
		Calendar cl = Calendar.getInstance();  
        cl.set(Calendar.YEAR, Integer.valueOf(date.substring(0,4)));
        cl.set(Calendar.MONTH, Integer.valueOf(date.substring(5,7))-2);
        return DateToStr(YYYY_MM,cl.getTime());
	}
	
	
	/**
	 * 获取日期的上月最后一天
	 */
	public static Date getLastDayOfLastMonth(Date date){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
		return calendar.getTime();
	}
	
	/**
	 *  获取日期的月末时间
	 */
	public static Date getLastDayOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
		return calendar.getTime();
	}
	

}