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
	//�����ɹ�����ʾ��Ϣ
	private String info;
	//��װ������
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
	 * �������÷���ȷ���ʼ�����ӭ��
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
			info = "�������仹û��ע���";
			return INPUT;
		}
	}
	/**
	 * ͨ������email�Խӹ�����action
	 * @return
	 */
	public String ResetPwdResent(){
			return SUCCESS;	
	}
	/**
	 * �����������÷���(��ӭ)
	 * @return
	 */
	public String ResetPassword(){
		UserinfoBiz uib = new UserinfoBizImpl();
		int numback = uib.ResetPassword(pwd, email);
		if(numback>0){
			info="�������óɹ���";
			return SUCCESS;
		}else{
			info = "��������ʧ��";
			return INPUT;
		}
		
	}
	
}
