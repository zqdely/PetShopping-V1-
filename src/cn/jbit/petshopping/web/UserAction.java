package cn.jbit.petshopping.web;

import java.util.List;
import java.util.Map;

import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.OrderBizImpl;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Userinfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private Userinfo user;
	private UserinfoBiz ub=new UserinfoBizImpl();
	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}
	public String findUser(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		user=(Userinfo) session.get("userinfo");
		if(user!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
