package cn.jbit.petshopping.util;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * ��ȡ�ַ���(����������֤����ӭ)
 * @author Administrator
 *
 */
public class StringCut {
	/**
	 * ��ȡ��������
	 * @param email
	 * @return
	 */
	public static String CutString(String email){
		//��ȡ@���ŵ�λ��
		int num1 = email.lastIndexOf("@");
		//��ȡ.���ŵ�λ��
		int num2 = email.lastIndexOf(".");
		String emailinfo = email.substring((num1+1), num2);
		return emailinfo;
	}
	/**
	 * ���������Ӧ�ĵ�½��վ
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
			//�����������֧��
			return null;
		}
	}
}
