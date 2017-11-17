package cn.jbit.petshopping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	/**
	 * ��ʽ��ʱ��
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
	 * ��ȡ��ǰϵͳʱ��(����String����)
	 * @return
	 */
	public static String nowtime(){
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ
		return dateFormat.format(now);
	}
	
	/**
	 * ��ȡ��ǰʱ���Сʱ��
	 * @return
	 */
	public String systemHour(){
		//���long���͵ĵ�ǰʱ��
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		//ת�������ʽ HH:mm:ss����24Сʱ�� hh:mm:ss����12Сʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//���Сʱ
		SimpleDateFormat dfh = new SimpleDateFormat("HH");
		//�������
		SimpleDateFormat dfm = new SimpleDateFormat("mm");
		//�������
		SimpleDateFormat dfs = new SimpleDateFormat("ss");
		return df.format(date);
	}
}
