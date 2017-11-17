package cn.jbit.petshopping.util;

import cn.jbit.petshopping.entity.Userinfo;

public class SendEmail {
	/**
	 * 注册账号发送的邮件
	 * @param user
	 */
	public static void send(Userinfo user){
		//这个类主要是设置邮件     
	      MailSenderInfo mailInfo = new MailSenderInfo();
	      String[] parama = {"welcome","you"};
	      mailInfo.setAttachFileNames(parama);
	      mailInfo.setMailServerHost("smtp.163.com");      
	      mailInfo.setMailServerPort("25");      
	      mailInfo.setValidate(true);      
	      mailInfo.setUserName("zqdely@163.com");      
	      mailInfo.setPassword("19901006ly");//您的邮箱密码      
	      mailInfo.setFromAddress("zqdely@163.com");      
	      mailInfo.setToAddress(user.getEmail());      
	      mailInfo.setSubject(user.getName()+"欢迎您的加入");    
	      //localhost:8080/PetShopping/login.jsp
	      mailInfo.setContent("请及时确认信息,并<a href='localhost:8080/PetShopping/activation?actionName="+user.getName()+"'>激活</a>激活你的账号,我们期待您的到来!" +
	      		"如果连接不能进去请将<a>http://localhost:8080/PetShopping/activation?actionName="+user.getName()+"</a>"+"地址复制到浏览器");      
	         //这个类主要来发送邮件     
	      try {
			SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 密码重置发送的邮件
	 * @param user
	 */
	public static void Resetsend(Userinfo user){
		//这个类主要是设置邮件     
	      MailSenderInfo mailInfo = new MailSenderInfo();
	      String[] parama = {"welcome","you"};
	      mailInfo.setAttachFileNames(parama);
	      mailInfo.setMailServerHost("smtp.163.com");      
	      mailInfo.setMailServerPort("25");      
	      mailInfo.setValidate(true);      
	      mailInfo.setUserName("zqdely@163.com");      
	      mailInfo.setPassword("19901006ly");//您的邮箱密码      
	      mailInfo.setFromAddress("zqdely@163.com");      
	      mailInfo.setToAddress(user.getEmail());      
	      mailInfo.setSubject(user.getName()+"密码重置确认信息，请妥善保管");    
	      //localhost:8080/PetShopping/login.jsp
	      mailInfo.setContent("请及时确认密码重置的信息,并<a href='localhost:8080/PetShopping/resetsendemailinterface?email="+user.getEmail()+"'>重置</a>你的账号密码！" +
	      		"如果连接不能进去请将<a>http://localhost:8080/PetShopping/resetsendemailinterface?email="+user.getEmail()+"</a>地址复制到浏览器");      
	         //这个类主要来发送邮件     
	      try {
			SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
