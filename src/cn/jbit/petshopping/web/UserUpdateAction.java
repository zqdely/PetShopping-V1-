package cn.jbit.petshopping.web;

import java.util.List;

import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.OrderBizImpl;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateAction extends ActionSupport {
	private Integer id;
	private Userinfo user;
	private UserinfoBiz ub=new UserinfoBizImpl();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	/**
	 * ����id��ѯ�û���Ϣ��ʾ����������
	 * @return
	 */
	public String update(){
		user=ub.findById(id);
		if(user!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	/**
	 * �����û���Ϣ
	 * @return
	 */
	public String updateUser(){
		ub.updateUser(user);
		return SUCCESS;
	}
	
	public String delete(){
		ub.delete(id);
		return SUCCESS;
	}
}
