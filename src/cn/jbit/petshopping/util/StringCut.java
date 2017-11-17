package cn.jbit.petshopping.util;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * 截取字符串(用于邮箱验证，李迎)
 * @author Administrator
 *
 */
public class StringCut {
	/**
	 * 获取邮箱类型
	 * @param email
	 * @return
	 */
	public static String CutString(String email){
		//获取@符号的位置
		int num1 = email.lastIndexOf("@");
		//获取.符号的位置
		int num2 = email.lastIndexOf(".");
		String emailinfo = email.substring((num1+1), num2);
		return emailinfo;
	}
	/**
	 * 返回邮箱对应的登陆网站
	 * @return
	 */
	public static String httpemail(String email){
		String emailName = CutString(email);
		if(emailName==null){
			return "error";
		}else if(emailName.equals("qq")){
			return "https://mail.qq.com/";
		}else if(emailName.equals("163")){
			return "http://mail.163.com/";
		}else{
			//添加其他邮箱支持
			return null;
		}
	}
}
