package cn.jbit.petshopping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	/**
	 * 格式化时间
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static Date dateFormat(String dateTime) throws ParseException{
		SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
		Date da = date.parse(dateTime);
		return da;
	}
	/**
	 * 获取当前系统时间(返回String类型)
	 * @return
	 */
	public static String nowtime(){
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		return dateFormat.format(now);
	}
	
	/**
	 * 获取当前时间的小时数
	 * @return
	 */
	public String systemHour(){
		//获得long类型的当前时间
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		//转换输出格式 HH:mm:ss代表24小时制 hh:mm:ss代表12小时制
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//输出小时
		SimpleDateFormat dfh = new SimpleDateFormat("HH");
		//输出分钟
		SimpleDateFormat dfm = new SimpleDateFormat("mm");
		//输出秒数
		SimpleDateFormat dfs = new SimpleDateFormat("ss");
		return df.format(date);
	}
}
