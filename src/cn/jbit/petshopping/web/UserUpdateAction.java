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
	 * 根据id查询用户信息显示在输入框（李凯）
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
	 * 更新用户信息
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
