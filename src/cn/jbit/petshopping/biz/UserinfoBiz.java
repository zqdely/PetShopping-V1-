package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Userinfo;

public interface UserinfoBiz {
	/**
	 * �����û���¼����ӭ��
	 * @return
	 */
	public Userinfo userLoging(Userinfo user);
	/**
	 * �����û�ע�ᣨ��ӭ��
	 * @return
	 */
	public int userRegister(Userinfo user);
	/**
	 * �û��ʼ��ļ������(��ӭ)
	 * @param num
	 * @return
	 */
	public int activation(int num,String actionName);
	/**
	 * �������룬���������ó���ͨ��email������������������ӭ��
	 * @param password
	 * @param email
	 * @return
	 */
	public int ResetPassword(String password,String email);
	/**
	 * �������ã���ѯ�����Ƿ�ע�����ע������Խ����������ã����û��ע�ᣬ��ʾ�û�ǰ��ע��
	 * @return
	 */
	public Userinfo EmailRestePwd(String email);
	/**
	 * ��ѯ�û����Ƿ�ע���
	 * @param name
	 * @return
	 */
	public Userinfo nameFind(String name);
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Userinfo> adminindexpage(int pagesize,int pageindex);
	
	/**
	 * �û��������������
	 * 
	 */
	public int findTotalCount();
	
	/**
	 * ����ID�����û������
	 * @return
	 */
	public Userinfo findById(Integer id);
	
	/**
	 * �޸��û������
	 */
	public void updateUser(Userinfo user);
	
	/**
	 * ����IDɾ���û������
	 */
	public void delete(Integer id);
}
