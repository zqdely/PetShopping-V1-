package cn.jbit.petshopping.util;

import cn.jbit.petshopping.entity.Userinfo;

public class SendEmail {
	/**
	 * ע���˺ŷ��͵��ʼ�
	 * @param user
	 */
	public static void send(Userinfo user){
		//�������Ҫ�������ʼ�     
	      MailSenderInfo mailInfo = new MailSenderInfo();
	      String[] parama = {"welcome","you"};
	      mailInfo.setAttachFileNames(parama);
	      mailInfo.setMailServerHost("smtp.163.com");      
	      mailInfo.setMailServerPort("25");      
	      mailInfo.setValidate(true);      
	      mailInfo.setUserName("zqdely@163.com");      
	      mailInfo.setPassword("19901006ly");//������������      
	      mailInfo.setFromAddress("zqdely@163.com");      
	      mailInfo.setToAddress(user.getEmail());      
	      mailInfo.setSubject(user.getName()+"��ӭ���ļ���");    
	      //localhost:8080/PetShopping/login.jsp
	      mailInfo.setContent("�뼰ʱȷ����Ϣ,��<a href='localhost:8080/PetShopping/activation?actionName="+user.getName()+"'>����</a>��������˺�,�����ڴ����ĵ���!" +
	      		"������Ӳ��ܽ�ȥ�뽫<a>http://localhost:8080/PetShopping/activation?actionName="+user.getName()+"</a>"+"��ַ���Ƶ������");      
	         //�������Ҫ�������ʼ�     
	      try {
			SimpleMailSender.sendHtmlMail(mailInfo);//����html��ʽ 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �������÷��͵��ʼ�
	 * @param user
	 */
	public static void Resetsend(Userinfo user){
		//�������Ҫ�������ʼ�     
	      MailSenderInfo mailInfo = new MailSenderInfo();
	      String[] parama = {"welcome","you"};
	      mailInfo.setAttachFileNames(parama);
	      mailInfo.setMailServerHost("smtp.163.com");      
	      mailInfo.setMailServerPort("25");      
	      mailInfo.setValidate(true);      
	      mailInfo.setUserName("zqdely@163.com");      
	      mailInfo.setPassword("19901006ly");//������������      
	      mailInfo.setFromAddress("zqdely@163.com");      
	      mailInfo.setToAddress(user.getEmail());      
	      mailInfo.setSubject(user.getName()+"��������ȷ����Ϣ�������Ʊ���");    
	      //localhost:8080/PetShopping/login.jsp
	      mailInfo.setContent("�뼰ʱȷ���������õ���Ϣ,��<a href='localhost:8080/PetShopping/resetsendemailinterface?email="+user.getEmail()+"'>����</a>����˺����룡" +
	      		"������Ӳ��ܽ�ȥ�뽫<a>http://localhost:8080/PetShopping/resetsendemailinterface?email="+user.getEmail()+"</a>��ַ���Ƶ������");      
	         //�������Ҫ�������ʼ�     
	      try {
			SimpleMailSender.sendHtmlMail(mailInfo);//����html��ʽ 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
