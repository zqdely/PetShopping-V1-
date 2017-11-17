package cn.jbit.petshopping.biz.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.dao.UserinfoDao;
import cn.jbit.petshopping.dao.impl.UserinfoDaoImpl;
import cn.jbit.petshopping.entity.Userinfo;

public class UserinfoBizImpl implements UserinfoBiz {

	public Userinfo userLoging(Userinfo user) {
		UserinfoDao uid = new  UserinfoDaoImpl();
		Userinfo users = uid.userLoging(user);
		return users;
	}

	public int userRegister(Userinfo user) {
		UserinfoDao uid = new  UserinfoDaoImpl();
		int num = uid.userRegister(user);
		return num;
	}

	public int activation(int num,String actionName) {
		UserinfoDao uid = new  UserinfoDaoImpl();
		int numback = uid.activation(num,actionName);
		return numback;
	}

	public int ResetPassword(String password, String email) {
		UserinfoDao uid = new  UserinfoDaoImpl();
		int numback = uid.ResetPassword(password, email);
		return numback;
	}

	public Userinfo EmailRestePwd(String email) {
		UserinfoDao uid = new UserinfoDaoImpl();
		Userinfo userinf = uid.EmailRestePwd(email);
		return userinf;
	}

	public Userinfo nameFind(String name) {
		UserinfoDao uid = new UserinfoDaoImpl();
		Userinfo userinf = uid.nameFind(name);
		return userinf;
	}

	public List<Userinfo> adminindexpage(int pagesize, int pageindex) {
		UserinfoDao uid = new UserinfoDaoImpl();
		List<Userinfo> users = uid.adminindexpage(pagesize, pageindex);
		return users;
	}
	
	/**
	 * 用户的总数量（李凯）
	 * 
	 */
	public int findTotalCount(){
		UserinfoDao uid = new UserinfoDaoImpl();
		return uid.findTotalCount();
	}
	/**
	 * 根据ID查找用户（李凯）
	 * @return
	 */
	public Userinfo findById(Integer id){
		UserinfoDao uid = new UserinfoDaoImpl();
		return uid.findById(id);
	}
	
	/**
	 * 修改用户（李凯）
	 */
	public void updateUser(Userinfo user){
		UserinfoDao uid = new UserinfoDaoImpl();
		uid.updateUser(user);
	}
	
	/**
	 * 根据ID删除用户（李凯）
	 */
	public void delete(Integer id){
		UserinfoDao uid = new UserinfoDaoImpl();
		uid.delete(id);
	}
}
