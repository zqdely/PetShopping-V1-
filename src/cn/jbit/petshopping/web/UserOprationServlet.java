package cn.jbit.petshopping.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Userinfo;
import cn.jbit.petshopping.util.MailSenderInfo;
import cn.jbit.petshopping.util.SendEmail;
import cn.jbit.petshopping.util.SimpleMailSender;
import cn.jbit.petshopping.util.StringCut;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * �����û�ע���¼����ӭ��
 * @author lenovo
 *
 */
public class UserOprationServlet extends ActionSupport {
	private String username;
	private Userinfo user;
	//ע��ʱ�򼤻����ʾ��Ϣ
	private String info;
	//�����ʱ��ͨ���Ҽ�action���͹������û���
	private String actionName;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username.lastIndexOf("@")>0){
			user.setEmail(username);
		}else{
			user.setName(username);
		}
		this.username = username;
	}

	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * ��¼
	 * @return
	 */
	public String Login(){
		//����session�������¼��Ϣ
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserinfoBiz uib = new UserinfoBizImpl();
		Userinfo users = uib.userLoging(user);
		if(users!=null){
			//�ж������Ƿ񼤻�
			int acnum = users.getActivation();
			if(acnum==1){
				//�ж��Ƿ��ǹ���Ա
				int adminNum = users.getIsadmin();
				if(adminNum==1){
					//����Ա�û�
					session.put("userinfo", users);		//��session����ӵ�¼�û�����Ϣ
					return SUCCESS;
				}else{
					//��ͨ�û�
					session.put("userinfo", users);		//��session����ӵ�¼�û�����Ϣ
					return "userlogin";
				}
			}else{
				//����û�м���
				///ע��ɹ�����ʾ��ʾ��Ϣ
				String e = users.getEmail();
				String emailName = StringCut.httpemail(e);
				if(emailName.equals("error")){
					return ERROR;
				}else{
					info = emailName;
					return "emailurl";
				}
			}
			
		}else{
			//�û������벻��ȷ
			info = "����û��ע�����ǵ��˺�";
			return INPUT;
		}
	}
	/**
	 * ע��
	 */
	public String Register(){
		UserinfoBiz uib = new UserinfoBizImpl();
		int num = uib.userRegister(user);
		if(num > 0){
			//ע��ɹ�����ʾ��ʾ��Ϣ
			String e = user.getEmail();
			String emailName = StringCut.httpemail(e);
			info = emailName;
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	/**
	 *	�ʼ��ļ������
	 * @return
	 */
	public String activation(){
		UserinfoBiz uib = new UserinfoBizImpl();
		int num = uib.activation(1,actionName);
		if(num>0){
			return SUCCESS;
		}else{
			info = "����������������ԭ��ʧ��<br />�����¼���";
			return ERROR;
		}
		
	}
	
}
