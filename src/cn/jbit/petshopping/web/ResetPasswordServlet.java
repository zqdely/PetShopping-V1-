package cn.jbit.petshopping.web;

import java.io.InputStream;

import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Userinfo;
import cn.jbit.petshopping.util.MD5Secret;
import cn.jbit.petshopping.util.SendEmail;
import cn.jbit.petshopping.util.StringCut;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordServlet extends ActionSupport {
	private String email;
	private String pwd;
	//操作成功的提示信息
	private String info;
	//封装流类型
	private InputStream inputStream;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = MD5Secret.string2MD5(pwd);
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 密码重置发送确认邮件（李迎）
	 * @return
	 */
	public String ResetPwdEmail(){
		return SUCCESS;
	}
	public String PwdEmailSend(){
		UserinfoBiz uib = new UserinfoBizImpl();
		Userinfo users = uib.EmailRestePwd(email);
		if(users!=null){
			SendEmail.Resetsend(users);
			String emailName = StringCut.httpemail(users.getEmail());
			info = emailName;
			return SUCCESS;
		}else{
			info = "您的邮箱还没有注册过";
			return INPUT;
		}
	}
	/**
	 * 通过重置email对接过来的action
	 * @return
	 */
	public String ResetPwdResent(){
			return SUCCESS;	
	}
	/**
	 * 忘记密码重置方法(李迎)
	 * @return
	 */
	public String ResetPassword(){
		UserinfoBiz uib = new UserinfoBizImpl();
		int numback = uib.ResetPassword(pwd, email);
		if(numback>0){
			info="密码重置成功了";
			return SUCCESS;
		}else{
			info = "密码重置失败";
			return INPUT;
		}
		
	}
	
}
