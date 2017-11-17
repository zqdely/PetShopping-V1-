package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Userinfo;

public interface UserinfoDao {
	/**
	 * 用于用户登录（李迎）
	 * @return
	 */
	public Userinfo userLoging(Userinfo user);
	/**
	 * 用于用户注册（李迎）
	 * @return
	 */
	public int userRegister(Userinfo user);
	/**
	 * 用户邮件的激活程序(李迎)
	 * @param num
	 * @return
	 */
	public int activation(int num,String actionName);
	/**
	 * 忘记密码，的密码重置程序，通过email发送密码重置请求（李迎）
	 * @param password
	 * @param email
	 * @return
	 */
	public int ResetPassword(String password,String email);
	/**
	 * 密码重置，查询邮箱是否注册过，注册过可以进行密码重置，如果没有注册，提示用户前往注册（李迎）
	 * @return
	 */
	public Userinfo EmailRestePwd(String email);
	/**
	 * 查询用户名是否注册过(李迎)
	 * @param name
	 * @return
	 */
	public Userinfo nameFind(String name);
	/**
	 * 分页查询数据（李凯）
	 * 分页查询数据(李凯)
	 * @return
	 */
	public List<Userinfo> adminindexpage(int pagesize,int pageindex);
	/**
	 * 用户的总数量（李凯）
	 * 用户的总数量(李凯)
	 * 
	 */
	public int findTotalCount();
	/**
	 * 根据ID查找用户（李凯）
	 * @return
	 */
	public Userinfo findById(Integer id);
	
	/**
	 * 修改用户（李凯）
	 */
	public void updateUser(Userinfo user);
	/**
	 * 查询最近注册的六个用户
	 * @return
	 */
	public List<Userinfo> sixperson();
	
	/**
	 * 根据ID删除用户
	 */
	public void delete(Integer id);
}
