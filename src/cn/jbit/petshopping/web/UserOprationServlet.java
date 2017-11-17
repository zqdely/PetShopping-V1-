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
 * 用于用户注册登录（李迎）
 * @author lenovo
 *
 */
public class UserOprationServlet extends ActionSupport {
	private String username;
	private Userinfo user;
	//注册时候激活的提示信息
	private String info;
	//激活的时候通过右键action传送过来的用户名
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
	 * 登录
	 * @return
	 */
	public String Login(){
		//创建session，保存登录信息
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserinfoBiz uib = new UserinfoBizImpl();
		Userinfo users = uib.userLoging(user);
		if(users!=null){
			//判断邮箱是否激活
			int acnum = users.getActivation();
			if(acnum==1){
				//判断是否是管理员
				int adminNum = users.getIsadmin();
				if(adminNum==1){
					//管理员用户
					session.put("userinfo", users);		//向session中添加登录用户的信息
					return SUCCESS;
				}else{
					//普通用户
					session.put("userinfo", users);		//向session中添加登录用户的信息
					return "userlogin";
				}
			}else{
				//邮箱没有激活
				///注册成功，显示提示信息
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
			//用户名密码不正确
			info = "您还没有注册我们的账号";
			return INPUT;
		}
	}
	/**
	 * 注册
	 */
	public String Register(){
		UserinfoBiz uib = new UserinfoBizImpl();
		int num = uib.userRegister(user);
		if(num > 0){
			//注册成功，显示提示信息
			String e = user.getEmail();
			String emailName = StringCut.httpemail(e);
			info = emailName;
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	/**
	 *	邮件的激活程序
	 * @return
	 */
	public String activation(){
		UserinfoBiz uib = new UserinfoBizImpl();
		int num = uib.activation(1,actionName);
		if(num>0){
			return SUCCESS;
		}else{
			info = "您激活请求因意外原因失败<br />请重新激活";
			return ERROR;
		}
		
	}
	
}
